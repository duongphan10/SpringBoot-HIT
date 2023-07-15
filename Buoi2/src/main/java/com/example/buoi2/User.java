package com.example.buoi2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {
    @Autowired
    @Qualifier("XeWave")
    XeMay xeMay;
    public void getXeMay() {
        xeMay.xe();
    }
}
