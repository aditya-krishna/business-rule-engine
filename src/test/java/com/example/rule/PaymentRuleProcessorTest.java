package com.example.rule;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.entities.Order;

public class PaymentRuleProcessorTest {
	private PaymentRuleProcessor processor;

	@Before
	public void setUp() throws Exception {
		processor = new PaymentRuleProcessor();
	}

	@Test
	public void shouldProcessRules() {
		Order order = new Order();
		List<Rule> ruleList = new ArrayList<>();
		
		Action<Object> action = new Action<Object>() {
			@Override
			public void execute(Object t) {
			}
		};

		Condition<Object> condition = new Condition<Object>() {
			@Override
			public boolean isValid(Object t) {
				return true;
			}
		};
		
		Rule rule = new RuleImpl.Builder().addAction(action).addCondition(condition).ofNamespace(RuleNamespace.PAYMENT).build();
		
		ruleList.add(rule);
		
		processor.process(ruleList, order);
	}
}
