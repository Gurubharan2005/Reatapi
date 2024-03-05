package com.example.q1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.Employee;
import com.example.q1.repository.EmployeeRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private EmployeeRepo employeeRepo;
public Employee postEmployee(Employee employee)
{
    return employeeRepo.save(employee);
}
    public List<Employee> getEmployeesInnerJoin() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        root.fetch("address", JoinType.INNER);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Employee> getEmployeesLeftOuterJoin() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        root.fetch("address", JoinType.LEFT);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }
}

