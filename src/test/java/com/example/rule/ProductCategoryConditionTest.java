package com.example.rule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.example.entities.Product;
import com.example.enums.ProductCategory;

public class ProductCategoryConditionTest {
	private ProductCategoryCondition condition;

	@Before
	public void setUp() throws Exception {
		condition = new ProductCategoryCondition(ProductCategory.PHYSICAL_PRODUCT);
	}

	@Test
	public void shouldReturnTrueWhenProductCategoryMatch() {
		Product product = new Product();
		product.setCategory(ProductCategory.PHYSICAL_PRODUCT);
		
		boolean actual = condition.isValid(product);
		
		assertTrue(actual);
	}
	
	@Test
	public void shouldReturnFalseWhenProductCategoryDoesNotMatch() {
		Product product = new Product();
		product.setCategory(ProductCategory.MEMBERSHIP);
		
		boolean actual = condition.isValid(product);
		
		assertFalse(actual);
	}
}
