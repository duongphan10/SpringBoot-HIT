package com.example.buoi5_btvn.controller;

import com.example.buoi5_btvn.model.User;
import com.example.buoi5_btvn.repository.UserRepository;
import com.example.buoi5_btvn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    // Create user
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User userCreate = userRepository.save(user);
        //userService.createUser(user);
        return ResponseEntity.ok().body(userCreate);
    }

    // Find user by id
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok().body(user);
    }
    // Show all user
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getUserAll();
        return ResponseEntity.ok().body(users);
    }

    // Update user
    @PatchMapping ("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
        User user1 = userService.findUserById(id);
        return ResponseEntity.ok().body(user1);
    }
    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        userService.deleteUser(id);
        return ResponseEntity.ok().body(user);
    }
}
