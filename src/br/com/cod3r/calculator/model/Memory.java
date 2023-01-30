package br.com.cod3r.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

	private static final Memory instance = new Memory();
	private final List<ObserverMemory> observers = new ArrayList<>();
	
	private TypedCommand lastOperation = null;
	private boolean replace = false;
	private String bufferText = "";
	private String currentText = "";

	private Memory() {
	}

	public static Memory getInstance() {
		return instance;
	}

	public String getCurrentText() {
		return currentText.isEmpty() ? "0" : currentText;
	}

	public void addObserver(ObserverMemory obs) {
		observers.add(obs);
	}

	public void processCommand(String value) {

		TypedCommand typedCommand = detectTypedCommand(value);

		if(typedCommand == null) {
			return;
		} else if(typedCommand == TypedCommand.RESET) {
			currentText = "";
			bufferText = "";
			replace = false;
			lastOperation = null;
		} else if(typedCommand == TypedCommand.NUMBER || typedCommand == TypedCommand.COMMA) {
			currentText = replace ? value : currentText + value;
			replace = false;
		}

		observers.forEach(obs -> obs.changedValue(getCurrentText()));
	}

	private TypedCommand detectTypedCommand(String value) {

		if (currentText.isEmpty() && value == "0") {
			return null;
		}

		try {
			Integer.parseInt(value);
			return TypedCommand.NUMBER;
		} catch (NumberFormatException e) {
			if ("AC".equals(value)) {
				return TypedCommand.RESET;
			} else if ("/".equals(value)) {
				return TypedCommand.DIV;
			} else if ("*".equals(value)) {
				return TypedCommand.MULT;
			} else if ("+".equals(value)) {
				return TypedCommand.SUM;
			} else if ("-".equals(value)) {
				return TypedCommand.SUB;
			} else if ("=".equals(value)) {
				return TypedCommand.EQUAL;
			} else if (",".equals(value) && !currentText.contains(",")) {
				return TypedCommand.COMMA;
			}
				
		}

		return null;
	}

}
