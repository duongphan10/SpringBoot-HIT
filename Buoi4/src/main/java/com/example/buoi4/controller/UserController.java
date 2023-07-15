package com.example.buoi4.controller;

import com.example.buoi4.User;
import com.example.buoi4.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1,"a","123"));
        users.add(new User(2,"b","123"));
        users.add(new User(3,"c","123"));
    }
    @GetMapping("test")
    public ResponseEntity<?> test() {
        int a[] = {1,2,4,5};
        System.out.println(a[10]);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        User reponse = null;
        for(User user:users) {
            if(user.getId().equals(id)) {
                reponse = user;
            }
        }
        if (reponse == null) {
            throw new NotFoundException("Khong tim thay id "+ id);
        }
        return ResponseEntity.ok().body(reponse);
    }
    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestParam(name = "username",required = false,defaultValue = "a")String username,
                                     @RequestParam String password) {
        User reponse = null;
        for(User user:users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                reponse = user;
            }
        }
        return ResponseEntity.ok().body(reponse);
    }
    @PostMapping("/body/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/model/user")
    public ResponseEntity<?> createUserModel(@ModelAttribute User user) {
        return ResponseEntity.ok().body(user);
    }
}
