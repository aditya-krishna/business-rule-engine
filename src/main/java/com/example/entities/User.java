package com.example.entities;

import java.util.List;

public class User {
	private List<Address> addressList;
	private List<Contact> contactList;
	
	private String firstName;
	private String lastName;
	private String username;
	
	public List<Address> getAddressList() {
		return addressList;
	}

	public List<Contact> getContactList() {
		return contactList;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getUsername() {
		return username;
	}
}
