package com.petpals.pals.entrypoints.pals.controllers;

import com.petpals.pals.entrypoints.pals.dto.Try;
import com.petpals.pals.domain.pals.services.SavePalsService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

@Controller(value = "/pals")
public class SavePalController {
    private final SavePalsService palService;
    @Inject
    public SavePalController(SavePalsService savePalsService) {
        this.palService = savePalsService;
    }

    @Get(produces = MediaType.TEXT_PLAIN, consumes =  MediaType.APPLICATION_JSON, value = "/pal") // (2)
    public String index(@Valid Try tryThis) {
        return  palService.SavePal(tryThis.name()); // (3)
    }
}

