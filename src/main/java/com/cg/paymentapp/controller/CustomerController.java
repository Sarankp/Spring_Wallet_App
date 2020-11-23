package com.cg.paymentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.service.IUserService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/hello")
	public String sayHello() {
		System.out.println("hello........");
		return "Hello Cg! from Spring Framework!";
	}
	
	@GetMapping("/login")
	public ResponseEntity<Customer> validateLogin( @RequestBody Customer cust ) {
		Customer customer;
		try {
			
		 customer=userService.validateLogin("cust","cust");
	if(customer==null)
	{
		throw new InvalidInputException(null);
	}
		}
		catch(InvalidInputException e)
		{
			return new ResponseEntity("Sorry! Login failed",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	
}
	}