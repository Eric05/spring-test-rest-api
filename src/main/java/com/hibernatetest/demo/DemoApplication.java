package com.hibernatetest.demo;

import com.hibernatetest.demo.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {


    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
