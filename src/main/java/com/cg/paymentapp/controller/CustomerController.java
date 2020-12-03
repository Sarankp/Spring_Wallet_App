package com.cg.paymentapp.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
		//Customer customer=null;
		try {
			
		 Customer customer=userService.validateLogin(cust.getMobileNo(),cust.getPassword());
	if(customer==null)
	{
		throw new InvalidInputException(null);
	}
		}
		catch(InvalidInputException e)
		{
			return new ResponseEntity("Sorry! Login failed.Please enter correct credentials.",HttpStatus.NOT_FOUND);
		}
	//return new ResponseEntity("Login Successful!", HttpStatus.OK);
		return new ResponseEntity(cust.getMobileNo(),HttpStatus.OK);
	
}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
	}
