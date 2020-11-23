package com.cg.paymentapp.service;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.ITransactionRepository;


@Service



public class TransactionServiceImpl implements ITransactionService {
	
	ITransactionRepository repo;
	
	TransactionServiceImpl(ITransactionRepository repo){
		this.repo = repo;
	}
    @Autowired 
    private ITransactionRepository transactionService;
    
	@Override
	public Transaction addTransaction(Transaction transaction) throws InvalidInputException {
		return repo.addTransaction(transaction);
	}

	@Override
	public List<Transaction> viewAllTransactions(Wallet wallet) throws InvalidInputException {
		return repo.viewAllTransactions(wallet);
	}

	@Override
	public List<Transaction> viewTransactionsByDate(LocalDate from, LocalDate to) throws InvalidInputException {
		return repo.viewTransactionsByDate(from, to);
	}

	@Override
	public List<Transaction> viewAllTransactions(String type) throws InvalidInputException {
		return repo.viewAllTransactions(type);
	}

	@Override
	public Transaction viewTransaction(int id) throws InvalidInputException {
		return repo.viewTransaction(id);
	}
	
	
	
}
