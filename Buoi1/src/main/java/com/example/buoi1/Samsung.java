package com.example.buoi1;

import org.springframework.stereotype.Component;

@Component("samsung")
public class Samsung implements Phone{
    @Override
    public void using() {
        System.out.println("I'm using Samsung");
    }
}
