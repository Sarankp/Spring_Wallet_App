package com.cg.paymentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InsufficientBalanceException;
import com.cg.paymentapp.repo.IAccountRepository;
@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public Wallet addAccount(BankAccount bacc) {
		accountRepository.save(bacc);
		return bacc.getWallet();
	}

	@Override
	public Wallet removeAccount(BankAccount bacc) {
		accountRepository.removeAccount(bacc);
		return bacc.getWallet();
	}

	@Override
	public Wallet viewAccount(BankAccount bacc) throws InsufficientBalanceException {
		accountRepository.viewAccount(bacc);
		return bacc.getWallet();
	}

	@Override
	public List<Wallet> viewAllAccounts(Wallet wallet) {

		return  accountRepository.viewAllAccounts(wallet);
	}

}