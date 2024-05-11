package com.example.demohotelreservasapi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("api/v1/reservas/swagger")
    public String redirectToSwagger() {
        return "redirect:/docs-reserva-hotel.html";
    }
}