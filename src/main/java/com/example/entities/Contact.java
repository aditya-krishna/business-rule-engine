package com.example.entities;

import com.example.enums.ContactCategory;
import com.example.enums.ContactMethod;

public class Contact {
	private ContactCategory category;
	private ContactMethod type;
	
	private String value;
	
	private Contact() {
		
	}
	
	private Contact(Builder builder) {
		this.category = builder.category;
		this.type = builder.type;
		this.value = builder.value;
	}

	public ContactCategory getCategory() {
		return category;
	}

	public ContactMethod getType() {
		return type;
	}

	public String getValue() {
		return value;
	}
	
	public static class Builder {
		private ContactCategory category;
		private ContactMethod type;
		
		private String value;
		
		public Builder withCategory(ContactCategory category) {
			this.category = category;
			return this;
		}
		
		public Builder withMethod(ContactMethod type) {
			this.type = type;
			return this;
		}
		
		public Builder withValue(String value) {
			this.value = value;
			return this;
		}
		
		public Contact build() {
			return new Contact(this);
		}
	}
}
