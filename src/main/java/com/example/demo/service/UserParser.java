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


    /**
     * TODO  List<String> list
     *
     * @param list
     * @return
     * @throws JsonProcessingException
     */
    public List<UserModel> parse(List<String> list) throws JsonProcessingException {




        String fileContent = "{\n" +
                "\"name\":\"heffy\",\n" +
                "\"surname\":\"hey\",\n" +
                "\"email\":\"hello@mail.ru\"\n" +
                "}";

        UserModel userModel = objectMapper.readValue(fileContent, UserModel.class);

        return List.of(userModel);

    }


}
