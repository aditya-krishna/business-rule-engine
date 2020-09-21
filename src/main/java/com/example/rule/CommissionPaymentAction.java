package com.example.rule;

import com.example.entities.Order;
import com.example.service.PaymentService;

public class CommissionPaymentAction implements Action<Order> {
	private final PaymentService service;
	
	public CommissionPaymentAction(PaymentService service) {
		this.service = service;
	}

	@Override
	public void execute(Order order) {
		service.processCommissionPayment(order);
	}
}
