package com.petpals.pets.bootstrap.lol;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class TestController {
    @ApiResponse(responseCode = "200", description = "Say Hello")
    @GetMapping(value = "/msg", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(){
        return "HelloWorld";
    }
}
