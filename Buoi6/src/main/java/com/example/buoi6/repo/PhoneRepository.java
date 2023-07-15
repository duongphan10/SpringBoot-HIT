package com.example.buoi6.repo;

import com.example.buoi6.model.Phone;
import com.example.buoi6.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Integer> {
}
