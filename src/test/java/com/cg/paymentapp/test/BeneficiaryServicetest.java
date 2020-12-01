package com.cg.paymentapp.test;
import static org.junit.Assert.*;

//import java.util.ArrayList;
//import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.paymentapp.beans.BeneficiaryDetails;
//import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.service.IBeneficiaryService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeneficiaryServicetest {
	@Autowired
	private IBeneficiaryService beneficiaryService;
	@Test
	public final void testAddBeneficiary() throws InvalidInputException {
			BeneficiaryDetails beneficiary = new BeneficiaryDetails();
			beneficiary.setBeneficiaryId(141);
			beneficiary.setName("saru");
			beneficiary.setMobNo("7989197550");
			Wallet wallet =new Wallet();
			wallet.setWalletId(140);
			beneficiary.setWallet(wallet);
			assertNotNull(beneficiaryService.addBeneficiary(beneficiary));
	}
	
	@Test
	public final void testUpdateBeneficiary() {
		BeneficiaryDetails beneficiary = new BeneficiaryDetails();
		beneficiary.setBeneficiaryId(91);
		beneficiary.setName("sam");
		beneficiary.setMobNo("9876543210");
		Wallet wallet =new Wallet();
		wallet.setWalletId(91);
		beneficiary.setWallet(wallet);
		assertNotNull(beneficiaryService.updateBeneficiary(beneficiary));
		
	}

@Test
	public final void testDeleteBeneficiary(){
	BeneficiaryDetails beneficiary = new BeneficiaryDetails();
	beneficiary.setBeneficiaryId(131);
	beneficiary.setName("sam");
	beneficiary.setMobNo("987654321");
	Wallet wallet =new Wallet();
	wallet.setWalletId(131);
	beneficiary.setWallet(wallet);
	assertNotNull(beneficiaryService.deleteBeneficiary(beneficiary));
	}

	@Test
	public final void testGetBeneficiary() {
	BeneficiaryDetails beneficiary = new BeneficiaryDetails();
	beneficiary.setBeneficiaryId(95);
	beneficiary.setName("sam");
	beneficiary.setMobNo("987654321");
	Wallet wallet =new Wallet();
	wallet.setWalletId(95);
	beneficiary.setWallet(wallet);
	assertNotNull(beneficiaryService.viewBeneficiary(beneficiary));
		
	}

	/*@Test
	public final void testGetAllBeneficiary() {
	BeneficiaryDetails beneficiary1 = new BeneficiaryDetails();
	beneficiary1.setBeneficiaryId(3);
	beneficiary1.setName("sai");
	beneficiary1.setMobNo("7989197550");
	Wallet wallet =new Wallet();
	wallet.setWalletId(3);
	beneficiary1.setWallet(wallet);
	
	BeneficiaryDetails beneficiary2 = new BeneficiaryDetails();
	beneficiary2.setBeneficiaryId(5);
	beneficiary2.setName("saru");
	beneficiary2.setMobNo("9948469920");
	Wallet wallet1 =new Wallet();
	wallet.setWalletId(5);
	beneficiary1.setWallet(wallet1);
	List<BeneficiaryDetails> beneficiaryList = new ArrayList<>();
	beneficiaryList.add(beneficiary1);
	beneficiaryList.add(beneficiary2);
	assertNotNull(beneficiaryService.viewAllBeneficiary(null));
	}*/

}
