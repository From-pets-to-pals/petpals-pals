package com.petpals.domain.ports.`in`

import com.petpals.domain.model.Pals

interface CreateOwnerIn {
    fun createOwnerWithFirstPal(palName: Pals): String
}