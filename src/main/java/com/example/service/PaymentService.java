package com.example.service;

import com.example.entities.Order;

public interface PaymentService {
	public void process(Order order);
}