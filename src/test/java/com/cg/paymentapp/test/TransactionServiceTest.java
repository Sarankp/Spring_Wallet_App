package com.cg.paymentapp.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.service.ITransactionService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {
	@Autowired
	private ITransactionService transactionService;

	@Test
	public final void testAddTransaction() throws InvalidInputException {
		Transaction transaction = new Transaction();
		transaction.setId(77);
		transaction.setTransactionType("debit");
		transaction.setAmount(3000);
		transaction.setDescription("your amount is debited");
		transaction.setTransactionDate(LocalDate.now());
		Wallet wallet = new Wallet();
		wallet.setWalletId(7);
		transaction.setWallet(wallet);
		assertNotNull(transactionService.addTransaction(transaction));
		
		
	}

	@Test
	public final void testViewAllTransactionsWallet() throws InvalidInputException {
		Transaction transaction1 = new Transaction();
		transaction1.setId(80);
		transaction1.setTransactionType("credit");
		transaction1.setAmount(4567);
		transaction1.setDescription("your amount is credited");
		transaction1.setTransactionDate(LocalDate.now());
		Wallet wallet1 = new Wallet();
		wallet1.setWalletId(8);
		transaction1.setWallet(wallet1);

		
//		Transaction transaction2 = new Transaction();
//		transaction2.setId(99);
//		transaction2.setTransactionType("debit");
//		transaction2.setAmount(3344);
//		transaction2.setDescription("your amount is debited");
//		transaction2.setTransactionDate(LocalDate.now());
//		Wallet wallet2 = new Wallet();
//		wallet2.setWalletId(3);
//		transaction1.setWallet(wallet2);
		
		List<Transaction> TransactionList = new ArrayList<>();
		TransactionList.add(transaction1);
//		TransactionList.add(transaction2);
		
		assertThat(transactionService.viewAllTransactions(wallet1)).isEqualTo(TransactionList);
        
		
		
		
		
	}

	@Test
	public final void testViewTransactionsByDate() {
		Transaction transaction1 = new Transaction();
		transaction1.setId(55);
		transaction1.setTransactionType("credit");
		transaction1.setAmount(45679);
		transaction1.setDescription("your amount is credited");
		transaction1.setTransactionDate(LocalDate.now());
		Wallet wallet1 = new Wallet();
		wallet1.setWalletId(88);
		transaction1.setWallet(wallet1);  
		
		Transaction transaction2 = new Transaction();
		transaction2.setId(99);
		transaction2.setTransactionType("debit");
	transaction2.setAmount(3344);
		transaction2.setDescription("your amount is debited");
		transaction2.setTransactionDate(LocalDate.now());
		Wallet wallet2 = new Wallet();
		wallet2.setWalletId(3);
		transaction1.setWallet(wallet2);
		
		
		
		List<Transaction> TransactionList = new ArrayList<>();
		TransactionList.add(transaction1);
		TransactionList.add(transaction2);

		//assertThat(transactionService.viewTransactionsByDate(localDate, localDate1)).isEqualTo(TransactionList);

	}

	@Test
	public final void testViewAllTransactionsString() throws InvalidInputException {
		Transaction transaction1 = new Transaction();
		transaction1.setId(33);
		transaction1.setTransactionType("credit");
		transaction1.setAmount(234);
		transaction1.setDescription("your amount is credited");
		transaction1.setTransactionDate(LocalDate.now());
		Wallet wallet1 = new Wallet();
		wallet1.setWalletId(22);
		transaction1.setWallet(wallet1); 
		List<Transaction> TransactionList = new ArrayList<>();
		TransactionList.add(transaction1);
		assertThat(transactionService.viewAllTransactions("credit")).isEqualTo(TransactionList);

	}

}
