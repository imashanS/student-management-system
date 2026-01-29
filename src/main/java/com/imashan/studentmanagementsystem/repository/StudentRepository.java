package com.imashan.studentmanagementsystem.repository;

import com.imashan.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom query method
    Optional<Student> findByEmail(String email);
}