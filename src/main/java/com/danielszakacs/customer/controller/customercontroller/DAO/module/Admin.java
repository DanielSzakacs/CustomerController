package com.danielszakacs.customer.controller.customercontroller.DAO.module;

import javax.persistence.*;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String adminEmail;

    private String password;

    public Admin(String adminEmail, String password) {
        this.adminEmail = adminEmail;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getAdminEmail() {
        return adminEmail;
    }
}
