package com.petpals.bootstrap.tenant;

import io.quarkus.hibernate.orm.PersistenceUnitExtension;
import io.quarkus.hibernate.orm.runtime.tenant.TenantResolver;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
@PersistenceUnitExtension
public class Resolver implements TenantResolver {
    @ConfigProperty(name = "azure.tenantid")
    String tenantId;
    @Override
    public String getDefaultTenantId() {
        return tenantId;
    }

    @Override
    public String resolveTenantId() {
        return tenantId;
    }
}
