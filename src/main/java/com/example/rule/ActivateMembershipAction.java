package com.example.rule;

import com.example.entities.Order;
import com.example.service.MembershipService;

public class ActivateMembershipAction implements Action<Order> {
	private final MembershipService service;
	
	public ActivateMembershipAction(MembershipService service) {
		this.service = service;
	}
	
	@Override
	public void execute(Order order) {
		service.create(order);
	}
}
