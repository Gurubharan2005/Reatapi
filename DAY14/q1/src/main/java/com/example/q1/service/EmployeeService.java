package com.example.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.Employee;
import com.example.q1.model.Payroll;
import com.example.q1.repository.EmployeeRepo;
import com.example.q1.repository.PayrollRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
@Autowired
private PayrollRepo payrollRepo;
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepo.findById(employeeId).orElse(null);
    }

    public Payroll savePayroll(Long employeeId, Payroll payroll) {
        Employee employee = employeeRepo.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setPayroll(payroll);
          payrollRepo.save(payroll);
          return payroll;
        }
        return null;
    }

    public Payroll getPayrollByEmployeeId(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElse(null);
        if (employee != null && employee.getPayroll() != null) {
            return employee.getPayroll();
        }
        return null;
    }
}

