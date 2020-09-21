package com.example.rule;

import com.example.entities.Order;
import com.example.service.PackagingService;

public class FreeProductAction implements Action<Order> {
	private final PackagingService service;
	
	public FreeProductAction(PackagingService service) {
		this.service = service;
	}
	
	@Override
	public void execute(Order order) {
		service.addProductToPackingSlip(order.getFreeProduct());
	}
}
