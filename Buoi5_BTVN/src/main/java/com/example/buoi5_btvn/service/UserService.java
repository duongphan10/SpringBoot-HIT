package com.example.buoi5_btvn.service;

import com.example.buoi5_btvn.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUserAll();
    void createUser(User user);
    User findUserById(Long id);
    void updateUser(User user);
    void deleteUser(Long id);
}
