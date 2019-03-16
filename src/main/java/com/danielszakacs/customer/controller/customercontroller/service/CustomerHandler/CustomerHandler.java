package com.danielszakacs.customer.controller.customercontroller.service.CustomerHandler;

import com.danielszakacs.customer.controller.customercontroller.DAO.module.Customer;
import com.danielszakacs.customer.controller.customercontroller.DAO.repository.CustomerRepo;
import org.springframework.stereotype.Service;
import com.danielszakacs.customer.controller.customercontroller.service.security.SecurityManger;


import javax.naming.directory.AttributeInUseException;

@Service
public class CustomerHandler {

    private CustomerRepo customerRepo;
    private SecurityManger securityManger;

    public CustomerHandler(CustomerRepo customerRepo, SecurityManger securityManger) {
        this.customerRepo = customerRepo;
        this.securityManger = securityManger;
    }

    private Customer createNewCustomer(String name, String email, String address, int telephone){
        return new Customer(name, email, address, telephone);
    }

    private boolean isCustomerEmailInUsed(String email){
        return this.customerRepo.existsByEmail(email);
    }

    private void saveNewCustomer(Customer customer){
        this.customerRepo.save(customer);
    }

    public void addNewCustomer(String name, String email, String address, int telephone) throws AttributeInUseException, IllegalArgumentException{
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

    public Customer getCustomerByEmail(String email) throws NullPointerException, IllegalArgumentException{
        if(this.securityManger.isEmailValid(email)){
            return this.customerRepo.findByEmail(email);
        }else{
            throw new IllegalAccessError();
        }
    }

    public void deleteCustomer(String id){
        this.customerRepo.deleteById(Long.parseLong(id));
    }

}
