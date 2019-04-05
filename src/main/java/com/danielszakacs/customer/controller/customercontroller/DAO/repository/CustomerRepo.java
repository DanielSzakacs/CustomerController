package com.danielszakacs.customer.controller.customercontroller.DAO.repository;

import com.danielszakacs.customer.controller.customercontroller.DAO.module.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    List<Customer> findAll();

    Customer findByEmail(String email);

    boolean existsByEmail(String email);

    void deleteById(Long id);

    @Query("SELECT u FROM Customer u WHERE u.name LIKE CONCAT(:username,'%')")
    List<Customer> findCustomersWithPartOfName(@Param("username") String username);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Customer u set u.name = (:name), u.email = :email, u.address = :address, u.telephone = :telephone " +
//            " where u.id like 1")
//    void editCustomerData(@Param("email") String email, @Param("name") String name, @Param("address") String address,
//                          @Param("telephone") String telephone);


    @Transactional
    @Modifying
    @Query("UPDATE Customer u set u.name = (:name) where u.id like (:id) ")
    void edit_customerData(@Param("name") String name, @Param("id") String id);

}
