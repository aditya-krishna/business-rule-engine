package com.example.enums;

public enum ProductSubCategory {
	BOOK("BOOK"),
	NEW_MEMBERSHIP("NEW_MEMBERSHIP"),
	MEMBERSHIP_UPGRADE("MEMBERSHIP_UPGRADE"),
	VIDEO("VIDEO");
	
	private String subCategory;
	
	private ProductSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getSubCategory() {
		return subCategory;
	}
}
