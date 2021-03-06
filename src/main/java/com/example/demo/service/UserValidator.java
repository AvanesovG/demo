package com.example.demo.service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserValidator {
    private  UserModel userModel;


    private final Logger log = LoggerFactory.getLogger(UserValidator.class);


    private final Validator validator;


    public UserValidator(@Qualifier("userValidatorFactory") Validator validator) {
        this.validator = validator;
    }


    public List<UserModel> validate(List<UserModel> list) {
List<UserModel>modelList = new ArrayList<>();
        for (UserModel model : list) {
            Set<ConstraintViolation<UserModel>> violations = validator.validate(model);
            if (violations.size() == 0)
               modelList.add(model);
            for (ConstraintViolation<UserModel> violation : violations) {
                log.error(violation.getMessage());

            }
        }
        return modelList;
    }
}
