package com.cg.paymentapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.Transactionimplrepository;


@Service
public class TransactionServiceImpl implements ITransactionService {
	
	
    @Autowired 
	private Transactionimplrepository repo;
    
	@Override
	public Transaction addTransaction(Transaction transaction) throws InvalidInputException {
		return repo.save(transaction);
	}

	@Override
	public Transaction viewAllTransactions(Wallet wallet) throws InvalidInputException {
		return repo.viewAllTransactions(wallet.getWalletId());
	}

	@Override
	public List<Transaction> viewTransactionsByDate(LocalDate from, LocalDate to) throws InvalidInputException {
		return repo.viewTransactionsByDate(from, to);
	}

	@Override
	public List<Transaction> viewAllTransactions(String type) throws InvalidInputException {
		return repo.viewAllTransactions(type);
	}

	
	
	
	
}
