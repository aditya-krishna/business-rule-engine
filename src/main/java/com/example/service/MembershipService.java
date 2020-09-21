package com.example.service;

import com.example.entities.Order;

public interface MembershipService {
	public void create(Order order);
	
	public void upgrade(Order oder);
}
