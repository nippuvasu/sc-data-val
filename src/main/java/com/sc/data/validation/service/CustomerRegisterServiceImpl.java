package com.sc.data.validation.service;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.data.validation.exception.DataValidationException;
import com.sc.data.validation.payload.NewCustRequest;
import com.sc.data.validation.repository.CustomerRepository;
import com.sc.data.validation.entity.Customer;

@Service
public class CustomerRegisterServiceImpl implements CustomerRegisterService {
    
	@Autowired
	private DataValidator dataValidator;
	
	@Autowired
	private CustomerRepository custRepo;
	
	
	private ExecutorService executor = Executors.newCachedThreadPool();

	@SuppressWarnings("unchecked")
	@Override
	public String registerCustomer(final NewCustRequest newCustreq) throws DataValidationException{

		//making below 3 validation methods async and parallel
		Callable<Boolean> task = () -> dataValidator.isValidSSN(newCustreq.getSsn());
		Callable<Boolean> task1 = () -> dataValidator.isValidPhoneNum(newCustreq.getPhone());
		Callable<Boolean> task2 = () -> dataValidator.isValidEmail(newCustreq.getEmail());
		
		Future<Boolean> isSsnValid = (Future<Boolean>) executor.submit(task);
		Future<Boolean> isPhoneNumValid = (Future<Boolean>) executor.submit(task1) ;
		Future<Boolean> isEmailValid = (Future<Boolean>) executor.submit(task2);

		while( !(isSsnValid.isDone() && isPhoneNumValid.isDone() && isEmailValid.isDone())) {
			System.out.print("Still working......");
		}

		try {
			if( !isSsnValid.get()) {
				throw new DataValidationException("SSN is not valid / does not exist");
			}

			if( !isEmailValid.get()) {
				throw new DataValidationException("Email is not valid  /does not exist");
			}
			if( !isPhoneNumValid.get()) {
				throw new DataValidationException("Phone number is not valid/does not exist");
			}

		} catch (InterruptedException e) {
			throw new DataValidationException("Exception while processing cutomer data");
			
			
		} catch (ExecutionException e) {
			throw new DataValidationException("exception while processing cutomer data");
		}

		//DB operation with customer details goes here.
		
		Customer cust = new Customer(newCustreq.getName(),newCustreq.getEmail(),newCustreq.getPhone(),newCustreq.getSsn());
		custRepo.save(cust);
		
		return String.valueOf(cust.getId());
	}

}


