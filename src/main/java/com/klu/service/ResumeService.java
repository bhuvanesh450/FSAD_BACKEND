package com.klu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.model.Resume;
import com.klu.repository.ResumeRepository;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepository repo;

    public Resume submit(Resume r) {
        r.setStatus("Pending");
        return repo.save(r);
    }

    public List<Resume> getAll() {
        return repo.findAll();
    }

    public Resume updateStatus(Long id, String status) {
        Resume r = repo.findById(id).orElse(null);
        if (r != null) {
            r.setStatus(status);
            return repo.save(r);
        }
        return null;
    }
}