package com.petpals.persistence.ports.in;

import com.petpals.persistence.entities.Owners;


public interface CreateOwnerIn {
    Long createOwnerWithFirstPal(Owners pal);
}