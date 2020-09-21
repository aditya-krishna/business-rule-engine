package com.example.rule;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entities.Order;

@Component
public class PaymentRuleProcessor implements RuleProcessor<Order> {

	@Override
	public void process(List<Rule> rules, Order order) {
		rules.stream().filter(
				rule -> rule.getConditions().stream().allMatch(condition -> condition.isValid(order.getProduct())))
				.forEach(rule -> rule.getActions().forEach(action -> action.execute(order)));
	}
}