package acciones;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ListenerColorFondo implements ActionListener {

	private Container padrePrincipal;
	private Color color;
	
	
	public ListenerColorFondo(Container container) {
		super();
		this.padrePrincipal = container;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = ((JButton)e.getSource());
		this.color = boton.getBackground();
		colorearPaneles(padrePrincipal);
	}



	private void colorearPaneles(Container panel) {
		for (int i = 0; i < panel.getComponentCount(); i++) {
			if(panel.getComponent(i).getClass()==JPanel.class) {
				((JPanel)panel.getComponent(i)).setBackground(color);
				colorearPaneles((JPanel)panel.getComponent(i));
			}
		}
	}
	
}
