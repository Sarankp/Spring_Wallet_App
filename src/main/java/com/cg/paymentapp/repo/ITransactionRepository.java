package com.cg.paymentapp.repo;
import java.time.LocalDate;
import java.util.List;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;

public interface ITransactionRepository {
	Transaction addTransaction(Transaction transaction) throws InvalidInputException;
	List<Transaction> viewAllTransactions(Wallet wallet)  throws InvalidInputException;
	List<Transaction> viewTransactionsByDate(LocalDate localDate, LocalDate localDate1)  throws InvalidInputException;
	List<Transaction> viewAllTransactions(String s)  throws InvalidInputException;
	
}