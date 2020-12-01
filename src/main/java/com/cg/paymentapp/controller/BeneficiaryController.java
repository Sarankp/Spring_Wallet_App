package com.cg.paymentapp.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.paymentapp.beans.BeneficiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.service.IBeneficiaryService;

@RestController
@RequestMapping("/beneficiary")

public class BeneficiaryController {
	@Autowired
	private IBeneficiaryService beneficiaryService;
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/beneficiary/add")
	public ResponseEntity<BeneficiaryDetails> addBeneficiary(@RequestBody BeneficiaryDetails bd ){
		BeneficiaryDetails beneficiary = null;
		try {
			beneficiary = beneficiaryService.addBeneficiary(bd);
			if(beneficiary== null)
			{
				throw new InvalidInputException(null);
			}
		}catch(InvalidInputException iie) {
			return new ResponseEntity("Sorry! couldn't add!", HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<BeneficiaryDetails>(beneficiary,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/beneficiary/update")
	public ResponseEntity<BeneficiaryDetails> updateBeneficiary(@RequestBody BeneficiaryDetails bd ){
		BeneficiaryDetails beneficiary = null;
		try {
			beneficiary = beneficiaryService.updateBeneficiary(bd);
			if(beneficiary == null)
			{
				throw new InvalidInputException(null);
			}
		}catch(InvalidInputException iie) {
			return new ResponseEntity("Sorry! couldn't update!", HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<BeneficiaryDetails>(beneficiary,HttpStatus.OK);
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/beneficiary/delete")
	public ResponseEntity<BeneficiaryDetails> deleteBeneficiary(@RequestBody BeneficiaryDetails bd ){
		BeneficiaryDetails beneficiary = null;
		try {
			beneficiary = beneficiaryService.deleteBeneficiary(bd);
			if(beneficiary == null)
			{
				throw new InvalidInputException(null);
			}
		}catch(InvalidInputException iie) {
			return new ResponseEntity("Sorry! couldn't remove!", HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<BeneficiaryDetails>(beneficiary,HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/beneficiary/view")
	public ResponseEntity<BeneficiaryDetails> viewBeneficiary(@RequestBody BeneficiaryDetails bd ){
		BeneficiaryDetails beneficiary = null;
		try {
			beneficiary = beneficiaryService.deleteBeneficiary(bd);
			if(beneficiary == null)
			{
				throw new InvalidInputException(null);
			}
		}catch(InvalidInputException iie) {
			return new ResponseEntity("Sorry! couldn't view!", HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<BeneficiaryDetails>(beneficiary,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@GetMapping("/beneficiary/viewAll")
	
	public ResponseEntity<List<BeneficiaryDetails>> viewAllBeneficiary(@RequestBody Customer customer ){
		Customer cust = new Customer();
		
			List<BeneficiaryDetails>beneficiary = beneficiaryService.viewAllBeneficiary(cust);
			if(beneficiary.isEmpty())
			{
				
			return new ResponseEntity("Sorry! couldn't viewAll!", HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<List<BeneficiaryDetails>>(beneficiary,HttpStatus.OK);
	}
}
	
	
	
