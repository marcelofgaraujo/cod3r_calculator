package br.com.cod3r.calculator.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton {

	private static final long serialVersionUID = 919078203019634290L;
	
	public Button(String text, Color color) {
		setText(text);
		setBackground(color);
		setForeground(Color.WHITE);
		setOpaque(true);
		setFont(new Font("monospaced", Font.BOLD, 25));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}
