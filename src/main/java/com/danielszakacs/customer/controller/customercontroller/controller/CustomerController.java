package com.danielszakacs.customer.controller.customercontroller.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class CustomerController {

    // TODO 3) User adatainak modositasa


    @PostMapping("/add_customer")
    public void addNewCustomer(@RequestBody Map<String, String> customerData){

    }

    @GetMapping("/search_customer")
    public void getCustomer(@RequestParam(name = "email", required = true) String email){

    }

    @DeleteMapping("/delete_customer")
    public void deleteCustomer(@RequestBody Map<String, String> customerData){

    }







}
