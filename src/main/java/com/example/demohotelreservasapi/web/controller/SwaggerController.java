package com.example.demohotelapi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("/api/v1/hoteis/swagger")
    public String redirectToSwagger() {
        return "redirect:/docs-hotel.html";
    }
}