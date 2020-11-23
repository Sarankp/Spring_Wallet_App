package com.cg.paymentapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.service.WalletService;



@RestController
@RequestMapping("/Wallet ")
public class WalletController {
		@Autowired
		private WalletService walletservice;
		 
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@PutMapping("/Wallet/createAccount")
		public ResponseEntity<Customer> createAccount(@RequestBody Customer c ){  //
			Customer cu = null;
			try {
				cu = walletservice.createAccount(c);         // arguments
				if(cu == null)
				{
					throw new InvalidInputException(null);
				}
			}catch(InvalidInputException m) {
				return new ResponseEntity("Sorry! couldn't create!", HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<Customer>(cu,HttpStatus.OK);
			
		}
	
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@PostMapping("/Wallet/save")
		public ResponseEntity<Customer>save(@RequestBody Customer c ){//
			Customer cu = null;
			try {
				cu = walletservice.save(c);
				if(cu == null)
				{
					throw new InvalidInputException(null);
				}
			}catch(InvalidInputException m) {
				return new ResponseEntity("Sorry! couldn't save!", HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<Customer>(cu,HttpStatus.OK);
			
		}
	
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@GetMapping("/Wallet/findOne")
		public ResponseEntity<Customer>findOne(@RequestBody Customer c ){//
			Customer cu = null;
			try {
				cu = walletservice.findOne(c);
				if(cu == null)
				{
					throw new InvalidInputException(null);
				}
			}catch(InvalidInputException m) {
				return new ResponseEntity("Sorry! couldn't save!", HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<Customer>(cu,HttpStatus.OK);
			
		}
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@GetMapping("/Wallet/")
		public ResponseEntity<List<Customer>> getList(){
			List<Customer> cu= walletservice.getList();
			if(cu.isEmpty()) {
				return new ResponseEntity("Sorry!  not available!", 
						HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<List<Customer>>(cu, HttpStatus.OK);
		}
	}
