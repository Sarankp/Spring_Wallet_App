package com.cg.paymentapp.beans;

import java.beans.PropertyEditorSupport;

public class BillTypeConverter extends PropertyEditorSupport {
	 public void setAsText(final String text) throws IllegalArgumentException {
	        setValue(BillType.fromValue(text));
	    }

}
