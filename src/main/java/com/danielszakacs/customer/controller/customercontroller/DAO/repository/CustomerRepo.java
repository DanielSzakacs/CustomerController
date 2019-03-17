package com.danielszakacs.customer.controller.customercontroller.DAO.repository;

import com.danielszakacs.customer.controller.customercontroller.DAO.module.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    List<Customer> findAll();

    Customer findByEmail(String email);

    boolean existsByEmail(String email);

    void deleteById(Long id);
}
