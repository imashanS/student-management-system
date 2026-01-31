package com.imashan.studentmanagementsystem.service;

import com.imashan.studentmanagementsystem.entity.Student;
import com.imashan.studentmanagementsystem.repository.StudentRepository;
import com.imashan.studentmanagementsystem.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}