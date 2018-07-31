package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import control.Logica;
import modelo.Jugador;
import utiles.Utiles;
import vista.PanelOpciones;
import vista.PanelElegirColorFondo;
import vista.PanelElegirNivel;
import vista.PanelJuego;
import vista.PanelTamanhoTablero;

public class ListenerOpciones implements ActionListener{

	private PanelOpciones panelOpciones;
	private JPanel panelJugadores;
	private Logica logica;
	private PanelJuego panelJuego;
	private JPanel panelParaJuego;
	
	public ListenerOpciones(PanelOpciones panelOpciones, JPanel panelJugadores ,JPanel panelParaJuego) {
		super();
		this.panelOpciones = panelOpciones;
		this.panelJugadores = panelJugadores;
		this.panelParaJuego = panelParaJuego;
		this.logica = new Logica(new Jugador(panelOpciones.getNombreJugador().getText()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botonPulsado = ((JButton)e.getSource());
		switch (String.valueOf(botonPulsado.getText())) {
		case "Nivel inicial":
			PanelElegirNivel panelElegirNivel = new PanelElegirNivel();
			addPanel(panelElegirNivel);
			addListeners(panelElegirNivel,new ListenerNivel(panelJugadores,logica));
			break;
		case "Tamaño tablero":
			PanelTamanhoTablero panelTamanhoTablero = new PanelTamanhoTablero();
			addPanel(panelTamanhoTablero);
			addListeners(panelTamanhoTablero,new ListenerTamanioTablero(logica));
			break;
		case "Color de fondo":
			PanelElegirColorFondo panelColorFondo = new PanelElegirColorFondo();
			addPanel(panelColorFondo);
			ponerListenersPanelColor(panelColorFondo,new ListenerColorFondo(panelJugadores.getParent().getParent()));
			break;
		case "INICIAR JUEGO":
			logica.getJugadores().get(0).setNombre(String.valueOf(panelOpciones.getNombreJugador().getText()));
			this.panelOpciones.removeAll();
			this.panelJuego = new PanelJuego(this.logica.getFilas(), this.logica.getColumnas());
			panelParaJuego.add(panelJuego);
			panelParaJuego.remove(panelOpciones);
			panelJuego.addKeyListener(new ListenerJuego(panelJuego, logica, panelJugadores));
			panelJuego.setFocusable(true);
			panelJuego.requestFocus();
			break;
		}
	}


	private void addListeners(JPanel panel, ActionListener listener) {
		for (int i = 0; i < panel.getComponentCount(); i++) {
			((JButton)panel.getComponent(i)).addActionListener(listener);
		}
		Utiles.actualizar(panelOpciones.getPanelValorOpcion());
	}
	
	private void addPanel(JPanel panel) {
		this.panelOpciones.getPanelValorOpcion().removeAll();
		this.panelOpciones.getPanelValorOpcion().add(panel);
	}
	
	private void ponerListenersPanelColor(JPanel panelElegirColorFondo,ListenerColorFondo listenerColorFondo) {
		for (int i = 0; i < panelElegirColorFondo.getComponentCount(); i++) {
			for (int j = 0; j < ((JPanel)panelElegirColorFondo.getComponent(i)).getComponentCount(); j++) {
				((JButton)((JPanel)panelElegirColorFondo.getComponent(i)).getComponent(j)).addActionListener(listenerColorFondo);
			}
		}
		Utiles.actualizar(panelOpciones.getPanelValorOpcion());
	}
}
