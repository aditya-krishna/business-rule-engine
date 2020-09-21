package com.example.repository;

import java.util.List;

import com.example.rule.Rule;
import com.example.rule.RuleNamespace;

public interface RuleRepository {
	public List<Rule> findByNamespace(RuleNamespace namespace);
}
