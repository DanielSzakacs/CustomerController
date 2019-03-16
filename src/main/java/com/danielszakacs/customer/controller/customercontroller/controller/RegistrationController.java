package com.danielszakacs.customer.controller.customercontroller.controller;

import com.danielszakacs.customer.controller.customercontroller.DAO.repository.AdminRepo;
import com.danielszakacs.customer.controller.customercontroller.service.adminRegistration.RegistrationService;
import com.danielszakacs.customer.controller.customercontroller.service.security.SecurityManger;
import com.sun.org.apache.xerces.internal.util.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@CrossOrigin
@RestController
public class RegistrationController {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    SecurityManger securityManager;

    private RegistrationService registrationService = new RegistrationService(adminRepo, securityManager);

    @PostMapping("/registration")
    public void registerNewAdmin(@RequestBody Map<String, String> newAdmin) {
        System.out.println("registration working");
        try {
            new RegistrationService(this.adminRepo, this.securityManager).newAdminRegistration(newAdmin.get("email"), newAdmin.get("password"));
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Admin not registered");
        }
    }

//    @GetMapping("/")
//    public void testingController() {
//        System.out.println("Test controller is running.");
//        try {
//            new RegistrationService(this.adminRepo, this.securityManager).newAdminRegistration("daniel", "dsada");
//        } catch (IllegalArgumentException e) {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "Admin not registered");
//        }
//    }
}
