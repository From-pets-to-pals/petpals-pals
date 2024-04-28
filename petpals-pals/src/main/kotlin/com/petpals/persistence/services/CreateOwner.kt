package com.petpals.persistence.services

import com.petpals.persistence.ports.`in`.CreateOwnerIn
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CreateOwner : CreateOwnerIn
{
    override fun createOwnerWithFirstPal(palName: Pals): String {
        return "Lol"
    }
}