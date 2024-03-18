package com.petpals.pals.domain.pals.model;

public record Owner(
        String email,
        String functionalId,
        String deviceId,
        String location
) {
}
