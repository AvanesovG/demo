package com.example.demo.service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;
import java.util.List;

@Component
public class BootstrapRunner implements CommandLineRunner {
    List<UserModel> userToValidate;

    @Value("${pathFile}")
    List<String> paths;

    private final UserParser userParser;
    private final UserValidator userValidator;
    private final UserRepository userRepository;

    public BootstrapRunner(UserParser userParser, UserValidator userValidator, UserRepository userRepository) {

        this.userParser = userParser;
        this.userValidator = userValidator;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<UserModel> list = userToValidate = userParser.parse(paths);
        userValidator.validate(userToValidate);
        addDataBase(list);


    }

    public void addDataBase(@Valid @ModelAttribute("usermodel") List<UserModel> userModel) {
        userRepository.saveAll(userModel);
        System.out.println(userModel);

    }
}
