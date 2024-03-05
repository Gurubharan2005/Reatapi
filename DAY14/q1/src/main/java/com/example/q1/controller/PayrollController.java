package com.example.q1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.q1.model.Payroll;
import com.example.q1.service.PayrollService;

@RestController
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @PostMapping("/payroll")
    public ResponseEntity<Payroll> createPayroll(@RequestBody Payroll payroll) {
        Payroll savedPayroll = payrollService.savePayroll(payroll);
        return new ResponseEntity<>(savedPayroll, HttpStatus.CREATED);
    }

    @GetMapping("/payroll/{payrollId}")
    public ResponseEntity<Payroll> getPayrollById(@PathVariable Long payrollId) {
        Payroll payroll = payrollService.getPayrollById(payrollId);
        if (payroll != null) {
            return new ResponseEntity<>(payroll, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
