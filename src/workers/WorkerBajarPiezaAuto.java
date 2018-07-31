package workers;

import java.awt.Color;
import java.awt.Component;
import java.util.TreeMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import control.Logica;
import control.Puente;
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
		((PanelJugador)panelJugadores.getComponent(0)).getBtnMusicOnoff().addActionListener(reproductor);
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
					pintarPiezaNext(logica.getPiezaNext(),0);
					pintarLineas();
					pintarPuntos();
					pintarNivel();
					pintarNombreJugador(0);
					logica.jugar(0, 1);
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

	private void animacionFinalizar() {
		for (int i = 0; i < logica.getFilas(); i++) {
			for (int j = 0; j < logica.getColumnas(); j++) {
				cuadradosTablero[i][j].setBackground(Color.GRAY);
				Utiles.actualizar(panelJuego);	
				try {
					Thread.sleep((11000/(logica.getTablero().length*logica.getTablero()[0].length))/2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		padrePanelJuego.removeAll();
		PanelJugador panelJugadorParaGuardar = ((PanelJugador)panelJugadores.getComponent(0));
		logica.grabarJugador(panelJugadorParaGuardar.getNombre().getText(),Integer.valueOf(panelJugadorParaGuardar.getPuntos().getText()).intValue());
		padrePanelJuego.add(panelPuntuaciones);
		ActualizarTablaPuntuaciones();
	}

	private void pintarNombreJugador(int numeroJugador) {
		((PanelJugador)this.panelJugadores.getComponent(0)).getNombre().setText(String.valueOf(logica.getJugadores().get(0).getNombre()));
	}

	private void pintarNivel() {
		((PanelJugador)this.panelJugadores.getComponent(0)).getNivel().setText(String.valueOf(logica.getNivel()));
	}
	
	private void pintarPuntos() {
		((PanelJugador)this.panelJugadores.getComponent(0)).getPuntos().setText(String.valueOf(logica.getJugadores().get(0).getPuntuacion()));
	}

	private void pintarLineas() {
		((PanelJugador)this.panelJugadores.getComponent(0)).getLineas().setText(String.valueOf(logica.getLineas()));
	}

	private void pintarTablero() {
		for (int i = 0; i < logica.getFilas(); i++) {
			for (int j = 0; j < logica.getColumnas(); j++) {
				cuadradosTablero[i][j].setBackground(logica.getTablero()[i+3][j].getColor());
			}
		}	
		Utiles.actualizar(panelJuego);
	}
	private void pintarPiezaNext(Pieza nextPieza,int numeroJugador) {
		borrarPiezaNext(0);
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
