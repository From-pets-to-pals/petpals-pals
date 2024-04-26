package com.petpals.bootstrap

import com.azure.identity.ClientSecretCredentialBuilder
import com.azure.security.keyvault.secrets.SecretClientBuilder
import com.petpals.application.entrypoints.CreateOwnerResource
import io.smallrye.config.ConfigSourceContext
import io.smallrye.config.ConfigSourceFactory
import io.smallrye.config.PropertiesConfigSource
import org.eclipse.microprofile.config.spi.ConfigSource
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class AzureConfigSourceFactory : ConfigSourceFactory {
    private  val logger: Logger = LoggerFactory.getLogger(ConfigSourceFactory::class.java)

    private val PALS_API_KEY = "pals.api.key"
    override fun getConfigSources(context: ConfigSourceContext): Iterable<ConfigSource> {
        val caregiversApiKey = context.getValue(PALS_API_KEY)
        val conf: MutableMap<String, String> = HashMap()
        if (caregiversApiKey == null || caregiversApiKey.value == null) {
            val clientId = context.getValue("azure.clientid").value
            val tenantId = context.getValue("azure.tenantid").value
            val secret = context.getValue("azure.tenant.token").value
            val vaultUrl = context.getValue("azure.vault.url").value
            val secretClient = SecretClientBuilder()
                .vaultUrl(vaultUrl)
                .credential(
                    ClientSecretCredentialBuilder()
                        .tenantId(tenantId)
                        .clientSecret(secret)
                        .clientId(clientId)
                        .build()
                )
                .buildClient()
            conf[PALS_API_KEY] = secretClient.getSecret("PALS-API-KEY").value
            return listOf<ConfigSource>(PropertiesConfigSource(conf, null, priority.asInt))
        }
        conf[PALS_API_KEY] = caregiversApiKey.value

        return listOf<ConfigSource>(PropertiesConfigSource(conf, caregiversApiKey.sourceName, priority.asInt))
    }

    override fun getPriority(): OptionalInt {
        return OptionalInt.of(275)
    }
}