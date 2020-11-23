package com.cg.paymentapp.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="benificiaryDetails_table")
public class BenificiaryDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	
 private int beneficiaryId;
 @Column
 private String name;
 @Column
 private String mobNo;
 
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
public BenificiaryDetails(int beneficiaryId, String name, String mobNo) {
	super();
	this.beneficiaryId = beneficiaryId;
	this.name = name;
	this.mobNo = mobNo;
	
}

}