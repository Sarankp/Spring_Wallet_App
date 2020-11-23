package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InsufficientBalanceException;

public interface IAccountService {

	public Wallet addAccount(BankAccount bacc)  throws InsufficientBalanceException;
	public Wallet removeAccount(BankAccount bacc)  throws InsufficientBalanceException;
	public Wallet viewAccount(BankAccount bacc)  throws InsufficientBalanceException;
	public List<Wallet> viewAllAccounts(Wallet wallet)  throws InsufficientBalanceException;
	
	
}