package com.example.rule;

import java.util.List;

public interface RuleProcessor<T> {
	public void process(List<Rule> rules, T t);
}
