package com.compiler.account.controllers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class HealthCheckControllerTest {
    @InjectMocks
    private HealthCheckController healthCheckController;

    @Test
    public void health() {
        Assertions.assertNotNull(healthCheckController.healthCheck());
    }
}