package com.cg.paymentapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.BankAccountNotFoundException;
import com.cg.paymentapp.repo.AccountRepositoryImpl;
//import com.cg.paymentapp.repo.IAccountRepository;
@Service
public class AccountServiceImpl implements IAccountService {
@Autowired
private AccountRepositoryImpl accountRepository;

 @Override
public Wallet addAccount(BankAccount bacc)throws BankAccountNotFoundException {
accountRepository.save(bacc);
return bacc.getWallet();
}

 @Override
public Wallet removeAccount(BankAccount bacc) throws BankAccountNotFoundException{
accountRepository.delete(bacc);
return bacc.getWallet();
}

 @Override
public Wallet viewAccount(BankAccount bacc) throws BankAccountNotFoundException {
accountRepository.getOne(bacc.getAccountNo());
return bacc.getWallet();
}

 @Override
public List<Wallet> viewAllAccounts(Wallet wallet) throws BankAccountNotFoundException {

 return accountRepository.findAllAccounts(wallet.getWalletId());
}

}