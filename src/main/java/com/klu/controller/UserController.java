package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.User;
import com.klu.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService service;

    // 🔹 Student Register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    // 🔹 Admin Register
    @PostMapping("/admin/register")
    public User registerAdmin(@RequestBody User user) {
        user.setRole("admin");
        return service.register(user);
    }

    // 🔹 Login
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return service.login(user.getEmail(), user.getPassword());
    }

    // 🔹 Get all users
    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    // 🔹 Delete user
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    // 🔹 Test
    @GetMapping("/test")
    public String test() {
        return "Backend Working";
    }
}