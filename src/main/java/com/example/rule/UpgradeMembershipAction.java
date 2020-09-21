package com.example.rule;

import com.example.entities.Order;
import com.example.service.MembershipService;

public class UpgradeMembershipAction implements Action<Order> {
	private final MembershipService service;
	
	public UpgradeMembershipAction(MembershipService service) {
		this.service = service;
	}
	
	@Override
	public void execute(Order order) {
		service.upgrade(order);
	}
}
