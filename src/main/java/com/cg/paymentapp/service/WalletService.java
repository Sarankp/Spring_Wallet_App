package com.cg.paymentapp.service;
import java.math.BigDecimal;
import java.util.List;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
 

public interface WalletService {
public Customer createAccount(String name ,String mobileno, BigDecimal amount);
public Customer showBalance (String mobileno);
public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, BigDecimal amount);
public Customer depositAmount (String mobileNo,BigDecimal amount );
//public Customer withdrawAmount(String mobileNo, BigDecimal amount);
//public Wallet updateAccount(Wallet wobj);
public Customer addMoney(Wallet wallet, double amount);
public boolean save(Customer customer) throws InvalidInputException;
 Customer findOne(String mobileNo) throws InvalidInputException;
List<Customer> getList();
}
