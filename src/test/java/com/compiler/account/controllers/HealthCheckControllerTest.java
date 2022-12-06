package com.compiler.account.controllers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HealthCheckControllerTest {
    @Autowired
    private HealthCheckController healthCheckController;

    @Test
    public void health() {
        Assertions.assertNotNull(healthCheckController.healthCheck());
    }
}