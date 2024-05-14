package com.sc.data.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sc.data.validation.exception.DataValidationException;
import com.sc.data.validation.payload.NewCustRequest;
import com.sc.data.validation.service.CustomerRegisterService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/customer")
public class UserController {

  @Autowired	
  CustomerRegisterService customerRegisterService;	

  @PostMapping("/new")
  public ResponseEntity<?> registerCustomer(@Valid @RequestBody NewCustRequest newCustReq) throws DataValidationException {
	return new ResponseEntity<>("Customer added Successfully!, the CustId :- " + customerRegisterService.registerCustomer(newCustReq), HttpStatus.OK);
  }
}
