package com.danielszakacs.customer.controller.customercontroller.DAO.repository;

import com.danielszakacs.customer.controller.customercontroller.DAO.module.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    List<Customer> findAll();

    Customer findByEmail(String email);

    boolean existsByEmail(String email);

    void deleteById(Long id);

    List<Customer> findByName(String name);

    @Query("SELECT u FROM Customer u WHERE u.name LIKE CONCAT(:username,'%')")
    List<Customer> findCustomersWithPartOfName(@Param("username") String username);

}
