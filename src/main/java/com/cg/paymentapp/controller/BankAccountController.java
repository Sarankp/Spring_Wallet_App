package com.cg.paymentapp.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.BankAccountNotFoundException;
import com.cg.paymentapp.service.IAccountService;

 

@RestController
@RequestMapping("/account")
public class BankAccountController {
    @Autowired
    private IAccountService accountService;
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @PostMapping("/account/add")
    public ResponseEntity<BankAccount> addAccount(@RequestBody BankAccount bacc) throws BankAccountNotFoundException {


        Wallet account = accountService.addAccount(bacc);

 

        if(account == null) 
            return new ResponseEntity("Sorry! couldn't insert!", HttpStatus.NOT_FOUND);

 

        return new ResponseEntity<BankAccount>(bacc , HttpStatus.OK);

 

    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @DeleteMapping("/account/delete")
    public ResponseEntity<BankAccount> removeAccount(@PathVariable("bacc")BankAccount bacc) {

 

        Wallet account = null;
        try {
            account = accountService.removeAccount(bacc);
            if(account == null) 
                throw new BankAccountNotFoundException(null);
        } catch(BankAccountNotFoundException e) {
            return new ResponseEntity("Couldn't delete!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BankAccount>(bacc , HttpStatus.OK);

 

    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/account/view")
    public ResponseEntity<BankAccount> viewAccount(@PathVariable("bacc")BankAccount bacc) {

 

        Wallet account = null;
        try {
            account = accountService.viewAccount(bacc);
            if(account == null) 
                throw new BankAccountNotFoundException(null);
        } catch(BankAccountNotFoundException e) {
            return new ResponseEntity("Couldn't view!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BankAccount>(bacc, HttpStatus.OK);

 

    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/account/viewAll")
    public ResponseEntity<List<Wallet>> viewAllAccounts(@RequestBody Wallet wallet) throws BankAccountNotFoundException {

 

        Wallet wal=new Wallet();
        List<Wallet> bacc = accountService.viewAllAccounts(wallet);

 

        if(bacc.isEmpty()) {
            return new ResponseEntity("Account list not avialable", HttpStatus.NOT_FOUND);
        }

 

        return new ResponseEntity<List<Wallet>>(bacc, HttpStatus.OK);

 

    }
}