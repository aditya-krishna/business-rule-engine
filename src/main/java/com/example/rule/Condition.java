package com.example.rule;

public interface Condition<T> {
	public boolean isValid(T t);
}
