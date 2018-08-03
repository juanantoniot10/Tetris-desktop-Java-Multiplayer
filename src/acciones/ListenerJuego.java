package acciones;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import control.Logica;
import reproductor.ReproductorEFX;
import utiles.Utiles;
import vista.LabelVacia;
import vista.PanelJuego;
import workers.WorkerBajarPiezaAuto;

public class ListenerJuego implements KeyListener{

	private Logica logica;
	private PanelJuego panelJuego;
	private WorkerBajarPiezaAuto worker;
	private LabelVacia cuadradosTablero[][];
	private boolean J1Izq = false;
	private boolean J1Der = false;
	private boolean J1Abajo = false;
	private boolean J1Cambiar = false;
	private boolean J2Izq = false;
	private boolean J2Der = false;
	private boolean J2Abajo = false;
	private boolean J2Cambiar = false;
	
	public ListenerJuego(PanelJuego panelJuego, Logica logica, JPanel panelJugadores) {
		this.logica = logica;
		this.panelJuego = panelJuego;
		this.cuadradosTablero = new LabelVacia [logica.getFilas()][logica.getColumnas()];
		this.worker = new WorkerBajarPiezaAuto(logica, panelJuego,panelJugadores,cuadradosTablero);
		rellenarTableroVacio();
		generarPiezasNext();
		Utiles.actualizar(panelJugadores);
		Utiles.actualizar(panelJuego);
		worker.execute();
	}

	private void generarPiezasNext() {
		for (int i = 0; i < logica.getJugadores().size(); i++) {
			logica.getPiezasNext().add(logica.generarPieza(i));
			logica.getPiezasActiva().add(logica.getPiezasNext().get(i));
			logica.ponerPiezaNextEnTablero(i);
		}
	}

	private void pintarTablero() {
		for (int i = 0; i < logica.getFilas(); i++) {
			for (int j = 0; j < logica.getColumnas(); j++) {
				cuadradosTablero[i][j].setBackground(logica.getTablero()[i+3][j].getColor());
			}
		}	
		Utiles.actualizar(panelJuego);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = 0;
		if(!logica.isFin()) {
			key = e.getKeyCode();
		}
		switch (key) {
		case 65:
			J1Izq = true;
			break;
		case 68:
			J1Der = true;
			break;
		case 83:
			J1Abajo = true;
			break;
		case 87:
			J1Cambiar = true;
			break;
		case 37:
			J2Izq = true;
			break;
		case 39:
			J2Der = true;
			break;
		case 40:
			J2Abajo = true;
			break;
		case 38:
			J2Cambiar = true;
			break;
		default:
			break;
		}
		if(J1Izq) {
			logica.jugar(-1, 0,0);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
		}
		if(J1Der) {
			logica.jugar(1, 0,0);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
		}
		if(J1Abajo) {
			logica.jugar(0, 1,0);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
		}
		if(J1Cambiar) {
			logica.borrarPiezaActiva(0);
			logica.cambiarFormaPieza(0);
			logica.actualizarColoresTablero(0);
			ReproductorEFX.reproducirAudio("audios/cambioDePieza.mp3");
			pintarTablero();
		}
		
		if(J2Izq) {
			logica.jugar(-1, 0,1);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
		}
		if(J2Der) {
			logica.jugar(1, 0,1);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
		}
		if(J2Abajo) {
			logica.jugar(0, 1,1);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
		}
		if(J2Cambiar) {
			logica.borrarPiezaActiva(1);
			logica.cambiarFormaPieza(1);
			logica.actualizarColoresTablero(1);
			ReproductorEFX.reproducirAudio("audios/cambioDePieza.mp3");
			pintarTablero();
		}
		
		Utiles.actualizar(panelJuego);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = 0;
		if(!logica.isFin()) {
			key = e.getKeyCode();
		}
		switch (key) {
		case 65:
			J1Izq = false;
			break;
		case 68:
			J1Der = false;
			break;
		case 83:
			J1Abajo = false;
			break;
		case 87:
			J1Cambiar = false;
			break;
		case 37:
			J2Izq = false;
			break;
		case 39:
			J2Der = false;
			break;
		case 40:
			J2Abajo = false;
			break;
		case 38:
			J2Cambiar = false;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	private void rellenarTableroVacio() {
		for (int i = 0; i < logica.getFilas(); i++) {
			for (int j = 0; j < logica.getColumnas(); j++) {
				cuadradosTablero[i][j] = new LabelVacia();
				this.panelJuego.add(cuadradosTablero[i][j]);
			}
		}
	}
	
}
