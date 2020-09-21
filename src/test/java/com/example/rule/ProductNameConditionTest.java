package com.example.rule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.example.entities.Product;

public class ProductNameConditionTest {
	private ProductNameCondition condition;

	@Before
	public void setUp() throws Exception {
		condition = new ProductNameCondition("productName");
	}

	@Test
	public void shouldReturnTrueWhenProductNameMatches() {
		Product product = new Product();
		product.setName("productName");
		
		boolean actual = condition.isValid(product);
		
		assertTrue(actual);
	}
	
	@Test
	public void shouldReturnFalseWhenProductNameDoesNotMatch() {
		Product product = new Product();
		product.setName("test");
		
		boolean actual = condition.isValid(product);
		
		assertFalse(actual);
	}
}
