package com.example.demo.service;

import com.example.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootstrapRunner implements CommandLineRunner {

    @Value("${pathFile}")
    List<String> paths;

    final UserParser userParser;
    final UserValidator userValidator;


    public BootstrapRunner(UserParser userParser, UserValidator userValidator) {

        this.userParser = userParser;
        this.userValidator = userValidator;
    }

    @Override
    public void run(String... args) throws Exception {
        List<UserModel> userToValidate = userParser.parse(paths);
        userValidator.validate(userToValidate);
        



    }
}
