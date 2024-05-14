package com.sc.data.validation.service;

import org.springframework.stereotype.Service;

import com.sc.data.validation.exception.DataValidationException;
import com.sc.data.validation.payload.NewCustRequest;

@Service
public interface CustomerRegisterService {
	
	String registerCustomer(NewCustRequest newCustreq) throws DataValidationException;

}
