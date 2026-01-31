package com.imashan.studentmanagementsystem.controller;


import com.imashan.studentmanagementsystem.dto.StudentRequestDTO;
import com.imashan.studentmanagementsystem.dto.StudentResponseDTO;
import com.imashan.studentmanagementsystem.entity.Student;
import com.imashan.studentmanagementsystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO dto) {
        Student student = new Student(dto.getName(), dto.getEmail(), dto.getAge());
        Student saved = studentService.createStudent(student);
        return new StudentResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getAge()
        );
    }

    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(s -> new StudentResponseDTO(
                        s.getId(), s.getName(), s.getEmail(), s.getAge()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id) {
        Student s = studentService.getStudentById(id);
        return new StudentResponseDTO(
                s.getId(), s.getName(), s.getEmail(), s.getAge()
        );
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}