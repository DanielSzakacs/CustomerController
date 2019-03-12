package com.danielszakacs.customer.controller.customercontroller;

import com.danielszakacs.customer.controller.customercontroller.DAO.module.Admin;
import com.danielszakacs.customer.controller.customercontroller.DAO.repository.AdminRepo;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class AdminTest {

    @Before
    private AdminRepo getMockedAdminrepo(){
        AdminRepo adminRepoMock = Mockito.mock(AdminRepo.class);
        when(adminRepoMock.getByAdminEmail(anyString())).thenReturn(new Admin("daniel@gmail.com", "ddsafasdgdffa"));
        return adminRepoMock;
    }

    @Test
    void isAdminGetPassword_return_correctPassword(){
        assertEquals("ddsafasdgdffa", getMockedAdminrepo().getByAdminEmail(anyString()).getPassword());
    }

    @Test
    void isAdminGetEmail_return_correctEmail(){
        assertEquals("daniel@gmail.com", getMockedAdminrepo().getByAdminEmail(anyString()).getAdminEmail());
    }
}
