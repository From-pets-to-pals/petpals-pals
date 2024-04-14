package com.petpals.pals;

import io.micronaut.context.annotation.Value;
import io.micronaut.core.order.Ordered;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.RequestFilter;
import io.micronaut.http.annotation.ServerFilter;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.http.filter.ServerFilterPhase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerFilter(value = {"/pals/**", "/caregivers/**", "/owners/**"})
public class InboundInterceptor implements Ordered {
	private static final Logger logger = LoggerFactory.getLogger(InboundInterceptor.class);

	@Value("${api.key}")
	private String apiKey;
	@RequestFilter
	void filterRequest(HttpRequest<?> request)  {
		if(logger.isInfoEnabled()){
			logger.info(String.format("Filtered request %s", request.getHeaders().toString()));
		}
		if(!request.getHeaders().contains("API-KEY") || !request.getHeaders().get("API-KEY").equals(apiKey)){
			throw new HttpStatusException(HttpStatus.UNAUTHORIZED, "Invalid API-KEY");
		}
	}
	@Override
	public int getOrder() {
		return ServerFilterPhase.FIRST.order();
	}
}