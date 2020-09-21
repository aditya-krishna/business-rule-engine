package com.example.enums;

public enum ContactCategory {
	PRIMARY("PRIMARY"),
	SECONDARY("PRIMARY");
	
	private String category;
	
	private ContactCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
}
