package com.cg.registration.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.registration.model.Registration;

/*
 * This LoginRepostry method for checking validate users
 */

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,String> {
    
	
}