package com.petpals.domain.services

import com.petpals.domain.model.Pals
import com.petpals.domain.ports.`in`.CreateOwnerIn
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CreateOwner : CreateOwnerIn
{
    override fun createOwnerWithFirstPal(palName: Pals): String {
        return "Lol"
    }
}