package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Logica;
import modelo.Jugador;
import utiles.Utiles;
import vista.PanelOpciones;
import vista.PanelElegirColorFondo;
import vista.PanelElegirNivel;
import vista.PanelElegirNumeroJugadores;
import vista.PanelJuego;
import vista.PanelJugador;
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
		this.logica = new Logica();
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
		case "Jugadores":
			PanelElegirNumeroJugadores panelElegirNumeroJugadores = new PanelElegirNumeroJugadores();
			addPanel(panelElegirNumeroJugadores);
			addListenersNumeroJugadores(panelElegirNumeroJugadores,new ListenerNumeroJugadores(panelJugadores,logica,panelElegirNumeroJugadores),new KeyListenerNombreJugadore(panelJugadores,logica,panelElegirNumeroJugadores));
			break;	
		case "INICIAR JUEGO":
			addJugadores();
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

	private void addJugadores() {
		for (int i = 0; i < panelJugadores.getComponentCount(); i++) {
			logica.getJugadores().add(new Jugador(((PanelJugador)panelJugadores.getComponent(i)).getNombre().getText()));
			logica.getJugadores().get(i).setNombre(((PanelJugador)panelJugadores.getComponent(i)).getNombre().getText());
			logica.getJugadores().get(i).setNivel(Integer.valueOf(((PanelJugador)panelJugadores.getComponent(i)).getNivel().getText()).intValue());
			logica.getJugadores().get(i).setLineas(Integer.valueOf(((PanelJugador)panelJugadores.getComponent(i)).getLineas().getText()).intValue());
		}
	}

	private void addListenersNumeroJugadores(PanelElegirNumeroJugadores panel,
			ListenerNumeroJugadores listener, KeyListener keyListener) {
		for (int i = 0; i < panel.getComponentCount(); i++) {
			if(panel.getComponent(i).getClass()==JButton.class) {
				((JButton)panel.getComponent(i)).addActionListener(listener);
			}
			else {
				((JTextField)panel.getComponent(i)).addKeyListener(keyListener);
			}
		}
		Utiles.actualizar(panelOpciones.getPanelValorOpcion());
		
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
