package com.cg.paymentapp.beans;
import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

//import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
@Table(name="beneficiary_details_table")
public class BeneficiaryDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
 private int beneficiaryId;
	
 @Column
 private String name;
 @Column
 private String mobNo;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="walletId")
 private Wallet wallet;
 

public BeneficiaryDetails() {
	
}
public BeneficiaryDetails(int beneficiaryId, String name, String mobNo, Wallet wallet) {
	super();
	this.beneficiaryId = beneficiaryId;
	this.name = name;
	this.mobNo = mobNo;
	this.wallet = wallet;
}
public Wallet getWallet() {
	return wallet;
}
public void setWallet(Wallet wallet) {
	this.wallet = wallet;
}
public void setMobNo(String mobNo) {
	this.mobNo = mobNo;
}
public int getBeneficiaryId() {
	return beneficiaryId;
}
public void setBeneficiaryId(int beneficiaryId) {
	this.beneficiaryId = beneficiaryId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getMobNo() {
	return mobNo;
}
public void setMobileNumber(String mobNo) {
	this.mobNo = mobNo;
}
@Override
public String toString() {
	return "BeneficiaryDetails [beneficiaryId=" + beneficiaryId + ", name=" + name + ", mobNo=" + mobNo
			+ "]";
}
}

