package com.danielszakacs.customer.controller.customercontroller.DAO.repository;

import com.danielszakacs.customer.controller.customercontroller.DAO.module.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
