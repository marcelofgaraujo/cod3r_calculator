package br.com.cod3r.calculator.view;

import javax.swing.JFrame;

public class Calculator extends JFrame {

	private static final long serialVersionUID = 7625537721426545103L;
	
	public Calculator() {
		
		setSize(232, 322);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	};
	
	public static void main(String[] args) {
		new Calculator();
	}

}
