package com.example.q1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.q1.model.Employee;
import com.example.q1.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.postEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employees-inner-join")
    public ResponseEntity<List<Employee>> getEmployeesInnerJoin() {
        List<Employee> employees = employeeService.getEmployeesInnerJoin();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees-left-outer-join")
    public ResponseEntity<List<Employee>> getEmployeesLeftOuterJoin() {
        List<Employee> employees = employeeService.getEmployeesLeftOuterJoin();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
