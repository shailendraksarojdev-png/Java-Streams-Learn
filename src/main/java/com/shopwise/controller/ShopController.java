package com.shopwise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class ShopController {

    @GetMapping("health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("api/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Hello from Shopwise!");
    }
}

