package workers;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import control.Logica;
import modelo.Jugador;
import modeloPiezas.Cuadradito;
import modeloPiezas.EleInversa;
import modeloPiezas.Ele;
import modeloPiezas.Palito;
import modeloPiezas.Pieza;
import modeloPiezas.Te;
import modeloPiezas.Zeta;
import modeloPiezas.ZetaInversa;
import reproductor.ReproductorBSO;
import reproductor.ReproductorEFX;
import utiles.Utiles;
import vista.LabelVacia;
import vista.PanelGameOver;
import vista.PanelJuego;
import vista.PanelJugador;
import vista.PanelPuntuaciones;

public class WorkerBajarPiezaAuto extends SwingWorker<Object, Object>{

	private Logica logica;
	private PanelJuego panelJuego;
	private JPanel panelJugadores;
	private LabelVacia[][] cuadradosTablero;
	private ReproductorBSO reproductor;
	private PanelPuntuaciones panelPuntuaciones;
	
	public WorkerBajarPiezaAuto(Logica logica, PanelJuego panelJuego, JPanel panelJugadores, LabelVacia[][] cuadradosTablero) {
		super();
		this.logica = logica;
		this.panelJuego = panelJuego;
		this.panelJugadores = panelJugadores;
		this.cuadradosTablero = cuadradosTablero;
		this.reproductor = new ReproductorBSO();
		this.panelPuntuaciones = new PanelPuntuaciones();
		ponerListenerMusica();
	}

	private void ponerListenerMusica() {
		for (int i = 0; i < logica.getJugadores().size(); i++) {
			((PanelJugador)panelJugadores.getComponent(i)).getBtnMusicOnoff().addActionListener(reproductor);
		}
		((PanelJugador)panelJugadores.getComponent(0)).getBtnMusicOnoff().doClick();
	}

	@Override
	protected Object doInBackground() throws Exception {
		do {
			if(!logica.isTecla()) {
				try {
					int tiempoEspera = 1000-(logica.getNivel()*100);
					if(tiempoEspera <=50)tiempoEspera = 50;
					Thread.sleep(tiempoEspera);
					pintarPiezasNext();
					pintarLineas();
					pintarPuntos();
					pintarNivel();
					bajarPiezas();
					pintarTablero();
					if(reproductor.isCancionTerminada()) {
						((PanelJugador)panelJugadores.getComponent(0)).getBtnMusicOnoff().doClick();
						((PanelJugador)panelJugadores.getComponent(0)).getBtnMusicOnoff().doClick();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		} while (!logica.isFin());
		reproductor.getReproductor().close();
		ReproductorEFX.reproducirAudio("audios/gameOver.mp3");
		animacionFinalizar();
		return null;
	}

	private void bajarPiezas() {
		for (int i = 0; i < logica.getPiezasActiva().size(); i++) {
			logica.jugar(0, 1, i);
		}
	}

	private void animacionFinalizar() {
		for (int i = 0; i < logica.getFilas(); i++) {
			for (int j = 0; j < logica.getColumnas(); j++) {
				cuadradosTablero[i][j].setBackground(Color.GRAY);
				Utiles.actualizar(panelJuego);	
				try {
					Thread.sleep((11000/(logica.getTablero().length*logica.getTablero()[0].length))/2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}	
		JPanel padrePanelJuego = (JPanel) panelJuego.getParent();
		padrePanelJuego.removeAll();
		padrePanelJuego.add(new PanelGameOver(padrePanelJuego));
		Utiles.actualizar(padrePanelJuego);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		padrePanelJuego.removeAll();
		guardarPuntuaciones();
		padrePanelJuego.add(panelPuntuaciones);
		ActualizarTablaPuntuaciones();
	}

	private void guardarPuntuaciones() {
		for (int i = 0; i < logica.getJugadores().size(); i++) {
			PanelJugador panelJugadorParaGuardar = ((PanelJugador)panelJugadores.getComponent(i));
			logica.grabarJugador(panelJugadorParaGuardar.getNombre().getText(),Integer.valueOf(panelJugadorParaGuardar.getPuntos().getText()).intValue());
		}
	}

	private void pintarNivel() {
		for (int i = 0; i < logica.getJugadores().size(); i++) {
			((PanelJugador)this.panelJugadores.getComponent(0)).getNivel().setText(String.valueOf(logica.getNivel()));
		}
	}
	
	private void pintarPuntos() {
		for (int i = 0; i < logica.getJugadores().size(); i++) {
			((PanelJugador)this.panelJugadores.getComponent(i)).getPuntos().setText(String.valueOf(logica.getJugadores().get(i).getPuntuacion()));
		}
	}

	private void pintarLineas() {
		for (int i = 0; i < logica.getJugadores().size(); i++) {
			((PanelJugador)this.panelJugadores.getComponent(i)).getLineas().setText(String.valueOf(logica.getLineas()));
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
	
	private void pintarPiezasNext() {
		for (int i = 0; i < logica.getPiezasNext().size(); i++) {
			pintarPiezaNext(logica.getPiezasNext().get(i),i);
		}
	}
	
	private void pintarPiezaNext(Pieza nextPieza,int numeroJugador) {
		borrarPiezasNext(numeroJugador);
		switch (nextPieza.toString()) {
		case "palito":
			pintarPiezaNext((Palito)nextPieza,numeroJugador);
			break;
		case "cuadradito":
			pintarPiezaNext((Cuadradito)nextPieza,numeroJugador);
			break;
		case "ele":
			pintarPiezaNext((Ele)nextPieza,numeroJugador);
			break;
		case "eleInversa":
			pintarPiezaNext((EleInversa)nextPieza,numeroJugador);
			break;
		case "zeta":
			pintarPiezaNext((Zeta)nextPieza,numeroJugador);
			break;
		case "zetaInversa":
			pintarPiezaNext((ZetaInversa)nextPieza,numeroJugador);
			break;
		case "te":
			pintarPiezaNext((Te)nextPieza,numeroJugador);
			break;
		}
		Utiles.actualizar(panelJugadores);
	}

	private void pintarPiezaNext(Te nextPieza, int numeroJugador) {
		for (int i = 0; i < ((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponentCount(); i++) {
			if(i==1) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else if (i>3&&i<7) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(Color.BLACK);

			}
		}
	}
	
	private void pintarPiezaNext(ZetaInversa nextPieza, int numeroJugador) {
		for (int i = 0; i < ((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponentCount(); i++) {
			if(i==1||i==2) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else if (i==4||i==5) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(Color.BLACK);

			}
		}
	}
	
	private void pintarPiezaNext(Zeta nextPieza, int numeroJugador) {
		for (int i = 0; i < ((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponentCount(); i++) {
			if(i>=0&&i<2) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else if (i==5||i==6) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(Color.BLACK);

			}
		}
		Utiles.actualizar(panelJugadores);
	}

	private void pintarPiezaNext(Ele nextPieza, int numeroJugador) {
		for (int i = 0; i < ((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponentCount(); i++) {
			if(i==2) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else if (i>3&&i<7) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(Color.BLACK);

			}
		}
	}

	private void pintarPiezaNext(EleInversa nextPieza, int numeroJugador) {
		for (int i = 0; i < ((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponentCount(); i++) {
			if(i<1) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else if (i>3&&i<7) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(Color.BLACK);

			}
		}
	}

	private void pintarPiezaNext(Cuadradito nextPieza, int numeroJugador) {
		for (int i = 0; i < ((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponentCount(); i++) {
			if(i<2) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else if (i>3&&i<6) {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
			}
			else {
				((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(Color.BLACK);

			}
		}
	}
	
	private void pintarPiezaNext(Palito nextPieza, int numeroJugador) {
		for (int i = 0; i < nextPieza.getCasillas().length; i++) {
			((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(nextPieza.getColor());
		}
	}
	
	private void borrarPiezasNext(int numeroJugador) {
		borrarPiezaNext(numeroJugador);
	}

	private void borrarPiezaNext(int numeroJugador) {
		for (int i = 0; i < ((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponentCount(); i++) {
			((JLabel)((PanelJugador)panelJugadores.getComponent(numeroJugador)).getPanelNext().getComponent(i)).setBackground(Color.BLACK);
		}
	}
	private void ActualizarTablaPuntuaciones() {
		for (int i = 0; i < logica.getNumeroDeJugadoresGuardados(); i++) {
			Jugador jugadorAux = (Jugador) logica.obtenerJugador(i);
			String adicion[] = { jugadorAux.getNombre(),
					String.valueOf(jugadorAux.getPuntuacion()), String.valueOf(jugadorAux.getLineas()),
					String.valueOf(jugadorAux.getNivel()) };
			panelPuntuaciones.getModeloTabla().addRow(adicion);
		}
		Utiles.actualizar(panelPuntuaciones.getParent());
	}
}
