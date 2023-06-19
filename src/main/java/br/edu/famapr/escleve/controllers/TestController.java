package br.edu.famapr.escleve.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello") // Mapeia a requisição GET para "/api/hello"
    public String helloWorld() {
        return "Olá, mundo!";
    }


}

