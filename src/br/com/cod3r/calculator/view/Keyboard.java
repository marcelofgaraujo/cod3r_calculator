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
		
		int keyNumber = 1;
		
		for(int r = 3; r > 0; r--) {
			for(int c = 0; c <= 2; c++) {
				addButton(keyNumber + "", LIGHT_GRAY, constraints, c, r);
				keyNumber++;
			}
		}
		
	}
	
	private void addButton(String text, Color color, GridBagConstraints c, int x, int y) {
		c.gridx = x;
		c.gridy = y;
		
		Button button = new Button(text, color);
		add(button, c);
	}

}
