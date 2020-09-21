package com.example.rule;

public enum RuleNamespace {
	PAYMENT("PAYMENT");
	
	private String namespace;
	
	private RuleNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getNamespace() {
		return namespace;
	}
}
