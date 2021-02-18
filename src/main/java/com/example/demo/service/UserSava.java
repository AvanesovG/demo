package com.example.demo.service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSava {
    private  final UserRepository userRepository;

    public UserSava(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addDatabase(List<UserModel> userModel){

        userRepository.saveAll(userModel);
        }


    }

