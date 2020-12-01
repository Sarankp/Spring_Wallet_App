package com.cg.paymentapp.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.paymentapp.beans.BankAccount;

import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.IAccountService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServicetest {
	@Autowired
	private IAccountService accountService;
	@Test
	public final void testAddAccount() {
		BankAccount account = new BankAccount();
		account.setAccountNo(15);
		account.setIfscCode("144556");
		account.setBankName("epip");
		account.setBalance(679);
		Wallet wallet =new Wallet();
		wallet.setWalletId(15);
		account.setWallet(wallet);
		assertNotNull(accountService.addAccount(account));
}
	

	@Test
	public final void testRemoveAccount() {
		BankAccount account = new BankAccount();
		account.setAccountNo(14);
		account.setIfscCode("144558");
		account.setBankName("epip");
		account.setBalance(670);
		Wallet wallet =new Wallet();
		wallet.setWalletId(14);
		account.setWallet(wallet);
		assertNotNull(accountService.removeAccount(account));
		
	}

	@Test
	public final void testViewAccount() {
		BankAccount account = new BankAccount();
		account.setAccountNo(14);
		account.setIfscCode("144556");
		account.setBankName("epip");
		account.setBalance(679);
		Wallet wallet =new Wallet();
		wallet.setWalletId(14);
		account.setWallet(wallet);
		assertNotNull(accountService.viewAccount(account));
	
	}

	/*@Test
	public final void testViewAllAccounts() {
		fail("Not yet implemented");
	}*/

}
