package com.example.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.entities.Order;
import com.example.repository.RuleRepository;
import com.example.rule.Rule;
import com.example.rule.RuleNamespace;
import com.example.rule.RuleProcessor;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest {
	private PaymentServiceImpl service;
	
	@Mock
	private RuleProcessor<Order> ruleProcessor;
	
	@Mock
	private RuleRepository repository;

	@Before
	public void setUp() throws Exception {
		service = new PaymentServiceImpl(ruleProcessor, repository);
	}

	@Test
	public void shouldProcessPayment() {
		List<Rule> ruleList = new ArrayList<>();
		
		Order order = new Order();
		
		when(repository.findByNamespace(RuleNamespace.PAYMENT)).thenReturn(ruleList);
		
		service.process(order);
		
		verify(repository, times(1)).findByNamespace(RuleNamespace.PAYMENT);
		verifyNoMoreInteractions(repository);
		
		verify(ruleProcessor, times(1)).process(ruleList, order);
		verifyNoMoreInteractions(ruleProcessor);
	}
}
