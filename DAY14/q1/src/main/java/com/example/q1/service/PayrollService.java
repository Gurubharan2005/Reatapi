package com.example.q1.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.Payroll;
import com.example.q1.repository.PayrollRepo;

@Service
public class PayrollService {
    @Autowired
    private PayrollRepo payrollRepo;

    public Payroll savePayroll(Payroll payroll) {
        return payrollRepo.save(payroll);
    }

    public Payroll getPayrollById(Long payrollId) {
        return payrollRepo.findById(payrollId).orElse(null);
    }
}