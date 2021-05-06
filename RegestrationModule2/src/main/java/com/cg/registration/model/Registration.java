package com.cg.registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Entity class
 * @author Pavan 
 */

@Entity
@Table(name="REGISTRATION28")
public class Registration {
	@Id
private String userId;
private String password;
private String emailId;
private int age;
private String contactNo;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public Registration() {
	super();

}
}
