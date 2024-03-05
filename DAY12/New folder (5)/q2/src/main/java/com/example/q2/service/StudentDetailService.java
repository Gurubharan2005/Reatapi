package com.example.q2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q2.model.Student;
import com.example.q2.model.StudentDetail;
import com.example.q2.repository.StudentDetailRepository;
import com.example.q2.repository.StudentRepository;

/**
 * StudentDetailService
 */
// StudentDetailService.java
@Service
public class StudentDetailService {
    @Autowired
    private StudentDetailRepository studentDetailRepository;
@Autowired
private StudentRepository studentRepository;
    public StudentDetail saveStudentDetail(StudentDetail studentDetail,Long id) {
        Student student=studentRepository.findById(id).orElse(null);
        if(student!=null)
        {
            student.setStudentDetail(studentDetail);
            studentDetailRepository.save(studentDetail);
            return studentDetail;
        }
        else{
            return null;
        }
    }

    public StudentDetail getStudentDetailById(Long id) {
        return studentDetailRepository.findById(id).orElse(null);
    }
}
