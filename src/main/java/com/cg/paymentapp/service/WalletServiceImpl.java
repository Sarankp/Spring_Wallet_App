package com.cg.paymentapp.service;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.WalletRepository;
@Service
public class WalletServiceImpl implements WalletService {	
@Autowired
 private WalletRepository walletrepo;

	@Override
	public Customer createAccount(String name, String mobileNo, BigDecimal amount) {
		
		Customer customer=new Customer();
		Wallet wallet=new Wallet();
		wallet.setBalance(amount);
		customer.setName(name);
		customer.setMobileNo(mobileNo);
		customer.setWallet(wallet);

		//wallet.setAmount(amount);       //amount
		walletrepo.save(customer);
		return customer;
		
	}

	@Override
	public Customer showBalance(String mobileNo) {
		// TODO Auto-generated method stub
		Customer customer=walletrepo.findByMobileNo(mobileNo);
		return customer;
		
	
		}

	@Override
	public boolean save(Customer customer) throws InvalidInputException {
		walletrepo.save(customer);
		return true;
		
	}

	@Override
	public Customer findOne(String mobileNo) throws InvalidInputException {
		Customer customer=walletrepo.findByMobileNo(mobileNo);
		 return customer;
		 
		
	}
	

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) { //Todo
		Customer sourceCustomer=walletrepo.findByMobileNo(sourceMobileNo);
		Customer targetCustomer=walletrepo.findByMobileNo(targetMobileNo);
		BigDecimal amt=sourceCustomer.getWallet().getBalance();
		amt.subtract(amount);
		sourceCustomer.getWallet().setBalance(amt);
	    amt=targetCustomer.getWallet().getBalance();
		amt.add(amount);
		targetCustomer.getWallet().setBalance(amt);
		walletrepo.save(sourceCustomer);
		walletrepo.save(targetCustomer);

	 return targetCustomer;

		}
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		
    Customer customer=walletrepo.findByMobileNo(mobileNo);
      BigDecimal amt=customer.getWallet().getBalance();
      amt.add(amount);
      customer.getWallet().setBalance(amt);
      walletrepo.save(customer);
		return customer;
	}

	@Override
	public List<Customer> getList() {
	return walletrepo.findAll();
		
	}

	@Override
	public Customer addMoney(Wallet wallet, double amount) {         //BigDecimal amount//doask
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		BigDecimal balance=wallet.getBalance();
		balance.add(new BigDecimal(amount));
		wallet.setBalance(balance);
		customer.setWallet(wallet);
		walletrepo.save(customer);
		return customer;
	}
	/*@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}*/

	
	

}

	

