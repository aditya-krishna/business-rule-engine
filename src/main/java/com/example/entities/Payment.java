package com.example.entities;

import com.example.enums.PaymentMode;

public class Payment {
	private long timestamp;
	
	private PaymentMode paymentMode;
	
	private String transactionId;

	public long getTimestamp() {
		return timestamp;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public String getTransactionId() {
		return transactionId;
	}
}