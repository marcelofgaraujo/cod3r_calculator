package br.com.cod3r.calculator.model;

@FunctionalInterface
public interface ObserverMemory {
	
	void changedValue(String newValue);
	
}
