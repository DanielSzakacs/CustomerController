package com.danielszakacs.customer.controller.customercontroller.service.CustomerHandler;

import com.danielszakacs.customer.controller.customercontroller.DAO.module.Customer;
import com.danielszakacs.customer.controller.customercontroller.DAO.repository.CustomerRepo;
import org.springframework.stereotype.Service;
import com.danielszakacs.customer.controller.customercontroller.service.security.SecurityManger;


import javax.naming.directory.AttributeInUseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerHandler {

    private CustomerRepo customerRepo;
    private SecurityManger securityManger;

    public CustomerHandler(CustomerRepo customerRepo, SecurityManger securityManger) {
        this.customerRepo = customerRepo;
        this.securityManger = securityManger;
    }

    private Customer createNewCustomer(String name, String email, String address, String telephone){
        return new Customer(name, email, address, telephone);
    }

    private boolean isCustomerEmailInUsed(String email){
        return this.customerRepo.existsByEmail(email);
    }

    private void saveNewCustomer(Customer customer){
        this.customerRepo.save(customer);
    }

    public void addNewCustomer(String name, String email, String address, String telephone) throws AttributeInUseException, IllegalArgumentException{
        if(!this.isCustomerEmailInUsed(email)){
            if(this.securityManger.isEmailValid(email)){
                Customer newCustomer = this.createNewCustomer(name, email, address, telephone);
                this.saveNewCustomer(newCustomer);
            }else{
                throw new IllegalArgumentException();
            }
        }else{
            throw new AttributeInUseException();
        }

    }

    public List<Customer> getCustomerByName(String name){
        return this.customerRepo.findCustomersWithPartOfName(name);
    }

    public void deleteCustomer(String id){
        this.customerRepo.deleteById(Long.parseLong(id));
    }

    public void editCustomerData(Map<String, Map<String, String>>userData) throws IllegalArgumentException {
        Map<String, String> checkedCustomerData = this.checkEditCustomerData(userData);
        try{
//            this.customerRepo.editCustomerData(userData.get("email"), userData.get("name"), userData.get("address"), userData.get("telephone"));
            this.customerRepo.edit_customerData(checkedCustomerData.get("name"), checkedCustomerData.get("id"));
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    public Map<String, String> checkEditCustomerData(Map<String, Map<String, String>> packageOfCustomerData){
        Map<String, String> newCustomerMap;
        for (String data: packageOfCustomerData.get("newdata").keySet()) {
            if(packageOfCustomerData.get("newdata").get(data) != ""){
                packageOfCustomerData.get("original").put(data, packageOfCustomerData.get("newdata").get(data));
            }
        }
        newCustomerMap = packageOfCustomerData.get("original");
        return newCustomerMap;
    }

    public List<Customer> getAllCustomer(){
        return this.customerRepo.findAll();
    }

}
