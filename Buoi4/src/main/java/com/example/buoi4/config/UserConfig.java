package com.example.buoi4.config;

import com.example.buoi4.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Value("${user.username}")
    private String username;

    @Value("${user.password}")
    private String password;

    @Bean
    public User createUser() {
        return new User(1L, username, password);
    }

}
