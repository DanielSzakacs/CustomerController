package com.danielszakacs.customer.controller.customercontroller.controller;


import com.danielszakacs.customer.controller.customercontroller.DAO.repository.AdminRepo;
import com.danielszakacs.customer.controller.customercontroller.service.adminLogin.AdminLoginHandler;
import com.danielszakacs.customer.controller.customercontroller.service.security.SecurityManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@CrossOrigin
@RestController
public class LoginInController {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private SecurityManger securityManger;

    @PostMapping("/login")
    public void adminLogin(@RequestBody Map<String, String> adminData){
        try{
            new AdminLoginHandler(adminRepo, securityManger).adminLogin(adminData.get("email"), adminData.get("password"));
        }catch (IllegalArgumentException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Admin is not found"
            );
        }
    }
}
