package com.example.buoi5_btvn.service;

import com.example.buoi5_btvn.model.User;
import com.example.buoi5_btvn.exception.InternalException;
import com.example.buoi5_btvn.exception.NotFoundException;
import com.example.buoi5_btvn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUserAll() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        try {
            userRepository.save(user);
        }
        catch (Exception e) {
            throw new InternalException("Error with save user");
        }
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("Can't find user with id " + id);
        }
        return user.get();
    }

    @Override
    public void updateUser(User user) {
        try {
            Optional<User> currentUser = userRepository.findById(user.getId());
            currentUser.get().setUsername(user.getUsername());
            currentUser.get().setPassword(user.getPassword());
            currentUser.get().setFullname(user.getFullname());
            userRepository.save(currentUser.get());
        }
        catch (Exception e) {
            throw new InternalException("Error with update user");
        }

    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        //userRepository.deleteById(id);
        if(user.isEmpty()) {
            throw new NotFoundException("Not found user has id " + id);
        }
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new InternalException("Error with delete user");
        }
    }
}
