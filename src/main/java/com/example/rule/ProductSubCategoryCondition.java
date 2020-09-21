package com.example.rule;

import com.example.entities.Product;
import com.example.enums.ProductSubCategory;

public class ProductSubCategoryCondition implements Condition<Product> {
	private final ProductSubCategory category;
	
	public ProductSubCategoryCondition(ProductSubCategory category) {
		this.category = category;
	}
	
	@Override
	public boolean isValid(Product product) {
		return category.equals(product.getSubCategory());
	}
}
