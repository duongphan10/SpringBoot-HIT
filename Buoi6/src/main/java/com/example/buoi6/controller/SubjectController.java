package com.example.buoi6.controller;

import com.example.buoi6.dto.StudentDTO;
import com.example.buoi6.dto.SubjectDTO;
import com.example.buoi6.exception.InternalException;
import com.example.buoi6.exception.NotFoundException;
import com.example.buoi6.model.Student;
import com.example.buoi6.model.Subject;
import com.example.buoi6.repo.StudentRepository;
import com.example.buoi6.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping("/create_new_subject")
    public ResponseEntity<?> createNewSubject(@RequestBody SubjectDTO subjectDTO) {
        Student student = studentRepository.findById(subjectDTO.getStudent_id())
                .orElseThrow(() -> {
                    System.out.println("Not found student with id: " + subjectDTO.getStudent_id());
                    return null;
                });
        Subject subject = new Subject(subjectDTO.getName(), student);

        return ResponseEntity.ok(subjectRepository.save(subject));
    }
    @GetMapping("/get_all_subject")
    public ResponseEntity<?> getAllSubject() {
        return ResponseEntity.ok(subjectRepository.findAll());
    }
    @GetMapping("/get_subject_by_student_id/{student_id}")
    public ResponseEntity<?> getSubjectByStudentId(@PathVariable Integer student_id) {
        Optional<Student> student = studentRepository.findById(student_id);
        if (student.isEmpty()) {
            throw new NotFoundException("Id không tồn tại!");
        }
        List<Subject> subjects = student.get().getSubjects();
        return ResponseEntity.ok().body(subjects);
    }
    @GetMapping("/get_subject_page")
    public ResponseEntity<?> getSubjectPage(
            @RequestParam(name = "page",required = false) Integer page,
            @RequestParam(name = "size",required = false, defaultValue = "5") Integer size) {
        if ( page == null) {
            throw new NotFoundException("Page is null!");
        }
        if (page < 0) {
            return ResponseEntity.ok(subjectRepository.findAll());
        }

        Page<Subject> subjects = subjectRepository.findAll(PageRequest.of(page,size));
        return ResponseEntity.ok().body(subjects.getContent());
    }
    @DeleteMapping("/delete_subject_by_id/{id}")
    public ResponseEntity<?> deleteSubjectById(@PathVariable("id") Integer id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isEmpty()) {
            throw new NotFoundException("Id ko tồn tại!");
        }
        try {
            subjectRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new InternalException("Error delete subject by id!");
        }
        return ResponseEntity.ok().body(subject);
    }
}
