package com.cg.paymentapp.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import jdk.jfr.Name;

@Entity
@Table(name="Logindetails_table")
//@OnetoMany
public class Customer {
@Column	
private String name;
@Id
private String mobileNo;
@Column
private String password;
@OneToOne(cascade=CascadeType.ALL)
private Wallet wallet;

	public Customer() {
	}
	
	public Customer(String name, String mobileNum, Wallet wallet) {
		this.name=name;
		this.mobileNo=mobileNum;
		this.wallet=wallet;
}
	
	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Customer name=" + name + ", mobileNo=" + mobileNo;
//				 + wallet;
	}
	

	
	
}