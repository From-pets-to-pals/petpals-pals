package com.petpals.pals;

import io.micronaut.core.order.Ordered;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.RequestFilter;
import io.micronaut.http.annotation.ServerFilter;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.http.filter.ServerFilterPhase;

@ServerFilter(value = {"/pals/**", "/caregivers/**", "/owners/**"})
public class InboundInterceptor implements Ordered {
	
	@RequestFilter
	void filterRequest(HttpRequest<?> request)  {
		if(!request.getHeaders().contains("API-KEY")){
			throw new HttpStatusException(HttpStatus.UNAUTHORIZED, "Invalid API-KEY");
		}
	}
	@Override
	public int getOrder() {
		return ServerFilterPhase.FIRST.order();
	}
}