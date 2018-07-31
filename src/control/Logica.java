package control;

import java.awt.Color;
import java.util.ArrayList;
import facade.Datos;
import modelo.Casilla;
import modelo.Jugador;
import modeloPiezas.Cuadradito;
import modeloPiezas.EleInversa;
import modeloPiezas.Ele;
import modeloPiezas.Palito;
import modeloPiezas.Pieza;
import modeloPiezas.Te;
import modeloPiezas.Zeta;
import modeloPiezas.ZetaInversa;
import reproductor.ReproductorEFX;
import utiles.Utiles;

public class Logica {
	private Casilla tablero [][];
	private int filas;
	private int columnas;
	private int nivel;
	private int lineas =0;
	private Pieza piezaNext;
	private boolean fin = false;
	private Pieza piezaActiva;
	private boolean comprobandoLinea = false;
	private int numeroDeLinea = 0;
	private int lineasConsecutivas = 0;
	private boolean isTecla = false;
	private ArrayList <Jugador> jugadores;
	private Datos datos;
	
	
	public Logica(Jugador jugador1) {
		super();
		this.tablero = new Casilla [20+3][10];
		this.setNivel(1);
		this.filas = 20;
		this.columnas = 10;
		llenarTableroDeCasillas();
		this.jugadores = new ArrayList<>();
		this.jugadores.add(jugador1);
		this.datos = new Datos();
	}

	private void llenarTableroDeCasillas() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Color.BLACK, i, j);
			}
		}
	}



	public Pieza generarPieza() {
		int numeroAleatorio = Utiles.crearRandom(1, 7);
		Pieza piezaGenerada = null;
		switch (numeroAleatorio) {
		case 1:
			piezaGenerada = new Palito((tablero[0].length/2)-1);
			break;
		case 2:
			piezaGenerada = new Cuadradito((tablero[0].length/2)-1);
			break;
		case 3:
			piezaGenerada = new EleInversa((tablero[0].length/2)-1);
			break;
		case 4:
			piezaGenerada = new Ele((tablero[0].length/2)-1);
			break;
		case 5:
			piezaGenerada = new Zeta((tablero[0].length/2)-1);
			break;
		case 6:
			piezaGenerada = new ZetaInversa((tablero[0].length/2)-1);
			break;
		case 7:
			piezaGenerada = new Te((tablero[0].length/2)-1);
			break;
		}
		return piezaGenerada;
		
	}


	public void jugar(int lateral,int vertical) {
		if(!gestionarMovimiento(lateral,vertical)) {
			borrarPiezaActiva();
			piezaActiva.moverPieza(lateral,vertical);
			comprobarNivel();
			if(fin)finalizar();
		}
		actualizarColoresTablero();
	}


	private void finalizar() {
		guardarPuntuacion(jugadores.get(0));
//		cargarMaximasPuntuaciones();
	}

	private void guardarPuntuacion(Jugador jugador) {
		
	}

	private void comprobarNivel() {
		this.nivel = (lineas/30)+1;
		
	}

	private boolean gestionarMovimiento(int lateral,int vertical) {
		boolean movimientoFinalizado = false;
		movimientoFinalizado = comprobarAbajo(vertical);
		movimientoFinalizado = comprobarLateral(lateral);
		return movimientoFinalizado;
	}


	private boolean comprobarLateral(int lateral) {
		boolean movimientoFinalizado = false;
		for (int i = 0; i < piezaActiva.getCasillas().length; i++) {
			if((piezaActiva.getCasillas()[i].getPosicionY()+lateral < 0 ||
					piezaActiva.getCasillas()[i].getPosicionY()+lateral>=tablero[0].length) ||(
					tablero[piezaActiva.getCasillas()[i].getPosicionX()][piezaActiva.getCasillas()[i].getPosicionY()+lateral].getColor()!=Color.BLACK && 
					!isPropia(tablero[piezaActiva.getCasillas()[i].getPosicionX()][piezaActiva.getCasillas()[i].getPosicionY()+lateral]))) {
				piezaActiva.moverPieza(0,0);
				movimientoFinalizado = true;
			}
		}
		return movimientoFinalizado;
	}

	private boolean isPropia(Casilla casilla) {
		for (int i = 0; i < piezaActiva.getCasillas().length; i++) {
			if(piezaActiva.getCasillas()[i].equals(casilla)) {
				return true;
			}
		}
		return false;
	}

	private boolean comprobarAbajo(int vertical) {
		boolean movimientoFinalizado = false;
			for (int i = 0; i < piezaActiva.getCasillas().length&&!movimientoFinalizado; i++) {
				if(piezaActiva.getCasillas()[i].getPosicionX()+vertical >= tablero.length ||(
						tablero[piezaActiva.getCasillas()[i].getPosicionX()+vertical][piezaActiva.getCasillas()[i].getPosicionY()].getColor()!=Color.BLACK &&
						!isPropia(tablero[piezaActiva.getCasillas()[i].getPosicionX()+vertical][piezaActiva.getCasillas()[i].getPosicionY()]))) {
					piezaActiva.moverPieza(0,0);
					if(!comprobandoLinea) {
						comprobandoLinea = true;
						ReproductorEFX.reproducirAudio("audios/encajarPieza.mp3");
						comprobarLineas();
						ponerPiezaNextEnTablero();
						if(comprobarAbajo(1)) {
							fin = true;
							
						}
					}	
					movimientoFinalizado = true;
					jugadores.get(0).setPuntuacion(jugadores.get(0).getPuntuacion()+20*nivel);
				}
			}
			actualizarColoresTablero();
			comprobandoLinea = false;
		return movimientoFinalizado;
	}

	
	private void comprobarLineas() {
		for (int i = 0; i < tablero.length; i++) {
			boolean linea = true;
			linea = isLinea(i, linea);
			if(linea) {
				ReproductorEFX.reproducirAudio("audios/sonidoLinea.mp3");
				lineas++;
				lineasConsecutivas ++;
				this.numeroDeLinea = i;
				jugadores.get(0).setPuntuacion(jugadores.get(0).getPuntuacion()+100+(2*lineasConsecutivas));
				bajarLinea();
			}
		}
		lineasConsecutivas = 0;
	}

	private void bajarLinea() {
		for ( ; numeroDeLinea  > -1; numeroDeLinea--) {
			for (int k = 0; k < tablero[numeroDeLinea].length; k++) {
				if(numeroDeLinea==0) {
					tablero[0][k]=new Casilla(Color.BLACK, 0, k);
				}
				else {
					tablero[numeroDeLinea][k]=new Casilla(tablero[numeroDeLinea-1][k].getColor(),numeroDeLinea, k);
					
				}
			}
		}
	}

	private boolean isLinea(int i, boolean linea) {
		for (int j = 0; j < tablero[i].length; j++) {
			if(tablero[i][j].getColor()==Color.BLACK) {
				linea=false;
			}
		}
		return linea;
	}

	public void borrarPiezaActiva() {
		for (int i = 0; i < piezaActiva.getCasillas().length; i++) {
			tablero[piezaActiva.getCasillas()[i].getPosicionX()][piezaActiva.getCasillas()[i].getPosicionY()].setColor(Color.BLACK);
		}
	}

	public void actualizarColoresTablero() {
		for (int i = 0; i < piezaActiva.getCasillas().length; i++) {
			tablero[piezaActiva.getCasillas()[i].getPosicionX()][piezaActiva.getCasillas()[i].getPosicionY()].setColor(piezaActiva.getColor());
		}
	}

	public void ponerPiezaNextEnTablero() {
		for (int i = 0; i < piezaNext.getCasillas().length; i++) {
			getTablero()[piezaNext.getCasillas()[i].getPosicionX()][piezaNext.getCasillas()[i].getPosicionY()].setColor(piezaNext.getColor());
		}
		piezaActiva = piezaNext;
		piezaNext = generarPieza();
		
	}
	
	public void modificarTablero(int filas,int columnas) {
		this.tablero = new Casilla [filas+3][columnas];
		this.filas = filas;
		this.columnas = columnas;
		llenarTableroDeCasillas();
	}
	
	public void cambiarFormaPieza() {
		piezaActiva.cambiarFormaPieza();
		recolocarPieza();
		if(comprobarColisionCambiarPieza(0,0)) {
			piezaActiva.cambiarFormaPieza();
			piezaActiva.cambiarFormaPieza();
			piezaActiva.cambiarFormaPieza();
		}
		
	}

	private boolean comprobarColisionCambiarPieza(int lateral,int vertical) {
		boolean retorno = false;
		for (int i = 0; i < piezaActiva.getCasillas().length; i++) {
			if((piezaActiva.getCasillas()[i].getPosicionY()+lateral>=tablero[0].length||piezaActiva.getCasillas()[i].getPosicionY()+lateral<0) ||
					(tablero[piezaActiva.getCasillas()[i].getPosicionX()+vertical][piezaActiva.getCasillas()[i].getPosicionY()+lateral].getColor()!=Color.BLACK &&
						!isPropia(tablero[piezaActiva.getCasillas()[i].getPosicionX()+vertical][piezaActiva.getCasillas()[i].getPosicionY()+lateral]))) {
				retorno=true;
			}
		}	
		
		return retorno;
	}

	private void recolocarPieza() {
		for (int i = 0; i < piezaActiva.getCasillas().length; i++) {
			comprobarIzquierdaCambioPieza(i);
			comprobarDerechaCambioPieza(i);
			comprobarAbajoCambioPieza(i);
		}
	}

	private void comprobarAbajoCambioPieza(int i) {
		if(piezaActiva.getCasillas()[i].getPosicionX()>=tablero.length) {
			int vertical = (tablero.length-1) - piezaActiva.getCasillas()[i].getPosicionX();
			if(!comprobarColisionCambiarPieza(0,vertical)) {
				piezaActiva.moverPieza(0, vertical);
			}
		}
	}

	private void comprobarDerechaCambioPieza(int i) {
		if(piezaActiva.getCasillas()[i].getPosicionY()>=tablero[0].length) {
			int lateral = (tablero[0].length-1) - piezaActiva.getCasillas()[i].getPosicionY();
			if(!comprobarColisionCambiarPieza(lateral,0)) {
				piezaActiva.moverPieza(lateral, 0);
			}
		}
	}

	private void comprobarIzquierdaCambioPieza(int i) {
		if(piezaActiva.getCasillas()[i].getPosicionY()<0) {
			int lateral = 0 - piezaActiva.getCasillas()[i].getPosicionY();
			if(!comprobarColisionCambiarPieza(lateral,0)) {
				piezaActiva.moverPieza(lateral, 0);
			}
		}
	}

	public Pieza getPiezaActiva() {
		return piezaActiva;
	}

	public void setPiezaActiva(Pieza piezaActiva) {
		this.piezaActiva = piezaActiva;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public void setTablero(Casilla[][] tablero) {
		this.tablero = tablero;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public Pieza getPiezaNext() {
		return piezaNext;
	}
	
	public void setPiezaNext(Pieza piezaNext) {
		this.piezaNext = piezaNext;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public Casilla[][] getTablero() {
		return tablero;
	}
	
	public int getFilas() {
		return filas;
	}
	
	public int getColumnas() {
		return columnas;
	}

	public int getLineas() {
		return lineas;
	}

	public void setLineas(int lineas) {
		this.lineas = lineas;
	}

	public boolean isComprobandoLinea() {
		return comprobandoLinea;
	}

	public void setComprobandoLinea(boolean comprobandoLinea) {
		this.comprobandoLinea = comprobandoLinea;
	}

	public int getNumeroDeLinea() {
		return numeroDeLinea;
	}

	public void setNumeroDeLinea(int numeroDeLinea) {
		this.numeroDeLinea = numeroDeLinea;
	}

	public boolean isTecla() {
		return isTecla;
	}

	public void setTecla(boolean isTecla) {
		this.isTecla = isTecla;
	}
	public int getLineasConsecutivas() {
		return lineasConsecutivas;
	}

	public void setLineasConsecutivas(int lineasConsecutivas) {
		this.lineasConsecutivas = lineasConsecutivas;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	
	
	public int getNumeroDeJugadoresGuardados() {
		return datos.obtenerTotalJugadores();
	}

	public Jugador obtenerJugador(int i) {
		return datos.obtenerJugador(i);
	}
	
	public boolean grabarJugador(String nombreJugador,int puntos) {
		Jugador jugadorParaGuardar = new Jugador(nombreJugador); 
		jugadorParaGuardar.setIdJugador(generarIdJugador());
		jugadorParaGuardar.setPuntuacion(puntos);
		jugadorParaGuardar.setLineas(lineas);
		jugadorParaGuardar.setNivel(nivel);
		return datos.grabar(jugadorParaGuardar);
	}

	private int generarIdJugador() {
		return datos.obtenerTotalJugadores();
		
	}
	
}
