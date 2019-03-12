package com.danielszakacs.customer.controller.customercontroller.DAO.repository;

import com.danielszakacs.customer.controller.customercontroller.DAO.module.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Long> {

    Admin getByAdminEmail(String email);

    boolean existsByAdminEmail(String email);
}
