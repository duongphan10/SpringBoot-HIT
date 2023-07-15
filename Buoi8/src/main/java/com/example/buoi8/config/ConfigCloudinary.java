package com.example.buoi8.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigCloudinary {
    @Bean
    Cloudinary configCloudinarys() {
        Map<String,String> config = new HashMap<>();
        config.put("api_key","614346698165818");
        config.put("api_secret","J1brlIklgTSu745BNQ4mMwGNe0c");
        config.put("cloud_name","dnwqonyib");
        return new Cloudinary(config);
    }
}
