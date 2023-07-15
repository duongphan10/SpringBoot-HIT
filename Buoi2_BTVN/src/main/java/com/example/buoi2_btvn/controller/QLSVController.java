package com.example.buoi2_btvn.controller;

import com.example.buoi2_btvn.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QLSVController {

    @RequestMapping(value = "/about")
    public String about(Model model) {
        Student[] students = {
                            new Student(1,"A",20),
                            new Student(2,"B",21),
                            new Student(3,"C",23)
        };
        model.addAttribute("students", students);
        return "about";
    }
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/about", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        // Kiểm tra thông tin đăng nhập và trả về trang about nếu đăng nhập thành công
        if ("admin".equals(username) && "admin".equals(password)) {
            return about(model);
        }
        // Nếu thông tin đăng nhập không chính xác, trả về trang login với thông báo lỗi
        return "loginerror";
    }

}
