package com.cg.paymentapp.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.Transaction;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private ITransactionService transactionService;
	


	@GetMapping("/transaction/viewall/{type}")
	public ResponseEntity<List<Transaction>> viewAllTransactionss(@PathVariable("type") String type) {
		try {
		List<Transaction> list = transactionService.viewAllTransactions(type);
		return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);

		}
		catch(InvalidInputException e) {
     	   return new ResponseEntity<List<Transaction>>(HttpStatus.BAD_REQUEST);
		}
	}
	

@GetMapping("/transaction/viewbydate/{from}/{to}")

public ResponseEntity<List<Transaction>> viewTransactionsByDate(@PathVariable("from") LocalDate from,@PathVariable("to") LocalDate to) {
	try {
	List<Transaction> list = transactionService.viewTransactionsByDate(from, to);
	return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);

	}
	catch(InvalidInputException e) {
 	   return new ResponseEntity<List<Transaction>>(HttpStatus.BAD_REQUEST);
	}
}

@GetMapping("/transaction/viewbywallet")
public ResponseEntity<Transaction> viewAllTransactions(@RequestBody Wallet wallet ) {
	try {
	Transaction wall = transactionService.viewAllTransactions(wallet);
	return new ResponseEntity<Transaction>(wall, HttpStatus.OK);

	}
	catch(InvalidInputException e) {
 	   return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
	}
}
	
@PostMapping("/transaction/add")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction tx ){
		Transaction transaction = null;
		try {
			transaction = transactionService.addTransaction(tx);
		if(transaction== null)
			{
				
			return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);

		}
	}
		catch(InvalidInputException ie) {
		return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);
		
	}
		return new ResponseEntity<Transaction>(HttpStatus.OK);

	}
}