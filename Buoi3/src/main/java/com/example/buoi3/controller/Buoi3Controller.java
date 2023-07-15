package com.example.buoi3.controller;

import com.example.buoi3.btvn.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RestController //Đánh dấu class là component (để tạo bean) ở layer controller và trả về data dưới dạng object JSON
public class Buoi3Controller {

    public static List<Student> students = new ArrayList<>();

    @ResponseBody //Annotation này giúp trả về kiểu dữ liệu cho người dùng là JSON
    @GetMapping("/index")
    public ResponseEntity<Student> index() {
        Student student = new Student("ABC", 20);
        HttpHeaders headers = new HttpHeaders();
        headers.set("username", "abc");

        //ResponseEntity là một lớp hỗ trợ các phản hồi HTTP và trả về data dưới dạng JSON
        return ResponseEntity.ok().headers(headers).body(student);
    }

    @PostMapping("/index")
    public ResponseEntity<Student> createStudent(@ModelAttribute Student student) {
        students.add(student);
        HttpHeaders headers = new HttpHeaders();
        headers.set("username", "abc");
        return ResponseEntity.ok().headers(headers).body(student);
    }


    @GetMapping("/view")
    public String about() {
        return "about";
    }

}
