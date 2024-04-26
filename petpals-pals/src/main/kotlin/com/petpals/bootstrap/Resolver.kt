package com.petpals.bootstrap

import io.quarkus.hibernate.orm.PersistenceUnitExtension
import io.quarkus.hibernate.orm.runtime.tenant.TenantResolver
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
@PersistenceUnitExtension
class Resolver : TenantResolver {
    override fun getDefaultTenantId(): String {
        return "azure"
    }

    override fun resolveTenantId(): String {
        return "azure"
    }
}
