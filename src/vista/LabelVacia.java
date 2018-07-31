package vista;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class LabelVacia extends JLabel{
	
	public LabelVacia() {
		super();
		this.setBorder(new LineBorder(Color.GRAY));
		this.setOpaque(true);
		this.setBackground(Color.BLACK);
	}
	
}
