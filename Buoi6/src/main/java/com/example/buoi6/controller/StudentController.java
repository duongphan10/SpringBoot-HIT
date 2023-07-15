package com.example.buoi6.controller;

import com.example.buoi6.dto.StudentDTO;
import com.example.buoi6.model.Student;
import com.example.buoi6.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/create_new_student")
    public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getName(),studentDTO.getAddress());
        return ResponseEntity.ok(studentRepository.save(student));
    }
    @GetMapping("/get_all_student")
    public ResponseEntity<?> getAllStudent() {
        return ResponseEntity.ok(studentRepository.findAll());
    }
    @PutMapping("/update_student_by_id/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id, @RequestBody StudentDTO studentDTO)  {
        Student student = studentRepository.updateStudentById(id,studentDTO);
        return ResponseEntity.ok().body(student);
    }
    @DeleteMapping("/delete_student_by_id/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Integer id) {
        Student student = studentRepository.deleteStudentById(id);
        //studentRepository.deleteById(id);
        return ResponseEntity.ok().body(student);
    }
}
