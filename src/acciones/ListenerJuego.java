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
		logica.setPiezaNext(logica.generarPieza());
		logica.ponerPiezaNextEnTablero();
		Utiles.actualizar(panelJugadores);
		Utiles.actualizar(panelJuego);
		worker.execute();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char key = 'v';
		if(!logica.isFin()) {
			key = e.getKeyChar();
		}
		switch (key) {
		case 'a':
			logica.jugar(-1, 0);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
			break;
		case 'd':
			logica.jugar(1, 0);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
			break;
		case 's':
			logica.jugar(0, 1);
			ReproductorEFX.reproducirAudio("audios/moverPieza.mp3");
			pintarTablero();
			break;
		case 'w':
			logica.borrarPiezaActiva();
			logica.cambiarFormaPieza();
			logica.actualizarColoresTablero();
			ReproductorEFX.reproducirAudio("audios/cambioDePieza.mp3");
			pintarTablero();
			break;
		case ' ':
			logica.borrarPiezaActiva();
			logica.cambiarFormaPieza();
			logica.actualizarColoresTablero();
			ReproductorEFX.reproducirAudio("audios/cambioDePieza.mp3");
			pintarTablero();
			break;
		default:
			break;
		}
		
		Utiles.actualizar(panelJuego);
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
