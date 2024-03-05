package com.example.springapp.Ce2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.Ce2.model.Student;
import com.example.springapp.Ce2.service.StudentService;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }
    @GetMapping("/student")
    public List<Student> getStudent()
    {
        return studentService.getStudent();
    }
    @GetMapping("/student/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id)
    {
        return studentService.getStudentById(id);
    }
    @PutMapping("/student/{id}")
    public Student UpdateDetails(@PathVariable Long id,@RequestBody Student student)
    {
        return studentService.UpdateDetails(id,student);
    }
    @DeleteMapping("/student/{id}")
    public String DeleteDetails(@PathVariable Long id)
    {
        return studentService.deleteDetails(id);
    }
    
}
