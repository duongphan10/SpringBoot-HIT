package com.example.buoi6.controller;

import com.example.buoi6.dto.PhoneDTO;
import com.example.buoi6.exception.NotFoundException;
import com.example.buoi6.model.Phone;
import com.example.buoi6.model.Student;
import com.example.buoi6.repo.PhoneRepository;
import com.example.buoi6.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PhoneController {
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/create_new_phone")
    public ResponseEntity<?> createNewPhone(@RequestBody PhoneDTO phoneDTO) {
        Student student = studentRepository.findById(phoneDTO.getStudent_id())
                .orElseThrow(() -> new NotFoundException("student_id ko tồn tại!"));
        Phone phone = new Phone(phoneDTO.getName(),phoneDTO.getBrand(),student);
        return ResponseEntity.ok().body(phoneRepository.save(phone));
    }
    @GetMapping("/get_all_phone")
    public ResponseEntity<?> getAllPhone() {
        return ResponseEntity.ok().body(phoneRepository.findAll());
    }
    @GetMapping("/get_phone_by_id/{id}")
    public ResponseEntity<?> getPhoneByID(@PathVariable("id") Integer id) {
        Phone phone = phoneRepository.findById(id).orElseThrow(() -> new NotFoundException("Id ko tồn tại!"));
        return ResponseEntity.ok().body(phone);
    }
    @PutMapping("/update_phone_by_id/{id}")
    public ResponseEntity<?> updatePhoneById(@PathVariable("id") Integer id,@RequestBody PhoneDTO phoneDTO) {
        Phone phone = phoneRepository.findById(id).orElseThrow(() -> new NotFoundException("Id ko tồn tại!"));
        Student student = studentRepository.findById(phoneDTO.getStudent_id())
                .orElseThrow(()-> new NotFoundException("student_id ko tồn tại!"));
        phone.setName(phoneDTO.getName());
        phone.setBrand(phoneDTO.getBrand());
        phone.setStudent(student);
        return ResponseEntity.ok().body(phoneRepository.save(phone));
    }
    @DeleteMapping("/delete_phone_by_id/{id}")
    public ResponseEntity<?> deletePhoneById(@PathVariable("id") Integer id) {
        Phone phone = phoneRepository.findById(id).orElseThrow(() -> new NotFoundException("Id ko tồn tại!"));
        Student student = phone.getStudent();
        student.setPhone(null);
        studentRepository.save(student);
        phoneRepository.deleteById(id);
        return ResponseEntity.ok().body(phone);
    }
}
