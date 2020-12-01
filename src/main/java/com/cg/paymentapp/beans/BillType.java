package com.cg.paymentapp.beans;

import java.util.Arrays;

public enum BillType {

	//DTH,MobilePrepaid,MobilePostpaid,CreditCard,LICPremium,LPG;
	
DTH("DTH"),MobilePrepaid("MobilePrepaid"),MobilePostpaid("MobilePostpaid"),CreditCard("CreditCard"),LICPremium("LICPremium"),LPG("LPG");
	
	private String value;

	private BillType(String value) {
		this.value = value;
	}

	public static BillType fromValue(String value) {
		for (BillType billtype : values()) {
			if (billtype.value.equalsIgnoreCase(value)) {
				return billtype;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
