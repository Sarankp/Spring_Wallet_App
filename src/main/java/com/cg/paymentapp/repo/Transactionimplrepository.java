package com.cg.paymentapp.repo;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.exception.InvalidInputException;
@Repository
public interface Transactionimplrepository extends JpaRepository<Transaction, Integer> {
	@Query("SELECT wallet FROM Wallet wallet WHERE wallet.id=:id")
	Transaction viewAllTransactions(@Param("id") int id) throws InvalidInputException;
	@Query("SELECT transaction FROM Transaction transaction WHERE transaction.transactionDate BETWEEN :from AND :to")
     List<Transaction> viewTransactionsByDate(@Param("from") LocalDate from, @Param("to") LocalDate to) throws InvalidInputException;
	@Query("SELECT transaction FROM Transaction transaction WHERE transaction.transactionType=:type")
	List<Transaction> viewAllTransactions(@Param("type") String type) throws InvalidInputException;
	
}
