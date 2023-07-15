package com.example.buoi1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {
    @Autowired
        @Qualifier("samsung")
    Phone phone;
    public void getPhone() {
        phone.using();
    }
}
