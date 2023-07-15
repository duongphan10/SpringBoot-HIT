package com.example.buoi6.repo;

import com.example.buoi6.dto.StudentDTO;
import com.example.buoi6.exception.InternalException;
import com.example.buoi6.exception.NotFoundException;
import com.example.buoi6.model.Student;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public default Student updateStudentById(Integer id, StudentDTO studentDTO) {
        Optional<Student> student = findById(id);
        if (student.isEmpty()) {
            throw new NotFoundException("Id không tồn tại!");
        }
        try {
            student.get().setName(studentDTO.getName());
            student.get().setAddress(studentDTO.getAddress());
            save(student.get());
        } catch (EmptyResultDataAccessException e) {
            throw new InternalException("Error update student by id!");
        }
        return getById(id);
    }
    public default Student deleteStudentById(Integer id) {
        Optional<Student> student = findById(id);
        if (student.isEmpty()) {
            throw new NotFoundException("Id không tồn tại!");
        }
        try {
            deleteById(id);
        } catch (Exception e) {
            throw new InternalException("Error with delete student by id");
        }
        return student.get();
    }
}
