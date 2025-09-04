package com.prueba.gateway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GatewayController {
    
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getGatewayInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("service", "API Gateway");
        info.put("version", "1.0.0");
        info.put("description", "Gateway para microservicios de gestión académica");
        
        Map<String, Object> services = new HashMap<>();
        services.put("student-service", "http://localhost:8082/api/students");
        services.put("course-service", "http://localhost:8081/api/courses");
        services.put("grade-service", "http://localhost:8083/api/grades");
        
        info.put("available-services", services);
        
        return ResponseEntity.ok(info);
    }
    
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> health = new HashMap<>();
        health.put("status", "UP");
        health.put("message", "Gateway is running");
        return ResponseEntity.ok(health);
    }
}
