package com.cg.paymentapp.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;

public interface ITransactionService {
	Transaction addTransaction(Transaction transaction) throws InvalidInputException;
	List<Transaction> viewAllTransactions(Wallet wallet) throws InvalidInputException;
	List<Transaction> viewTransactionsByDate(LocalDate localDate, LocalDate localDate1) throws InvalidInputException;
	List<Transaction> viewAllTransactions(String s) throws InvalidInputException;
	Transaction viewTransaction(int id) throws InvalidInputException;
}