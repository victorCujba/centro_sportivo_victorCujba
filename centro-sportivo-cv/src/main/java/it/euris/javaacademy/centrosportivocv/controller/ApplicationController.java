package it.euris.javaacademy.centrosportivocv.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @GetMapping
    @RequestMapping("/")
    @Operation(description = """
            This method is test method return that aplication is alive.
            """)

    public String isAlive() {
        return "I'm alive";
    }

}

