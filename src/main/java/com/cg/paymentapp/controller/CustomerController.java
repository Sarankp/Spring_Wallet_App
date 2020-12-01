package com.cg.paymentapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.service.IUserService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private IUserService userService;
	@GetMapping("/hello")
	public String sayHello() {
		System.out.println("hello........");
		return "Hello Cg! from Spring Framework!";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/login")
	public ResponseEntity<Customer> validateLogin(@RequestBody Customer cust ) {
		Customer customer=null;
		try {
			
		 customer=userService.validateLogin(cust.getMobileNo(),cust.getPassword());
	if(customer==null)
	{
		throw new InvalidInputException(null);
	}
		}
		catch(InvalidInputException e)
		{
			return new ResponseEntity("Sorry! Login failed.Please enter correct credentials.",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Login Successful!", HttpStatus.OK);

	
}
	}