package com.example.entities;

import com.example.enums.ProductCategory;
import com.example.enums.ProductSubCategory;

public class Product {
	private ProductCategory category;
	private ProductSubCategory subCategory;
	
	private Royalty royalty;

	private String name;
	private String sku;
	private String description;
	
	private User agent;

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public ProductSubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(ProductSubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Royalty getRoyalty() {
		return royalty;
	}

	public String getName() {
		return name;
	}

	public String getSku() {
		return sku;
	}

	public String getDescription() {
		return description;
	}

	public User getAgent() {
		return agent;
	}
}
