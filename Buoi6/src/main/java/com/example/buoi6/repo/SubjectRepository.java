package com.example.buoi6.repo;

import com.example.buoi6.model.Student;
import com.example.buoi6.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}
