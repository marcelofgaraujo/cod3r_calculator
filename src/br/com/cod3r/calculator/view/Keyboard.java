package br.com.cod3r.calculator.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class Keyboard extends JPanel {

	private static final long serialVersionUID = -8061589783356451060L;
	
	private final Color DARK_GRAY = new Color(68, 68, 68);
	private final Color LIGHT_GRAY = new Color(99, 99, 99);
	private final Color ORANGE = new Color(242, 163, 60);
	
	public Keyboard() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		
		setLayout(layout);
		
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		
		int keyNumber = 1;
		
		for(int r = 3; r > 0; r--) {
			for(int c = 0; c <= 2; c++) {
				addButton(keyNumber + "", LIGHT_GRAY, constraints, c, r);
				keyNumber++;
			}
		}
		
		constraints.gridwidth = 3;
		addButton("AC", DARK_GRAY, constraints, 0, 0);
		constraints.gridwidth = 1;
		addButton("/", DARK_GRAY, constraints, 3, 0);
		addButton("*", ORANGE, constraints, 3, 1);
		addButton("-", ORANGE, constraints, 3, 2);
		addButton("+", ORANGE, constraints, 3, 3);
		constraints.gridwidth = 2;
		addButton("0", LIGHT_GRAY, constraints, 0, 4);
		constraints.gridwidth = 1;
		addButton(",", LIGHT_GRAY, constraints, 2, 4);
		addButton("=", ORANGE, constraints, 3, 4);
		
	}
	
	private void addButton(String text, Color color, GridBagConstraints c, int x, int y) {
		c.gridx = x;
		c.gridy = y;
		
		Button button = new Button(text, color);
		add(button, c);
	}

}
