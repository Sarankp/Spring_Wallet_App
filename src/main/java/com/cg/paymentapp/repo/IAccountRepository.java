package com.cg.paymentapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InsufficientBalanceException;
@Repository
public interface IAccountRepository extends JpaRepository<BankAccount,Integer>{

	public Wallet addAccount(BankAccount bacc) throws InsufficientBalanceException;
	public Wallet removeAccount(BankAccount bacc)  throws InsufficientBalanceException;
	public Wallet viewAccount(BankAccount bacc)  throws InsufficientBalanceException;
	public List<Wallet> viewAllAccounts(Wallet wallet)  throws InsufficientBalanceException;
	
	
}