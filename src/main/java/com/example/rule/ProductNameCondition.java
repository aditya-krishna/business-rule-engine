package com.example.rule;

import com.example.entities.Product;

public class ProductNameCondition implements Condition<Product> {
	private String productName;
	
	public ProductNameCondition(String productName) {
		this.productName = productName;
	}
	
	@Override
	public boolean isValid(Product product) {
		return this.productName.equals(product.getName());
	}
}
