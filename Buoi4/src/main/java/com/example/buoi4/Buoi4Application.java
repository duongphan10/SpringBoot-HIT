package com.example.buoi4;


import com.example.buoi4.config.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Buoi4Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Buoi4Application.class, args);
        User user = context.getBean(User.class);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }

}
