package com.petpals.bootstrap.interceptors;

import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import io.smallrye.config.ConfigSourceContext;
import io.smallrye.config.ConfigSourceFactory;
import io.smallrye.config.ConfigValue;
import io.smallrye.config.PropertiesConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class AzureConfigSourceFactory implements ConfigSourceFactory {
	private static final String PALS_API_KEY = "pals.api.key";
	@Override
	public Iterable<ConfigSource> getConfigSources(final ConfigSourceContext context) {
		final ConfigValue caregiversApiKey = context.getValue(PALS_API_KEY);
		Map<String,String> conf = new HashMap<>();
		if (caregiversApiKey == null || caregiversApiKey.getValue() == null) {
			String clientId = context.getValue("azure.clientid").getValue();
			String tenantId = context.getValue("azure.tenantid").getValue();
			String secret = context.getValue("azure.tenant.token").getValue();
			String vaultUrl = context.getValue("azure.vault.url").getValue();
			SecretClient secretClient = new SecretClientBuilder()
												.vaultUrl(vaultUrl)
												.credential(new ClientSecretCredentialBuilder()
																	.tenantId(tenantId)
																	.clientSecret(secret)
																	.clientId(clientId)
																	.build())
												.buildClient();
			conf.put(PALS_API_KEY,secretClient.getSecret("PALS-API-KEY").getValue());
			return Collections.singletonList(new PropertiesConfigSource(conf,null, getPriority().getAsInt()));
		}
		conf.put(PALS_API_KEY,caregiversApiKey.getValue());
		
		return Collections.singletonList(new PropertiesConfigSource(conf,caregiversApiKey.getSourceName(), getPriority().getAsInt()));
	}
	
	@Override
	public OptionalInt getPriority() {
		return OptionalInt.of(275);
	}
}