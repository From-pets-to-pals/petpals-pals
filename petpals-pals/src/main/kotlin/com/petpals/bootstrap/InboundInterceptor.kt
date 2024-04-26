package com.petpals.bootstrap
import com.petpals.shared.errorhandling.ExceptionsEnum
import com.petpals.shared.errorhandling.PetPalsExceptions
import jakarta.ws.rs.container.ContainerRequestContext
import jakarta.ws.rs.container.ContainerRequestFilter
import jakarta.ws.rs.core.Context
import jakarta.ws.rs.core.UriInfo
import org.eclipse.microprofile.config.inject.ConfigProperty

class InboundInterceptor: ContainerRequestFilter {
    @field:ConfigProperty(name = "api.key")
    lateinit var apiKey: String

    @field:Context
    lateinit var uriInfo: UriInfo

    override fun filter(context: ContainerRequestContext) {
        if (context.getHeaderString("API-KEY") == null || context.getHeaderString("API-KEY") != apiKey) {
            if (uriInfo.path == "/hello") {
                return
            }
            throw PetPalsExceptions(ExceptionsEnum.CAREGIVERS_MISSING_API_KEY)
        }
    }
}