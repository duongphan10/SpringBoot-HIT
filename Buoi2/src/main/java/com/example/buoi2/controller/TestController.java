package com.example.buoi2.controller;

;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller
public class TestController {
    @RequestMapping("/")
    public String Index(Model model) {
        model.addAttribute("string","Hello World");
        model.addAttribute("bien","Hello World 2");
        Student student = new Student(1,1,"K");
        model.addAttribute("student", student);

//        Student student1 = new Student(2,2,"A");
//        Student student2 = new Student(3,3,"B");
//        List<Student> students = new LinkedList<>();
//        students.add(student1);
//        students.add(student2);
//        model.addAttribute("student", students);

        return "index";
    }
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String About(@RequestParam("search") String search, Model model) {
        model.addAttribute("search",search);
        return "about";
    }

    //@RequestMapping(value = "/test")

}
