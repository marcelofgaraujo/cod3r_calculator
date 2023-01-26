package br.com.cod3r.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

	private static final Memory instance = new Memory();
	private final List<ObserverMemory> observers = new ArrayList<>();
	
	String currentText = "";
	
	private Memory() {}

	public static Memory getInstance() {
		return instance;
	}

	public String getCurrentText() {
		return currentText.isEmpty() ? "0" : currentText;
	}
	
	private void addObserver(ObserverMemory obs) {
		observers.add(obs);
	}
	
}
