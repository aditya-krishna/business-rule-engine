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
import com.example.service.PaymentService;

@RunWith(MockitoJUnitRunner.class)
public class CommissionPaymentActionTest {
	private CommissionPaymentAction action;
	
	@Mock
	private PaymentService service;

	@Before
	public void setUp() throws Exception {
		action = new CommissionPaymentAction(service);
	}

	@Test
	public void shouldProcessComissionPayment() {
		Order order = new Order();
		action.execute(order);
		
		verify(service, times(1)).processCommissionPayment(order);
		verifyNoMoreInteractions(service);
	}
}
