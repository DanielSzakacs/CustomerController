package com.danielszakacs.customer.controller.customercontroller.service.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.EmailValidator;


@Service
public class SecurityManger {

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String hashingCode(String password){
        return passwordEncoder().encode(password);
    }

    public boolean matchPasswords(String password, String hashedPassword){
        return passwordEncoder().matches(password, hashedPassword);
    }

    public boolean isEmailValid(String email){
        boolean valid = EmailValidator.getInstance().isValid(email);
        return valid;
    }
}
