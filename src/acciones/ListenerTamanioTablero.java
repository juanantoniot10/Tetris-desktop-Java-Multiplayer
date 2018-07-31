package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import control.Logica;

public class ListenerTamanioTablero implements ActionListener{
	
	private Logica logica;
	
	
	public ListenerTamanioTablero(Logica logica) {
		super();
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = ((JButton)e.getSource());
		this.logica.modificarTablero(obtenerFilas(boton), obtenerColumnas(boton));
	}
	
	private int obtenerColumnas(JButton boton) {
		int posicionInicio = boton.getText().indexOf('x')+1;
		return Integer.valueOf(String.valueOf(boton.getText()).substring(posicionInicio));
	}

	private int obtenerFilas(JButton boton) {
		int posicionInicio = boton.getText().indexOf(' ')+1;
		int posicionFin = boton.getText().indexOf('x');
		return Integer.valueOf(String.valueOf(boton.getText().substring(posicionInicio,posicionFin)));
	}

}
