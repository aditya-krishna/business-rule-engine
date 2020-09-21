package com.example.rule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.example.entities.Product;
import com.example.enums.ProductSubCategory;

public class ProductSubCategoryConditionTest {
	private ProductSubCategoryCondition condition;

	@Before
	public void setUp() throws Exception {
		condition = new ProductSubCategoryCondition(ProductSubCategory.BOOK);
	}

	@Test
	public void shouldReturnTrueWhenProductSubCategoryMatch() {
		Product product = new Product();
		product.setSubCategory(ProductSubCategory.BOOK);

		boolean actual = condition.isValid(product);

		assertTrue(actual);
	}
	
	@Test
	public void shouldReturnFalseWhenProductSubCategoryDoesNotMatch() {
		Product product = new Product();
		product.setSubCategory(ProductSubCategory.MEMBERSHIP_UPGRADE);

		boolean actual = condition.isValid(product);

		assertFalse(actual);
	}
}
