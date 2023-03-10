package br.com.cod3r.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

	private static final Memory instance = new Memory();
	private final List<ObserverMemory> observers = new ArrayList<>();
	
	private TypedCommand lastOperation = null;
	private boolean replace = false;
	private String bufferText = "0";
	private String currentText = "0";

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
			currentText = "0";
			bufferText = "0";
			replace = false;
			lastOperation = null;
		} else if(typedCommand == TypedCommand.SIGNAL) {
			if(currentText == "0") return;
			currentText = currentText.contains("-") ? currentText.substring(1) : "-" + currentText;
		} else if(typedCommand == TypedCommand.NUMBER) {
			currentText = currentText.startsWith("0") && !currentText.contains(",") ? currentText.substring(1) : currentText;
			currentText = replace ? value : currentText + value;
			replace = false;
		} else if(typedCommand == TypedCommand.COMMA) {
			currentText = replace ? value : currentText + value;
			replace = false;
		} else {
			replace = true;
			currentText = getOperationResult();
			bufferText = currentText;
			lastOperation = typedCommand;
		}

		observers.forEach(obs -> obs.changedValue(getCurrentText()));
	}

	private String getOperationResult() {
		if(lastOperation == null || lastOperation == TypedCommand.EQUAL) {
			return currentText;
		}
		
		double bufferNumber = Double.parseDouble(bufferText.replace(",", "."));
		double currentNumber = Double.parseDouble(currentText.replace(",", "."));
		double result = 0;
		
		if(lastOperation == TypedCommand.SUM) {
			result = bufferNumber + currentNumber;
		} else if(lastOperation == TypedCommand.SUB) {
			result = bufferNumber - currentNumber;
		} else if(lastOperation == TypedCommand.MULT) {
			result = bufferNumber * currentNumber;
		} else if(lastOperation == TypedCommand.DIV) {
			result = bufferNumber / currentNumber;
		}
		
		String stringResult = Double.toString(result).replace(".", ",");
		boolean integer = stringResult.endsWith(",0");
		return integer ? stringResult.replace(",0", "") : stringResult;
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
			} else if ("??".equals(value)) {
				return TypedCommand.SIGNAL;
			} else if (",".equals(value) && !currentText.contains(",")) {
				return TypedCommand.COMMA;
			}
				
		}

		return null;
	}

}
