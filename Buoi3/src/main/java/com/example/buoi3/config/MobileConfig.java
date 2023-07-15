package com.example.buoi3.config;

import com.example.buoi3.Mobile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobileConfig {

    @Bean
    public Mobile configMobile() {
        return new Mobile("Iphone");
    }

}
