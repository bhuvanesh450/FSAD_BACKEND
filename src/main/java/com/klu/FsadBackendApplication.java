package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.klu.repository")
@EntityScan(basePackages = "com.klu.model")
public class FsadBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsadBackendApplication.class, args);
    }
}
