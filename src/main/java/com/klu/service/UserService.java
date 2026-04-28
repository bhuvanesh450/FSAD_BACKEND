package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.User;
import com.klu.repository.UserRepository;

@Service
public class UserService {

   @Autowired
private UserRepository repo;

    // 🔹 Register (student + admin)
    public User register(User user) {

        // check duplicate email
        if (repo.findByEmail(user.getEmail()) != null) {
            return null;
        }

        // default role
        if (user.getRole() == null) {
            user.setRole("student");
        }

        return repo.save(user);
    }

    // 🔹 Get all users
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    // 🔹 Delete user
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    // 🔹 Login
    public User login(String email, String password) {

        if (email == null || password == null) {
            return null;
        }

        try {
            User user = repo.findByEmail(email);

            if (user != null &&
                user.getPassword() != null &&
                user.getPassword().equals(password)) {

                return user;
            }

            return null;

        } catch (Exception e) {
            return null;
        }
    }
}
