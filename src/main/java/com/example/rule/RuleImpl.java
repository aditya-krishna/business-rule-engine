package com.example.rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RuleImpl implements Rule {
	private List<Condition> conditions;

	private List<Action> actions;

	private RuleNamespace namespace;

	private RuleImpl() {

	}

	private RuleImpl(Builder builder) {
		this.actions = builder.actions;
		this.conditions = builder.conditions;
		this.namespace = builder.namespace;
	}

	@Override
	public List<Condition> getConditions() {
		return Collections.unmodifiableList(conditions);
	}

	@Override
	public List<Action> getActions() {
		return Collections.unmodifiableList(actions);
	}

	public RuleNamespace getNamespace() {
		return namespace;
	}

	public static class Builder {
		private List<Condition> conditions = new ArrayList<>();

		private List<Action> actions = new ArrayList<>();

		private RuleNamespace namespace;

		public Builder addCondition(Condition<?> condition) {
			this.conditions.add(condition);
			return this;
		}

		public Builder addAction(Action<?> action) {
			this.actions.add(action);
			return this;
		}

		public Builder ofNamespace(RuleNamespace namespace) {
			this.namespace = namespace;
			return this;
		}

		public Rule build() {
			return new RuleImpl(this);
		}
	}
}