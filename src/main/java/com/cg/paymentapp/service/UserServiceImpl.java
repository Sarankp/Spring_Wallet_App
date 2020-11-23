package com.cg.paymentapp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {
	
@Autowired
 IUserRepo userrepo;

public Customer validateLogin(String mobileNumber, String password) throws InvalidInputException {
	// TODO Auto-generated method stub
    
	  Customer customer=new Customer();
	 Customer ouser = userrepo.findCustomerBymobileNoAndPassword(customer.getMobileNo(),customer.getPassword());
   
	 
	 
	 return ouser;
	
}
}