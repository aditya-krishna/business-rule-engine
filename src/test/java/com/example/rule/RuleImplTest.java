package com.example.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class RuleImplTest {
	private Rule rule;

	private Action<Object> action = new Action<Object>() {
		@Override
		public void execute(Object t) {
		}
	};

	private Condition<Object> condition = new Condition<Object>() {
		@Override
		public boolean isValid(Object t) {
			return false;
		}
	};

	@Test
	public void shouldReturnCorrectValues() {
		rule = new RuleImpl.Builder().addAction(action).addCondition(condition).ofNamespace(RuleNamespace.PAYMENT)
				.build();

		assertEquals(action, rule.getActions().get(0));
		assertEquals(condition, rule.getConditions().get(0));
		assertEquals(RuleNamespace.PAYMENT, rule.getNamespace());
	}
}
