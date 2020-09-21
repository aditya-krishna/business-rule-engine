package com.example.enums;

public enum PaymentMode {
	COD("CASH_ON_DELIVERY"),
	CREDIT_CARD("CREDIT_CARD"),
	DEBIT_CARD("CREDIT_CARD"),
	ONLINE_BANKING("ONLINE_BANKING"),
	UPI("UPI");
	
	private String mode;
	
	private PaymentMode(String mode) {
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}
}
