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
import com.example.service.MembershipService;

@RunWith(MockitoJUnitRunner.class)
public class UpgradeMembershipActionTest {
	private UpgradeMembershipAction action;
	
	@Mock
	private MembershipService service;

	@Before
	public void setUp() throws Exception {
		action = new UpgradeMembershipAction(service);
	}

	@Test
	public void shouldUpgradeMembership() {
		Order order = new Order();
		
		action.execute(order);
		
		verify(service, times(1)).upgrade(order);
		verifyNoMoreInteractions(service);
	}
}
