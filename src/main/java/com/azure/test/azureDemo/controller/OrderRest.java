package com.azure.test.azureDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRest {

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test success");
    }
}
