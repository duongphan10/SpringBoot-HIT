package com.example.buoi3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Buoi3Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Buoi3Application.class, args);
//    TestController testController = context.getBean(TestController.class);
//    System.out.println(testController);
        Mobile mobile = context.getBean(Mobile.class);
        System.out.println(mobile.getName());
    }
}
