package com.example.buoi3_btvn.controller;


import com.example.buoi3_btvn.store.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BTVNController {
    @GetMapping(value = {"/","/login"})
    public String login() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
        for (User user:Store.users ) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return "redirect:store";
            }
        }
        model.addAttribute("messageErrLogin", "Thông tin đăng nhập không hợp lệ!");
        return "login";
    }

    @GetMapping(value = "/signup")
    public String signup() {
        return "signup";
    }
    @PostMapping(value = "/signup")
    public String checksignup(@ModelAttribute User us,Model model) {
        for (User user:Store.users ) {
            if(user.getUsername().equals(us.getUsername()) ) {
                model.addAttribute("messageErrSignup", "Thông tin đăng ký trùng hoặc không hợp lệ!");
                return "signup";
            }
        }
        Store.users.add(us);
        return "login";
    }
    @GetMapping(value = "/store")
    public String store(Model model) {
        model.addAttribute("users", Store.users);
        return "store";
    }
    //@ResponseBody
    @GetMapping(value = "api/users")
    public ResponseEntity<List<User>> view() {
        return ResponseEntity.ok().body(Store.getUsers());
    }
}
