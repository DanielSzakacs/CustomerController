package com.danielszakacs.customer.controller.customercontroller.service.adminLogin;

import com.danielszakacs.customer.controller.customercontroller.DAO.repository.AdminRepo;
import com.danielszakacs.customer.controller.customercontroller.service.security.SecurityManger;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

@Service
public class AdminLoginHandler {

    private AdminRepo adminRepo;

    private SecurityManger securityManger;

    public AdminLoginHandler(AdminRepo adminRepo, SecurityManger securityManger) {
        this.adminRepo = adminRepo;
        this.securityManger = securityManger;
    }

    public void adminLogin(String email, String password){
        if(isAdminUserRegistrated(email)){
            if(!isPasswordCorrect(email, password)){
                throw new IllegalArgumentException();
            }
        }else{
            throw new IllegalArgumentException();
        }
    }

    public boolean isAdminUserRegistrated(String email){
        return this.adminRepo.existsByAdminEmail(email);
    }

    public boolean isPasswordCorrect(String email, String adminPassword){
        String hashedPassword = this.adminRepo.getByAdminEmail(email).getPassword();
        return this.securityManger.matchPasswords(adminPassword, hashedPassword);
    }

}
