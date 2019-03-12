package com.danielszakacs.customer.controller.customercontroller;

import com.danielszakacs.customer.controller.customercontroller.DAO.repository.AdminRepo;
import com.danielszakacs.customer.controller.customercontroller.service.adminRegistration.RegistrationService;
import com.danielszakacs.customer.controller.customercontroller.service.security.SecurityManger;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class RegistrationServiceTest {

    @Before
    private AdminRepo getMockedAdminrepo(){
        AdminRepo adminRepoMock = Mockito.mock(AdminRepo.class);
        when(adminRepoMock.existsByAdminEmail(anyString())).thenReturn(true);
        return adminRepoMock;
    }

    @Before
    private SecurityManger getMockedSecurityManager(){
        SecurityManger securityManager = Mockito.mock(SecurityManger.class);
        return securityManager;
    }

    @Before
    private RegistrationService getRegistrationServie(){
        return new RegistrationService(getMockedAdminrepo(), getMockedSecurityManager());
    }

    @Test
    void isAdminEmailUnUsed_return_true(){
        assertTrue(getRegistrationServie().isAdminEmailUnUsed("daniel@gmail.com"));
    }
}
