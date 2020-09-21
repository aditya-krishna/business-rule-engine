package com.example.rule;

import com.example.entities.Product;
import com.example.enums.ProductCategory;

public class ProductCategoryCondition implements Condition<Product> {
	private final ProductCategory category;
	
	public ProductCategoryCondition(ProductCategory category) {
		this.category = category;
	}
	
	@Override
	public boolean isValid(Product product) {
		return category.equals(product.getCategory());
	}
}