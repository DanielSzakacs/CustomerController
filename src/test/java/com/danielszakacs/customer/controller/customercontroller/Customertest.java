package com.danielszakacs.customer.controller.customercontroller;
import com.danielszakacs.customer.controller.customercontroller.DAO.module.Customer;
import com.danielszakacs.customer.controller.customercontroller.DAO.repository.CustomerRepo;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class Customertest {

    @Before
    private CustomerRepo getMockedCustomerRepo(){
        CustomerRepo customerRepoMocked = Mockito.mock(CustomerRepo.class);
        when(customerRepoMocked.findByEmail(anyString())).thenReturn(new Customer("Daniel Something", "daniel@gmail.com", "Ukrine, Uzhgorod, 2301", 234135));
        return customerRepoMocked;
    }

    @Test
    void isCustomerGetName_return_correctName(){
        assertEquals("Daniel Something", getMockedCustomerRepo().findByEmail(anyString()).getName());
    }

    @Test
    void isCustomerGetEmail_return_correctEmail(){
        assertEquals("daniel@gmail.com", getMockedCustomerRepo().findByEmail(anyString()).getEmail());
    }

    @Test
    void isCutomerGetAddress_return_correctAddress(){
        assertEquals("Ukrine, Uzhgorod, 2301", getMockedCustomerRepo().findByEmail(anyString()).getAddress());
    }

    @Test
    void isCutomerGetTelephone_return_correctTelephneNumber(){
        assertEquals(234135, getMockedCustomerRepo().findByEmail(anyString()).getTelephone());
    }

}
