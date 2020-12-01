package com.cg.paymentapp.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.service.WalletService;



@RestController
@RequestMapping("/Wallet")
public class WalletController {
		@Autowired
		private WalletService walletservice;
		 
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@PostMapping("/create")
		public ResponseEntity<Customer> create(@RequestParam String name,@RequestParam String mobileNo,@RequestParam BigDecimal amount ){  //
			//@RequestBody Customer c;
			
			Customer cu = null;
			try {
				cu = walletservice.createAccount(name,mobileNo,amount);         // arguments
				if(cu == null)
				{
					throw new InvalidInputException(null);
				}
			}catch(InvalidInputException m) {
				return new ResponseEntity("Sorry! couldn't create!", HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<Customer>(cu,HttpStatus.OK);
		}
	
	
		@SuppressWarnings({ "unchecked", "rawtypes"})
		@PutMapping("/save")
		public ResponseEntity<Boolean> add(@RequestBody Customer c ){    
			boolean cu = false;
			try {
				cu = walletservice.save(c);
				if(cu == false)
				{
					throw new InvalidInputException(null);
				}
			}catch(InvalidInputException msg) {
				return new ResponseEntity("Sorry! couldn't save!", HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<Boolean>(cu,HttpStatus.OK);
			
			
		}
	
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@GetMapping("/list")
		public ResponseEntity<List<Customer>> getList(){
			List<Customer> cu= walletservice.getList();
			if(cu.isEmpty()) {
				return new ResponseEntity("Sorry!  not available!", 
						HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<List<Customer>>(cu, HttpStatus.OK);
		}
	
	
	
         @SuppressWarnings({ "unchecked", "rawtypes" })
         @GetMapping("/findone")
         public ResponseEntity<Customer>findone(@RequestBody String m){//
	       Customer cu = null;
	       try {
		   cu = walletservice.showBalance(m);
		     if(cu == null)
		    {
			throw new InvalidInputException(null);
		   }
	          }catch(InvalidInputException msg) {
		  new ResponseEntity("Sorry! couldn't save!", HttpStatus.NOT_FOUND);
		
	      }
	     return new ResponseEntity<Customer>(cu,HttpStatus.OK);
	
}
         
         
        @SuppressWarnings({ "unchecked", "rawtypes" })
         @GetMapping("/show")
         public ResponseEntity<Customer>show(@RequestBody String m){//
	   Customer cu = null;
	   try {
		cu = walletservice.showBalance(m);
		if(cu == null)
		{
			throw new InvalidInputException(null);
		}
	    }catch(InvalidInputException msg) {
		return new ResponseEntity("Sorry! couldn't save!", HttpStatus.NOT_FOUND);
		
	   }
	    return new ResponseEntity<Customer>(cu,HttpStatus.OK);
	
}
}
