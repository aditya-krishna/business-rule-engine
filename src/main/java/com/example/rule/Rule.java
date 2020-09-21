package com.example.rule;

import java.util.List;

public interface Rule {
	public List<Condition> getConditions();
	
	public List<Action> getActions();
	
	public RuleNamespace getNamespace();
}
