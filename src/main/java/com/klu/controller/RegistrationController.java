package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Registration;
import com.klu.service.RegistrationService;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin("*")
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping
    public Registration register(@RequestBody Registration r) {
        return service.save(r);
    }

    @GetMapping
    public List<Registration> getAll() {
        return service.getAll();
    }
}