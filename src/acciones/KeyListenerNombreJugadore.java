package acciones;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Logica;
import utiles.Utiles;
import vista.PanelElegirNumeroJugadores;
import vista.PanelJugador;

public class KeyListenerNombreJugadore implements KeyListener {
	
	private JPanel panelJugadores;
	private Logica logica;
	private PanelElegirNumeroJugadores panelElegirNumeroJugadores;

	public KeyListenerNombreJugadore(JPanel panelJugadores, Logica logica,
			PanelElegirNumeroJugadores panelElegirNumeroJugadores) {
		this.panelJugadores = panelJugadores;
		this.logica = logica;
		this.panelElegirNumeroJugadores = panelElegirNumeroJugadores;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < panelJugadores.getComponentCount(); i++) {
			int textFieldName = Integer.valueOf(((JTextField)e.getSource()).getName()).intValue();
			((PanelJugador)panelJugadores.getComponent(textFieldName)).getNombre().setText(((JTextField)e.getSource()).getText());
		}
		Utiles.actualizar(panelJugadores);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
