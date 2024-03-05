package com.example.q2.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.q2.model.Student;
import com.example.q2.service.StudentService;

/// StudentController.java
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/students-inner-join")
    public ResponseEntity<List<Student>> getStudentsInnerJoin() {
        List<Student> students = studentService.getStudentsInnerJoin();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/students-left-outer-join")
    public ResponseEntity<List<Student>> getStudentsLeftOuterJoin() {
        List<Student> students = studentService.getStudentsLeftOuterJoin();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
