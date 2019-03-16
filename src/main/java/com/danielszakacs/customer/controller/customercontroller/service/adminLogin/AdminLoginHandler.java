package com.danielszakacs.customer.controller.customercontroller.service.adminLogin;

import com.danielszakacs.customer.controller.customercontroller.DAO.repository.AdminRepo;
import com.danielszakacs.customer.controller.customercontroller.service.security.SecurityManger;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginHandler {

    private AdminRepo adminRepo;

    private SecurityManger securityManger;

    public AdminLoginHandler(AdminRepo adminRepo, SecurityManger securityManger) {
        this.adminRepo = adminRepo;
        this.securityManger = securityManger;
    }

    public boolean isAdminLoginDataCorrect(String email, String password){
        if(isAdminUserRegistrated(email)){
            if(isPasswordCorrect(email, password)){
                return true;
            }
        }
        return false;
    }

    public boolean isAdminUserRegistrated(String email){
        return this.adminRepo.existsByAdminEmail(email);
    }

    public boolean isPasswordCorrect(String email, String adminPassword){
        String hashedPassword = this.adminRepo.getByAdminEmail(email).getPassword();
        return this.securityManger.matchPasswords(adminPassword, hashedPassword);
    }

}
