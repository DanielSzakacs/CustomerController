package com.danielszakacs.customer.controller.customercontroller.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class CustomerController {

    // TODO 3) User adatainak modositasa


    @PostMapping("/add_customer")
    public void addNewCustomer(@RequestBody Map<String, String> customerData){
        // TODO AttributeInUseException hogy ha a customer email-e mar registralva van. IllegalArgumentException ha nem email-t irt be.
    }

    @GetMapping("/search_customer")
    public void getCustomer(@RequestParam(name = "email", required = true) String email){
        //TODO NullPointerException ha nincs olyan user, IllegalArgumentException ha nem valid email-t irtál be.
    }

    @DeleteMapping("/delete_customer")
    public void deleteCustomer(@RequestBody Map<String, String> customerData){ //TODO this is by Customer ID

    }







}
