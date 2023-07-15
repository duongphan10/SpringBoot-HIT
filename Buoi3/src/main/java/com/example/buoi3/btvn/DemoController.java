package com.example.buoi3.btvn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute User user) {
        if(user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            return "redirect:about";
        }
        model.addAttribute("messageErr", "Thông tin đăng nhập không hợp lệ!");
        return "login";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        Student[] students = {
                new Student("ABC1", 20),
                new Student("ABC2", 20),
                new Student("ABC3", 20),
                new Student("ABC4", 20),
                new Student("ABC5", 20)
        };
        model.addAttribute("students", students);
        return "about";
    }

}
