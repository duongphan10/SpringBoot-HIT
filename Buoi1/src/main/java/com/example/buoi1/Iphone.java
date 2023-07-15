package com.example.buoi1;

import org.springframework.stereotype.Component;

@Component("iphone")
public class Iphone implements Phone{
    @Override
    public void using() {
        System.out.println("I'm using Iphone");
    }
}
