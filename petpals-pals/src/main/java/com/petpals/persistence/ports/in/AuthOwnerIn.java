package com.petpals.persistence.ports.in;

import com.petpals.persistence.dto.AuthOwnerDto;

public interface AuthOwnerIn {
    String authOwner(AuthOwnerDto pal);
}
