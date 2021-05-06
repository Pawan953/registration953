package com.cg.registration.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.registration.model.Registration;

/*
* This LoginModuleRepositoryTest for testing RepostryLayer
* @author Pavan
*/

@RunWith(SpringRunner.class)
@DataJpaTest
public class RegistrationRepositoryTest {

 @Autowired
private TestEntityManager testEntityManager;

 //This validateUserData for checking for userData
@Test
public void testCreateUserData() throws Exception{
Registration data = getdata();
Registration saveInDb = testEntityManager.persist(data);
assertNotNull(saveInDb);
}
private Registration getdata() {
Registration data = new Registration();
data.setUserId("Pavan25");
data.setPassword("Pavan@9");
data.setEmailId("abcde@gmaill.com");
data.setAge(20);
data.setContactNo("8999999900");
return data;
}

}