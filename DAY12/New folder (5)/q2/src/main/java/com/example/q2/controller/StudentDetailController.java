package com.example.q2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.q2.model.Student;
import com.example.q2.model.StudentDetail;
import com.example.q2.service.StudentDetailService;
import com.example.q2.service.StudentService;
@RestController
public class StudentDetailController {
    @Autowired
    private StudentDetailService studentDetailService;

    @PostMapping("/studentDetail/student/{id}")
    public ResponseEntity<StudentDetail> createStudentDetail(@PathVariable Long id, @RequestBody StudentDetail studentDetail) {
        StudentDetail savedStudentDetail = studentDetailService.saveStudentDetail(studentDetail,id);
        return new ResponseEntity<>(savedStudentDetail, HttpStatus.CREATED);
    }

    @GetMapping("/studentDetail/{id}")
    public ResponseEntity<StudentDetail> getStudentDetailById(@PathVariable Long id) {
        StudentDetail studentDetail = studentDetailService.getStudentDetailById(id);
        return new ResponseEntity<>(studentDetail, HttpStatus.OK);
    }
}
