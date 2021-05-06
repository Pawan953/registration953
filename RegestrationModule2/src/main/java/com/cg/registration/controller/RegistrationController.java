package com.cg.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.registration.exceptions.ResourceNotFoundException;
import com.cg.registration.exceptions.UserValidate;
import com.cg.registration.model.Registration;
import com.cg.registration.services.RegistrationService;

/*
 * This Controller for testing in postman
 * 
 * @author Pavan
 * 
 */

@RestController
@RequestMapping("/userRegistration")
public class RegistrationController {
	
	// creating varible

    @Autowired
    private  RegistrationService registrationService;

    /*
	 * This get Method for creating user details
	 */

    @PostMapping("/createUserDetails")
    public Registration createdata(@RequestBody Registration data) throws ResourceNotFoundException{
    	UserValidate vali=new UserValidate();
    	Registration data1;
    	boolean v=vali.validateUser(data.getUserId());
    boolean v1=	vali.validatePassword(data.getPassword());
    if(data.getUserId().equals("") || data.getPassword().equals("") || data.getEmailId().equals(""))
	{
		throw new ResourceNotFoundException("Enter Valid Data");
	}
    if(v)
    { 
    	if(v1)
    	{
    		 data1= registrationService.createdata(data);
    	}
    	else
    	{
    		throw new ResourceNotFoundException("Enter Valid Password ");
    	}
    }else
    {
    	throw new ResourceNotFoundException("Enter Valid UserId ");
    }
        return data1;
    }

}
