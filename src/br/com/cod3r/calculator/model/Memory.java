package br.com.cod3r.calculator.model;

public class Memory {

	private static final Memory instance = new Memory();
	
	String currentText = "";
	
	private Memory() {
		
	}

	public static Memory getInstance() {
		return instance;
	}

	public String getCurrentText() {
		return currentText.isEmpty() ? "0" : currentText;
	}
	
}
