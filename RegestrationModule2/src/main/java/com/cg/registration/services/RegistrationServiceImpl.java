package com.cg.registration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.registration.model.Registration;
import com.cg.registration.repository.RegistrationRepository;

/*
 * This service for sending request to DAO
 * 
 *@author Pavan
 */

@Service
public class RegistrationServiceImpl implements RegistrationService{
@Autowired
private RegistrationRepository repo;
	@Override
	public Registration createdata(Registration data) {
		
		return repo.save(data);
	}

}
