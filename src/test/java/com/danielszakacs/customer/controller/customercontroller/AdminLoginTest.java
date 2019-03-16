package com.danielszakacs.customer.controller.customercontroller;

import com.danielszakacs.customer.controller.customercontroller.DAO.repository.AdminRepo;
import com.danielszakacs.customer.controller.customercontroller.service.adminLogin.AdminLoginHandler;
import com.danielszakacs.customer.controller.customercontroller.service.security.SecurityManger;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


public class AdminLoginTest {

    @Before
    public AdminRepo getMockedAdminRepo(){
        AdminRepo adminRepoMock = Mockito.mock(AdminRepo.class);
        when(adminRepoMock.existsByAdminEmail(anyString())).thenReturn(true);
        return adminRepoMock;
    }

    @Before
    public SecurityManger getMockedSecurityManager(){
        SecurityManger securityManager = Mockito.mock(SecurityManger.class);
        when(securityManager.matchPasswords(anyString(), anyString())).thenReturn(true);
        return securityManager;
    }

    @Before
    public AdminLoginHandler getAdminLoginHandler(){
        return new AdminLoginHandler(getMockedAdminRepo(), getMockedSecurityManager());
    }

    @Test
    void isAdminUserRegistrated_return_true(){
        assertTrue(getAdminLoginHandler().isAdminUserRegistrated(anyString()));
    }

//    @Test
//    void isPasswordCorrect_return_true(){
//        assertTrue(getAdminLoginHandler().isPasswordCorrect(anyString(), anyString()));
//    }
}
