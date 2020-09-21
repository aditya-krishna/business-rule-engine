package com.example.enums;

public enum ProductCategory {
	PHYSICAL_PRODUCT("PHYSICAL_PRODUCT"),
	DIGITAL_PRODUCT("DIGITAL_PRODUCT"),
	MEMBERSHIP("MEMBERSHIP");
	
	private String category;
	
	private ProductCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
}
