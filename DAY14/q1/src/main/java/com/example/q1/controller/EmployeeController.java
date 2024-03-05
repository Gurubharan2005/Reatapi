package com.example.q1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.q1.model.Employee;
import com.example.q1.model.Payroll;
import com.example.q1.service.EmployeeService;
import com.example.q1.service.PayrollService;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/employee/{employeeId}/payroll")
    public ResponseEntity<Payroll> createPayrollForEmployee(@PathVariable Long employeeId, @RequestBody Payroll payroll) {
        Payroll savedPayroll = employeeService.savePayroll(employeeId, payroll);
        return new ResponseEntity<>(savedPayroll, HttpStatus.CREATED);
    }

    @GetMapping("/employee/{employeeId}/payroll")
    public ResponseEntity<Payroll> getPayrollByEmployeeId(@PathVariable Long employeeId) {
        Payroll payroll = employeeService.getPayrollByEmployeeId(employeeId);
        if (payroll != null) {
            return new ResponseEntity<>(payroll, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

