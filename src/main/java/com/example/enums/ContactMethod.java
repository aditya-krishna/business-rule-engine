package com.example.enums;

public enum ContactMethod {
	EMAIL("EMAIL"),
	MOBILE("MOBILE");
	
	private String contactType;
	
	private ContactMethod(String contactType) {
		this.contactType = contactType;
	}

	public String getContactType() {
		return contactType;
	}
}
