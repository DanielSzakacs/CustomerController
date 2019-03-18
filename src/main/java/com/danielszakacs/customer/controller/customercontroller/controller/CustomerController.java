package com.danielszakacs.customer.controller.customercontroller.controller;

import com.danielszakacs.customer.controller.customercontroller.DAO.module.Customer;
import com.danielszakacs.customer.controller.customercontroller.DAO.repository.CustomerRepo;
import com.danielszakacs.customer.controller.customercontroller.service.CustomerHandler.CustomerHandler;
import com.danielszakacs.customer.controller.customercontroller.service.security.SecurityManger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    SecurityManger securityManger;


    // TODO 3) User adatainak modositasa


    @PostMapping("/add_customer")
    public void addNewCustomer(@RequestBody Map<String, String> customerData){
        // TODO AttributeInUseException hogy ha a customer email-e mar registralva van. IllegalArgumentException ha nem email-t irt be.
    }

    @GetMapping("/search_customer")
    public void getCustomerByEmail(@RequestParam(name = "email", required = true) String email){
        //TODO NullPointerException ha nincs olyan user, IllegalArgumentException ha nem valid email-t irtál be.
    }

    @GetMapping("/customers")
    public String getAllCustomer(){
        JSONArray jsonArray = new JSONArray();
        new CustomerHandler(this.customerRepo, this.securityManger).getAllCustomer().stream()
                .forEach(t -> jsonArray.put(new JSONObject(t)));
        return jsonArray.toString();
    }

    @DeleteMapping("/delete_customer")
    public void deleteCustomer(@RequestBody Map<String, String> customerData){ //TODO this is by Customer ID

    }







}
