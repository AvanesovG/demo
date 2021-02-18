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

    private final UserParser userParser;
    private final UserValidator userValidator;
    private final UserSava userSava;

    public BootstrapRunner(UserParser userParser, UserValidator userValidator, UserSava userSava) {

        this.userParser = userParser;
        this.userValidator = userValidator;

        this.userSava = userSava;
    }

    @Override
    public void run(String... args) throws Exception {
        List<UserModel> list = userParser.parse(paths);
        List<UserModel> userModel = userValidator.validate(list);
        userSava.addDatabase(userModel);


    }

}
