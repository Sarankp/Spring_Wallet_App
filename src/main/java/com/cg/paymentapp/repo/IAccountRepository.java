package com.cg.paymentapp.repo;

import java.util.List;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.BankAccountNotFoundException;

public interface IAccountRepository {

 public Wallet addAccount(BankAccount bacc) throws BankAccountNotFoundException ;
public Wallet removeAccount(BankAccount bacc) throws BankAccountNotFoundException ;
public Wallet viewAccount(BankAccount bacc) throws BankAccountNotFoundException ;
public List<Wallet> viewAllAccounts(Wallet wallet) throws BankAccountNotFoundException ;

}