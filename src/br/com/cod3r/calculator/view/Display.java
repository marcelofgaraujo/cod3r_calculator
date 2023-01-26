package br.com.cod3r.calculator.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JPanel {

	private static final long serialVersionUID = 628545618882341176L;
	
	private final JLabel label;
	
	public Display() {
		setBackground(new Color(46, 49, 50));
		label = new JLabel("1134,68");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("monospaced", Font.BOLD, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 15));
		
		add(label);
	}

}
