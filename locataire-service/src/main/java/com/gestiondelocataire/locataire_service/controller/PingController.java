package com.gestiondelocataire.locataire_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//indique a spring c'est un controller
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "le service est en marche";
    }
}
