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
			logica.jugar(-1, 0,0);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
			break;
		case 68:
			logica.jugar(1, 0,0);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
			break;
		case 83:
			logica.jugar(0, 1,0);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
			break;
		case 87:
			logica.borrarPiezaActiva(0);
			logica.cambiarFormaPieza(0);
			logica.actualizarColoresTablero(0);
			ReproductorEFX.reproducirAudio("audios/cambioDePieza.mp3");
			pintarTablero();
			break;
		case 37:
			logica.jugar(-1, 0,1);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
			break;
		case 39:
			logica.jugar(1, 0,1);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
			break;
		case 40:
			logica.jugar(0, 1,1);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
			break;
		case 38:
			logica.borrarPiezaActiva(1);
			logica.cambiarFormaPieza(1);
			logica.actualizarColoresTablero(1);
			ReproductorEFX.reproducirAudio("audios/cambioDePieza.mp3");
			pintarTablero();
			break;
		default:
			break;
		}
		
		Utiles.actualizar(panelJuego);
	}

	@Override
	public void keyReleased(KeyEvent e) {
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
