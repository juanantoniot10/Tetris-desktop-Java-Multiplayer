package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import control.Logica;
import utiles.Utiles;
import vista.PanelElegirNumeroJugadores;
import vista.PanelJugador;

public class ListenerNumeroJugadores implements ActionListener{

	private JPanel panelJugadores;
	private Logica logica;
	private PanelElegirNumeroJugadores panelElegirNumeroJugadores;
	private  boolean Jugador2 = false;
	private  boolean Jugador3 = false;
	private  boolean Jugador4 = false;
	private PanelJugador panelJugadorDos;
	private PanelJugador panelJugadorTres;
	private PanelJugador panelJugadorCuatro;

	public ListenerNumeroJugadores(JPanel panelJugadores, Logica logica, PanelElegirNumeroJugadores panelElegirNumeroJugadores) {
		this.panelJugadores = panelJugadores;
		this.logica = logica;
		this.panelElegirNumeroJugadores = panelElegirNumeroJugadores;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int key = Integer.valueOf(((JButton)e.getSource()).getText()).intValue();
		switch (key) {
		case 2:
			panelElegirNumeroJugadores.getNombreJugadorDos().setEnabled(!panelElegirNumeroJugadores.getNombreJugadorDos().isEnabled());
			if(!Jugador2) {
				panelJugadorDos = new PanelJugador(((JTextField)panelElegirNumeroJugadores.getComponent(3)).getText());
				panelJugadorDos.setName("1");
				panelJugadores.add(panelJugadorDos);
				Jugador2 = true;
			}
			else {
				panelJugadores.remove(panelJugadorDos);
				Jugador2 = false;
			}
			break;
		case 3:
			panelElegirNumeroJugadores.getNombreJugadorTres().setEnabled(!panelElegirNumeroJugadores.getNombreJugadorTres().isEnabled());
			if(!Jugador3) {
				panelJugadorTres = new PanelJugador(((JTextField)panelElegirNumeroJugadores.getComponent(5)).getText());
				panelJugadorTres.setName("2");
				panelJugadores.add(panelJugadorTres);
				Jugador3 = true;
			}
			else {
				panelJugadores.remove(panelJugadorTres);
				Jugador3 = false;
			}	
			break;
			case 4:
			panelElegirNumeroJugadores.getNombreJugadorCuatro().setEnabled(!panelElegirNumeroJugadores.getNombreJugadorCuatro().isEnabled());
			if(!Jugador4) {
				panelJugadorCuatro = new PanelJugador(((JTextField)panelElegirNumeroJugadores.getComponent(7)).getText());
				panelJugadorCuatro.setName("3");
				panelJugadores.add(panelJugadorCuatro);
				Jugador4 = true;
			}
			else {
				panelJugadores.remove(panelJugadorCuatro);	
				Jugador4 = false;
			}
			break;
		}
		Utiles.actualizar(panelJugadores.getParent());
	}

}
