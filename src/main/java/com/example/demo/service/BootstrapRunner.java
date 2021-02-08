package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootstrapRunner implements CommandLineRunner {
    final UserParser userParser;

    public BootstrapRunner(UserParser userParser) {
        this.userParser = userParser;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userParser.parse(List.of()));
    }
}
