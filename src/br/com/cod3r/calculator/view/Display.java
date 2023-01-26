package br.com.cod3r.calculator.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.cod3r.calculator.model.Memory;
import br.com.cod3r.calculator.model.ObserverMemory;

public class Display extends JPanel implements ObserverMemory {

	private static final long serialVersionUID = 628545618882341176L;
	
	private final JLabel label;
	
	public Display() {
		Memory.getInstance().addObserver(this);
		
		setBackground(new Color(46, 49, 50));
		label = new JLabel(Memory.getInstance().getCurrentText());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("monospaced", Font.BOLD, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 15));
		
		add(label);
	}

	@Override
	public void changedValue(String newValue) {
		label.setText(newValue);
		
	}

}
