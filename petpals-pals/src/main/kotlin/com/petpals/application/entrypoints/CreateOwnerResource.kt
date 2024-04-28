package com.petpals.application.entrypoints

import com.petpals.application.dto.AddFirstPal
import com.petpals.persistence.entities.Owners
import com.petpals.persistence.entities.Pals
import com.petpals.persistence.ports.`in`.CreateOwnerIn
import jakarta.enterprise.inject.Default
import jakarta.inject.Inject
import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Path("/pals")
@SecurityRequirement(name = "api_key")
class CreateOwnerResource {
    private  val logger: Logger = LoggerFactory.getLogger(CreateOwnerResource::class.java)

    @Inject
    @field:Default
    private lateinit var ownersService: CreateOwnerIn

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createOwnerWithFirstPal(
        newPal: @Valid AddFirstPal
    ): String {
        logger.info("Calling createFirstPalWithOwner")
        logger.info("Received new payload for newPal :$newPal")
        val owner = Owners(
            newPal.owner.reference,
            newPal.owner.deviceId,
            newPal.owner.location,
            newPal.owner.email
        )
        val palToRegister = Pals(
            newPal.name,
            newPal.shortName,
            newPal.icadIdentifier,
            owner,
            newPal.birthDate,
            newPal.specie.name,
            newPal.breed,
            newPal.hasPassport,
            newPal.isMale,
            newPal.isSterilized,
            newPal.isVaccinated,
            null,
            null,
            newPal.reference
        )
        return ownersService.createOwnerWithFirstPal(palToRegister) // (3)
    }
}