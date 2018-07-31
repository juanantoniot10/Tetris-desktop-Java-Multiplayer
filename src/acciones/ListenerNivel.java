package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.Logica;
import vista.PanelJugador;

public class ListenerNivel implements ActionListener{
	
	private JPanel panelJugadores;
	private Logica logica;
	
	public ListenerNivel(JPanel panelJugadores, Logica logica) {
		super();
		this.panelJugadores = panelJugadores;
		this.logica = logica;
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		int nivel = Integer.valueOf(obtenerNumeroNivel(((JButton)e.getSource()))).intValue();
		this.logica.setNivel(nivel);
		((PanelJugador)this.panelJugadores.getComponent(0)).getNivel().setText(String.valueOf(nivel));
	}
	
	
	private String obtenerNumeroNivel(JButton boton) {
		int posicionEspacio=String.valueOf(boton.getText()).indexOf(' ');
		return String.valueOf(boton.getText()).substring(posicionEspacio+1);
	}
}
