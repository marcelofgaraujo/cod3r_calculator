package br.com.cod3r.calculator.model;

public class Memory {

	private static final Memory instance = new Memory();
	
	private Memory() {
		
	}

	public static Memory getInstance() {
		return instance;
	}
	
}
