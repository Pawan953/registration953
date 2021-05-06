package com.cg.registration.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.registration.model.Registration;
import com.cg.registration.repository.RegistrationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest


public class RegistrationServiceTest {


    @MockBean
    private RegistrationRepository RegistrationJpaRepository;

    @Autowired
    private RegistrationService RegistrationService;

    @Test
    public void testCreateUserData(){
    	 Registration data = new  Registration();
         data.setUserId("Pavan25");
         data.setPassword("Pavan@9");
         data.setEmailId("abcde@gmail.com");
         data.setAge(20);
         data.setContactNo("8999999900");
        Mockito.when(RegistrationJpaRepository.save(data)).thenReturn(data);
        assertThat(RegistrationService.createdata(data)).isEqualTo(data);
    }
}
