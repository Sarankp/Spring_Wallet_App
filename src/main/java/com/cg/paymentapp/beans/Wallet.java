package com.cg.paymentapp.beans;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="wallet_table")
public class Wallet {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="wallet_id")
private int walletId;
@Column
private BigDecimal balance;
public Wallet(){
	
}
public Wallet(int walletId1, BigDecimal balance1) {

this.walletId=walletId1;
this.balance=balance1;
}



public int getWalletId() {
	return walletId;
}
public void setWalletId(int walletId) {
	this.walletId = walletId;
}

public BigDecimal getBalance() {
	return balance;
}
public void setBalance(BigDecimal balance) {
	this.balance = balance;
}


@Override
public String toString() {
	return "Wallet [walletId=" + walletId + ", balance=" + balance + "]";
}

}