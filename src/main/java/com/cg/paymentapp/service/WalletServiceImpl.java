package com.cg.paymentapp.service;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.repo.WalletRepo;

public class WalletServiceImpl implements WalletService {	
@Autowired
 private WalletRepo walletrepo;

	@Override
	public Customer createAccount(String name, String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		Wallet wallet=new Wallet(amount);
		customer.setName(name);
		customer.setMobileNo(mobileNo);
		wallet.setAmount(amount);       //amount
		walletrepo.save(customer);
		return customer;
		
	}

	@Override
	public Customer showBalance(String mobileNo) {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		Wallet wallet=new Wallet();      //wallet
		customer.getMobileNo();
		wallet.getBalance();
		return customer;
		
	
		}

	@Override
	public boolean save(Customer customer) throws InvalidInputException {
		walletrepo.save(customer);
		return true;
		
	}

	@Override
	public Customer findOne(String mobileNo) throws InvalidInputException {
		Customer customer=new Customer();
		 customer.getMobileNo();
		 return customer;
		 
		
	}
	

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		Customer customer=new Customer();
        return customer;

		}
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		Customer customer=new Customer();
		return customer;
	}

	@Override
	public List<Customer> getList() {
		// TODO Auto-generated method stub
	    Customer customer=new Customer();
     return walletrepo.findAll(customer);
		
	}

	@Override
	public Customer addMoney(Wallet wallet, double amount) {         //BigDecimal amount//doask
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		customer.setWallet(wallet);
		customer.setAmount(amount);
		walletrepo.save(customer);
		return customer;
	}
	/*@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}*/

}