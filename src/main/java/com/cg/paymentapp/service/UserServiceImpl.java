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
@Override
public Customer validateLogin(String mobileNumber, String password) throws InvalidInputException {
	// TODO Auto-generated method stub
    
	 
	 Customer ouser = userrepo.findByMobileNoAndPassword(mobileNumber,password);
	 return ouser;
	

	//return userrepo.validateLogin(mobileNumber,password);
	
}
}