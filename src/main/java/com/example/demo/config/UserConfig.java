package com.example.demo.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class UserConfig {
    @Value("${pathFile}")
    List<String> paths;

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }




}
