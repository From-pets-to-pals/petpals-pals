package com.petpals.application.entrypoints

import com.petpals.application.dto.AddFirstPal
import com.petpals.domain.model.*
import com.petpals.domain.ports.`in`.CreateOwnerIn
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
        val palIdentityInformation = PalIdentityInformation(
            newPal.name,
            newPal.birthDate,
            newPal.isMale,
            newPal.specie,
            newPal.race,
            newPal.icadIdentifier,
            newPal.hasPassport
        )

        val palMeasurement = PalMeasurement(newPal.weight, newPal.height)
        val palMedicalInformation = PalMedicalInformation(
            newPal.isVaccinated,
            ArrayList<String>(),
            null,
            null,
            newPal.isSterilized
        )
        val palOwner = Owner(
            newPal.owner.email,
            newPal.owner.functionalId,
            newPal.owner.deviceId,
            newPal.owner.location
        )
        val palToRegister = Pals(
            null,
            null,
            palMedicalInformation,
            palIdentityInformation,
            palMeasurement,
            palOwner,
            false
        )
        return ownersService.createOwnerWithFirstPal(palToRegister) // (3)
    }
}