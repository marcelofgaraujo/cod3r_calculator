package br.com.cod3r.calculator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 7625537721426545103L;
	
	public Calculator() {
		
		arrangeLayout();
		
		setSize(232, 322);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	};
	
	private void arrangeLayout() {
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(233, 60));;
		add(display, BorderLayout.NORTH);
		
		Keyboard keyboard = new Keyboard();
		add(keyboard, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new Calculator();
	}

}
