package com.example.rule;

import com.example.entities.Order;
import com.example.service.PackagingService;

public class PackingSlipAction implements Action<Order> {
	private final PackagingService service;
	
	public PackingSlipAction(PackagingService service) {
		this.service = service;
	}
	
	@Override
	public void execute(Order order) {
		this.service.generateSlip(order);
	}
}