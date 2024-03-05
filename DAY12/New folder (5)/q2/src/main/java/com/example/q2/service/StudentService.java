package com.example.q2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q2.model.Student;
import com.example.q2.repository.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
@Autowired
private EntityManager entityManager;
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudentsInnerJoin() {
       CriteriaBuilder cb=entityManager.getCriteriaBuilder();
       CriteriaQuery<Student> query=cb.createQuery(Student.class);
       Root<Student> root=query.from(Student.class);
       root.fetch("studentDetail",JoinType.INNER);
       query.select(root);
       return entityManager.createQuery(query).getResultList();
        
    }

    public List<Student> getStudentsLeftOuterJoin() {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
       CriteriaQuery<Student> query=cb.createQuery(Student.class);
       Root<Student> root=query.from(Student.class);
       root.fetch("studentDetail",JoinType.LEFT);
       query.select(root);
       return entityManager.createQuery(query).getResultList();
    }
}
