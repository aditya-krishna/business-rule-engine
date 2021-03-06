package com.example.service;

import com.example.entities.Order;
import com.example.entities.Product;
import com.example.entities.Royalty;

public interface PackagingService {
	public void generateSlip(Order order);
	
	public void generateDuplicateSlip(Royalty royalty);
	
	public void addProductToPackingSlip(Product product);
}
