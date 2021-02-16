package com.example.demo.service;

import com.example.demo.config.UserConfig;
import com.example.demo.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserParser {

    private final ObjectMapper objectMapper;


    public UserParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public List<UserModel> parse(List<String> list) throws JsonProcessingException {


        String fileContent1 = "{\n" +
                "\"name\":\"heffy\",\n" +
                "\"surname\":\"hey\",\n" +
                "\"email\":\"hello@mail.ru\"\n" +
                "}";
        String fileContent2 = "{\n" +
                "\"name\":\"hy\",\n" +
                "\"surname\":\"hey\",\n" +
                "\"email\":\"hello@mail.ru\"\n" +
                "}";
        String fileContent3 = "{\n" +
                "\"name\":\"heffy\",\n" +
                "\"surname\":\"hey\",\n" +
                "\"email\":\"hello@mail.ru\"\n" +
                "}";
        String fileContent4 = "{\n" +
                "\"name\":\"heffy\",\n" +
                "\"surname\":\"hey\",\n" +
                "\"email\":\"hell\"\n" +
                "}";
        String fileContent5 = "{\n" +
                "\"name\":\"heffy\",\n" +
                "\"surname\":\"hey\",\n" +
                "\"email\":\"hello@mail.ru\"\n" +
                "}";
        String fileContent6 = "{\n" +
                "\"name\":\"fy\",\n" +
                "\"surname\":\"hey\",\n" +
                "\"email\":\"hello@mail.ru\"\n" +
                "}";


        UserModel userModel1 = objectMapper.readValue(fileContent1, UserModel.class);
        UserModel userModel2 = objectMapper.readValue(fileContent2, UserModel.class);
        UserModel userModel3 = objectMapper.readValue(fileContent3, UserModel.class);
        UserModel userModel4 = objectMapper.readValue(fileContent4, UserModel.class);
        UserModel userModel5 = objectMapper.readValue(fileContent5, UserModel.class);
        UserModel userModel6 = objectMapper.readValue(fileContent6, UserModel.class);

        return List.of(userModel1,userModel2,userModel3,userModel4,userModel5,userModel6);

    }


}
