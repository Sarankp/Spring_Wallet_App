package com.cg.paymentapp.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;
@Repository
public interface WalletRepo extends JpaRepository<Customer,String>{

	public boolean save(Customer customer) throws InvalidInputException;
	public Customer findOne(String mobileNo) throws InvalidInputException;
	public List<Customer> getList()throws InvalidInputException;
	
}
	
	/*public com.cg.paymentapp.service.Customer createAccount(String name);
	public com.cg.paymentapp.service.Customer showBalance(String mobileno);
}*/