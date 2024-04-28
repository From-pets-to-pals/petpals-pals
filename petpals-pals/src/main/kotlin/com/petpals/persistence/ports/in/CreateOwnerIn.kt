package com.petpals.persistence.ports.`in`

import com.petpals.persistence.entities.Pals


interface CreateOwnerIn {
    fun createOwnerWithFirstPal(palName: Pals): String
}