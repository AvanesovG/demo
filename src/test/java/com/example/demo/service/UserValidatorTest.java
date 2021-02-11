package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.validation.Validator;
import java.util.List;

class UserValidatorTest {
    Validator validator = Mockito.mock(Validator.class);
    UserValidator userValidator = new UserValidator(validator);
    @Test
    void shouldValidate() {
        userValidator.validate(List.of());



    }

}