package com.example.rule;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.timeout;
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
public class PackingSlipActionTest {
	private PackingSlipAction action;
	
	@Mock
	private PackagingService service;

	@Before
	public void setUp() throws Exception {
		action = new PackingSlipAction(service);
	}

	@Test
	public void shouldExecuteAction() {
		Order order = new Order();
		
		action.execute(order);
		
		verify(service, times(1)).generateSlip(order);
		verifyNoMoreInteractions(service);
	}
}
