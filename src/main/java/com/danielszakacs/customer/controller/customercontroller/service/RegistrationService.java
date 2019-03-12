package com.danielszakacs.customer.controller.customercontroller.service;

import com.danielszakacs.customer.controller.customercontroller.DAO.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private AdminRepo adminRepo;

    public boolean isAdminEmailUnUsed(String email){
        return adminRepo.existsAdminByAdminEmail(email);
    }
}
