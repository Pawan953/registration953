package com.cg.registration.controller;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cg.registration.model.Registration;
import com.cg.registration.services.RegistrationService;

/*
 * This LoginModuleControllerTest method for testing
 * @author Pavan
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = RegistrationController.class,secure = false)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegistrationService Service;

  //This testValidateUser method for validate user
    
    @Test
    public void testCreateUserData() throws Exception{
        String URI = "/userRegistration/createUserDetails";
        Registration User = new  Registration();
        User.setUserId("Pavan25");
        User.setPassword("Pavankal@9");
        User.setEmailId("abcde@gmaill.com");
        User.setAge(20);
        User.setContactNo("8999909900");
        String jsonInput = this.converttoJson(User);

        Mockito.when(Service.createdata(Mockito.any(Registration.class))).thenReturn(User);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
      // Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }
   
    /**
     * Convert Object into Json String by using Jackson ObjectMapper
     * @param data
     * @return
     * @throws JsonProcessingException
     */
    private String converttoJson(Object User) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(User);
    }

}
