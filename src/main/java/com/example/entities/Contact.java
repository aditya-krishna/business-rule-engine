package com.example.entities;

import com.example.enums.ContactCategory;
import com.example.enums.ContactMethod;

public class Contact {
	private ContactCategory category;
	private ContactMethod type;
	
	private String value;

	public ContactCategory getCategory() {
		return category;
	}

	public ContactMethod getType() {
		return type;
	}

	public String getValue() {
		return value;
	}
}
