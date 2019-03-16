package com.danielszakacs.customer.controller.customercontroller.service.adminRegistration;

import com.danielszakacs.customer.controller.customercontroller.DAO.module.Admin;
import com.danielszakacs.customer.controller.customercontroller.DAO.repository.AdminRepo;
import org.springframework.stereotype.Service;
import com.danielszakacs.customer.controller.customercontroller.service.security.SecurityManger;

@Service
public class RegistrationService {

    private AdminRepo adminRepo;

    private SecurityManger securityManager;

    public RegistrationService(AdminRepo adminRepo, SecurityManger securityManager) {
        this.adminRepo = adminRepo;
        this.securityManager = securityManager;
    }

    public boolean newAdminRegistration(String adminEmail, String password) throws IllegalArgumentException{
        if(this.isAdminEmailUnUsed(adminEmail)){
            String hashedPassword = this.hashCode(password);
            this.saveAdmin(adminEmail, hashedPassword);
            return true;
        }
        throw new IllegalArgumentException(); // TODO this is not working for 100%
    }

    public boolean isAdminEmailUnUsed(String email){
        return adminRepo.existsByAdminEmail(email);
    }

    public String hashCode(String unHashedPassoword){
        return this.securityManager.hashingCode(unHashedPassoword);
    }

    public void saveAdmin(String email, String hashedPassword){
        this.adminRepo.save(new Admin(email, hashedPassword));
    }


}
