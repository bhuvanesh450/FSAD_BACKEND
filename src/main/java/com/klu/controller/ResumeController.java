package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Resume;
import com.klu.service.ResumeService;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin("*")
public class ResumeController {

    @Autowired
    private ResumeService service;

    @PostMapping
    public Resume submit(@RequestBody Resume r) {
        return service.submit(r);
    }

    @GetMapping
    public List<Resume> getAll() {
        return service.getAll();
    }
}