package com.petpals.persistence.ports.in;

import com.petpals.persistence.entities.Owners;
import com.petpals.persistence.entities.Pals;


public interface CreateOwnerIn {
    String createOwnerWithFirstPal(Owners pal);
}