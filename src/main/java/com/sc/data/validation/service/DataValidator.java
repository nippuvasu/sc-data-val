package com.sc.data.validation.service;

import org.springframework.stereotype.Service;

@Service
public class DataValidator {
	
		
	public boolean isValidSSN(String ssn) {
	    return true; 
	  //this method can have implementation to check in DB/ call third party service to have real validation of SSN
	    
	}
	
	//this method can have real implementation of DB / Service call to validate phone number
	public boolean isValidPhoneNum(String phoneNum) {
	    return true;
	  //this method can have real implementation of DB / Service call to validate phone number
    
	}
	
	public boolean isValidEmail(String emailId) {
	    return true;
	  //this method can have real implementation of DB/service call to validate email address.
	    
	}

}
