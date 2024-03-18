package com.petpals.pals.entrypoints.pals.controllers;

import com.petpals.pals.entrypoints.pals.dto.AddPal;
import com.petpals.pals.domain.pals.inputs.SavePalsService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller(value = "/pals")
public class SavePalController {
    private static final Logger logger = LoggerFactory.getLogger(SavePalController.class);
    private final SavePalsService palService;
    @Inject
    public SavePalController(SavePalsService savePalsService) {
        this.palService = savePalsService;
    }

    @Post(produces = MediaType.TEXT_PLAIN, consumes =  MediaType.APPLICATION_JSON) // (2)
    public String createFirstPalWithOwner(@Valid AddPal addPalThis) {
        logger.info("Calling createFirstPalWithOwner");
        logger.info("Received new payload for addPal :" + addPalThis);
        return  palService.SavePal(addPalThis); // (3)
    }

    @Get(produces = MediaType.TEXT_PLAIN, consumes = MediaType.TEXT_PLAIN, value = "/{helloPal}")
    public String helloPal(@NotBlank @PathVariable("helloPal") String pal){
        return palService.helloPal(pal);
    }
}

