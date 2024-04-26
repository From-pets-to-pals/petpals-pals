package com.petpals.bootstrap


import com.azure.identity.ClientSecretCredentialBuilder
import com.azure.security.keyvault.secrets.SecretClient
import com.azure.security.keyvault.secrets.SecretClientBuilder
import io.agroal.api.AgroalDataSource
import io.agroal.api.configuration.supplier.AgroalDataSourceConfigurationSupplier
import io.agroal.api.security.NamePrincipal
import io.agroal.api.security.SimplePassword
import io.agroal.api.transaction.TransactionIntegration
import io.agroal.narayana.NarayanaTransactionIntegration
import io.quarkus.hibernate.orm.PersistenceUnitExtension
import io.quarkus.hibernate.orm.runtime.customized.QuarkusConnectionProvider
import io.quarkus.hibernate.orm.runtime.tenant.TenantConnectionResolver
import jakarta.transaction.TransactionManager
import jakarta.transaction.TransactionSynchronizationRegistry
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider
import org.jboss.logging.Logger
import java.sql.SQLException
import java.time.Duration
import java.time.temporal.ChronoUnit

@PersistenceUnitExtension
class DatasourceResolver (
    var transactionManager: TransactionManager,
    var transactionSynchronizationRegistry: TransactionSynchronizationRegistry
) :
    TenantConnectionResolver {
    private val LOG: Logger = Logger.getLogger(DatasourceResolver::class.java)


    @field:ConfigProperty(name = "azure.tenantid")
    lateinit var tenantId: String

    @field:ConfigProperty(name = "azure.tenant.token")
    lateinit var secret: String

    @field:ConfigProperty(name = "azure.clientid")
    lateinit var clientId: String

    private val KEY_VAULT_URI = "https://petpals-key-vault.vault.azure.net"

    private fun createDatasource(): AgroalDataSource {
        val secretClient: SecretClient = SecretClientBuilder()
            .vaultUrl(KEY_VAULT_URI)
            .credential(
                ClientSecretCredentialBuilder()
                    .tenantId(tenantId)
                    .clientSecret(secret)
                    .clientId(clientId)
                    .build()
            )
            .buildClient()
        LOG.info("Retrieving secrets from Azure key vault")
        val url: String = (secretClient.getSecret("DB-URL").getValue() + "/" + secretClient.getSecret("DB-NAME")
            .getValue()).toString() + "?currentSchema=" + secretClient.getSecret("DB-NAME").getValue()
        LOG.info("Secrets successfully retrieved")
        val dataSourceConfiguration = AgroalDataSourceConfigurationSupplier()

        val poolConfiguration = dataSourceConfiguration.connectionPoolConfiguration()

        val txIntegration: TransactionIntegration = NarayanaTransactionIntegration(
            transactionManager,
            transactionSynchronizationRegistry, null, false, null
        )
        poolConfiguration
            .initialSize(2)
            .maxSize(10)
            .minSize(2)
            .maxLifetime(Duration.of(5, ChronoUnit.MINUTES))
            .acquisitionTimeout(Duration.of(30, ChronoUnit.SECONDS))
            .transactionIntegration(txIntegration) //This part, specify transaction integration

        val connectionFactoryConfiguration = poolConfiguration.connectionFactoryConfiguration()

        connectionFactoryConfiguration
            .jdbcUrl("jdbc:postgresql://$url")
            .credential(NamePrincipal((secretClient.getSecret("DB-ADMIN").getValue())))
            .credential(SimplePassword((secretClient.getSecret("DB-PASSWORD").getValue())))
        try {
            LOG.info("Building Datasource from secrets")
            return AgroalDataSource.from(dataSourceConfiguration.get())
        } catch (ex: SQLException) {
            throw IllegalStateException(
                "Failed to create a new data source based on the existing datasource configuration",
                ex
            )
        }
    }

    override fun resolve(tenantId: String): ConnectionProvider {
        return QuarkusConnectionProvider(createDatasource())
    }
}