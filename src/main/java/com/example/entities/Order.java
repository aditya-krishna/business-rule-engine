package com.example.entities;

public class Order {
	private long timestamp;
	
	private Address billingAddress;
	private Address shippingAddress;
	
	private Payment payment;

	private Product product;
	
	private String orderNumber;
	
	private User user;

	public long getTimestamp() {
		return timestamp;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public Payment getPayment() {
		return payment;
	}

	public Product getProduct() {
		return product;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
