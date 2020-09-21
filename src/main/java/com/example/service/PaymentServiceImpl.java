package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entities.Order;
import com.example.repository.RuleRepository;
import com.example.rule.RuleNamespace;
import com.example.rule.RuleProcessor;
 
@Service
public class PaymentServiceImpl implements PaymentService {
	private final RuleProcessor<Order> ruleProcessor;
	
	private final RuleRepository repository;
	
	public PaymentServiceImpl(RuleProcessor<Order> ruleProcessor, RuleRepository repository) {
		this.ruleProcessor = ruleProcessor;
		this.repository = repository;
	}

	@Override
	public void process(Order order) {
		this.ruleProcessor.process(repository.findByNamespace(RuleNamespace.PAYMENT), order);
	}

	@Override
	public void processCommissionPayment(Order order) {
		// TODO Auto-generated method stub
	}
}