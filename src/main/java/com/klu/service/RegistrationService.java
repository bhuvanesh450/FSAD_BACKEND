package com.klu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.model.Registration;
import com.klu.repository.RegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repo;

    public Registration save(Registration r) {
        return repo.save(r);
    }

    public List<Registration> getAll() {
        return repo.findAll();
    }
}