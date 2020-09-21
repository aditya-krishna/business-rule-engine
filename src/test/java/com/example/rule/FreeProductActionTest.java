package com.example.rule;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.entities.Order;
import com.example.service.PackagingService;

@RunWith(MockitoJUnitRunner.class)
public class FreeProductActionTest {
	private FreeProductAction action;
	
	@Mock
	private PackagingService service;

	@Before
	public void setUp() throws Exception {
		action = new FreeProductAction(service);
	}

	@Test
	public void shouldAddFreeProduct() {
		Order order = new Order();
		
		action.execute(order);
		
		verify(service, times(1)).addProductToPackingSlip(order.getFreeProduct());
		verifyNoMoreInteractions(service);
	}
}
