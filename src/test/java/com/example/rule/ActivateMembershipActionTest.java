package com.example.rule;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.entities.Order;
import com.example.service.MembershipService;

@RunWith(MockitoJUnitRunner.class)
public class ActivateMembershipActionTest {
	private ActivateMembershipAction action;
	
	@Mock
	private MembershipService service;

	@Before
	public void setUp() throws Exception {
		action = new ActivateMembershipAction(service);
	}

	@Test
	public void shouldActivateMembership() {
		Order order = new Order();
		
		action.execute(order);
		
		verify(service, times(1)).create(order);
		verifyNoMoreInteractions(service);
	}
}
