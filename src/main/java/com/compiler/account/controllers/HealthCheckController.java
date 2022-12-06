package com.compiler.account.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/v1")
public class HealthCheckController {
    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
