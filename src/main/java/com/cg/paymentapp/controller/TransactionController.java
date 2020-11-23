package com.cg.paymentapp.controller;

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
@RequestMapping("/Transaction")
public class TransactionController {
	@Autowired
	private ITransactionService transactionService;
	
@GetMapping("Transaction/{id}")
	public ResponseEntity<Transaction> viewTransaction(@PathVariable("id") Integer id) {
		try {
			Transaction transaction = transactionService.viewTransaction(id);
		   return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
       } 
		catch(InvalidInputException e) {
			
		return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);			
		}
			}
	

	@GetMapping("/Transaction/viewall")
	public ResponseEntity<List<Transaction>> viewAllTransactionss() {
		try {
		List<Transaction> list = transactionService.viewAllTransactions("credit");
		return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);

		}
		catch(InvalidInputException e) {
     	   return new ResponseEntity<List<Transaction>>(HttpStatus.BAD_REQUEST);
		}
	}
	

@GetMapping("/Transaction/viewbydate")

public ResponseEntity<List<Transaction>> viewTransactionsByDate() {
	try {
	List<Transaction> list = transactionService.viewTransactionsByDate(null, null);
	return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);

	}
	catch(InvalidInputException e) {
 	   return new ResponseEntity<List<Transaction>>(HttpStatus.BAD_REQUEST);
	}
}

	


@GetMapping("/Transaction/viewbywallet")
public ResponseEntity<List<Transaction>> viewAllTransactions(@RequestBody Wallet wallet ) {
	try {
	List<Transaction> list = transactionService.viewAllTransactions(wallet);
	return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);

	}
	catch(InvalidInputException e) {
 	   return new ResponseEntity<List<Transaction>>(HttpStatus.BAD_REQUEST);
	}
}
	
@PostMapping("/Transaction/add")
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
		return new ResponseEntity<Transaction>(HttpStatus.OK);
		
	}
		return new ResponseEntity<Transaction>(HttpStatus.BAD_REQUEST);

	}
}
