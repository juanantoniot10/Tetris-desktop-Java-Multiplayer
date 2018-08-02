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
	private ArrayList<Pieza> piezasNext = new ArrayList<>();
	private boolean fin = false;
	private ArrayList<Pieza> piezasActiva = new ArrayList<>();
	private boolean comprobandoLinea = false;
	private int numeroDeLinea = 0;
	private int lineasConsecutivas = 0;
	private boolean isTecla = false;
	private ArrayList <Jugador> jugadores = new ArrayList<>();
	private Datos datos;
	
	
	public Logica() {
		super();
		this.tablero = new Casilla [20+3][10];
		this.setNivel(1);
		this.filas = 20;
		this.columnas = 10;
		llenarTableroDeCasillas();
		this.jugadores = new ArrayList<>();
		this.datos = new Datos();
	}

	private void llenarTableroDeCasillas() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Color.BLACK, i, j);
			}
		}
	}



	public Pieza generarPieza(int numeroJugador) {
		int numeroAleatorio = Utiles.crearRandom(1, 7);
		Pieza piezaGenerada = null;
		int posicionY = (tablero[0].length/2)-1;
		if(jugadores.size()>1) {
			if(numeroJugador == 0)posicionY = 3;
			if(numeroJugador == 1)posicionY = (tablero[0].length)-4;
			if(numeroJugador == 2)posicionY = (tablero[0].length/2)-3;
			if(numeroJugador == 3)posicionY = (tablero[0].length/2)+3;
		}
		switch (numeroAleatorio) {
		case 1:
			piezaGenerada = new Palito(posicionY);
			break;
		case 2:
			piezaGenerada = new Cuadradito(posicionY);
			break;
		case 3:
			piezaGenerada = new EleInversa(posicionY);
			break;
		case 4:
			piezaGenerada = new Ele(posicionY);
			break;
		case 5:
			piezaGenerada = new Zeta(posicionY);
			break;
		case 6:
			piezaGenerada = new ZetaInversa(posicionY);
			break;
		case 7:
			piezaGenerada = new Te(posicionY);
			break;
		}
		return piezaGenerada;
		
	}


	public void jugar(int lateral,int vertical,int numeroPieza) {
		if(!gestionarMovimiento(lateral,vertical, numeroPieza)) {
			borrarPiezaActiva(numeroPieza);
			piezasActiva.get(numeroPieza).moverPieza(lateral,vertical);
			comprobarNivel();
		}
		actualizarColoresTablero(numeroPieza);
	}


	private void comprobarNivel() {
		this.nivel = (lineas/30)+1;
		
	}

	private boolean gestionarMovimiento(int lateral,int vertical,int numeroPieza) {
		boolean movimientoFinalizado = false;
		movimientoFinalizado = comprobarAbajo(vertical, numeroPieza);
		if(!movimientoFinalizado)movimientoFinalizado = comprobarLateral(lateral, numeroPieza);
		return movimientoFinalizado;
	}


	private boolean comprobarLateral(int lateral,int numeroPieza) {
		boolean movimientoFinalizado = false;
		for (int i = 0; i < piezasActiva.get(numeroPieza).getCasillas().length; i++) {
			if((piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()+lateral < 0 ||
					piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()+lateral>=tablero[0].length) ||(
					tablero[piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionX()][piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()+lateral].getColor()!=Color.BLACK && 
					!isPropia(tablero[piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionX()][piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()+lateral], numeroPieza))) {
				piezasActiva.get(numeroPieza).moverPieza(0,0);
				movimientoFinalizado = true;
			}
		}
		return movimientoFinalizado;
	}

	private boolean isPropia(Casilla casilla,int numeroPieza) {
		for (int i = 0; i < piezasActiva.size(); i++) {
			for (int j = 0; j < piezasActiva.get(i).getCasillas().length; j++) {
				if(piezasActiva.get(i).getCasillas()[j].equals(casilla)) {
					return true;
				}
			}
		}
			
		return false;
	}

	private boolean comprobarAbajo(int vertical,int numeroPieza) {
		boolean movimientoFinalizado = false;
			for (int i = 0; i < piezasActiva.get(numeroPieza).getCasillas().length&&!movimientoFinalizado; i++) {
				if(piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionX()+vertical >= tablero.length ||(
						tablero[piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionX()+vertical][piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()].getColor()!=Color.BLACK &&
						!isPropia(tablero[piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionX()+vertical][piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()], numeroPieza))) {
					piezasActiva.get(numeroPieza).moverPieza(0,0);
					if(!comprobandoLinea) {
						comprobandoLinea = true;
						ReproductorEFX.reproducirAudio("audios/encajarPieza.mp3");
						comprobarLineas(numeroPieza);
						ponerPiezaNextEnTablero(numeroPieza);
						if(comprobarAbajo(1, numeroPieza)) {
							fin = true;
						}
					}	
					movimientoFinalizado = true;
					jugadores.get(numeroPieza).setPuntuacion(jugadores.get(numeroPieza).getPuntuacion()+20*nivel);
				}
			}
			actualizarColoresTablero(numeroPieza);
			comprobandoLinea = false;
		return movimientoFinalizado;
	}

	
	private void comprobarLineas(int numeroPieza) {
		for (int i = 0; i < tablero.length; i++) {
			boolean linea = true;
			linea = isLinea(i, linea);
			if(linea) {
				ReproductorEFX.reproducirAudio("audios/sonidoLinea.mp3");
				lineas++;
				lineasConsecutivas ++;
				this.numeroDeLinea = i;
				puntuarLineas();
				bajarLinea(numeroPieza);
				linea=true;
			}
		}
		lineasConsecutivas = 0;
	}

	private void puntuarLineas() {
		for (int i = 0; i < jugadores.size(); i++) {
			jugadores.get(i).setPuntuacion(jugadores.get(i).getPuntuacion()+100+(2*lineasConsecutivas));
		}
		
	}

	private void bajarLinea(int numeroPieza) {
		borrarOtrasPiezas(numeroPieza);
		for ( ; numeroDeLinea  > -1; numeroDeLinea--) {
			for (int k = 0; k < tablero[numeroDeLinea].length; k++) {
				if(numeroDeLinea==0) {
					tablero[0][k]=new Casilla(Color.BLACK, 0, k);
				}
				else {
					tablero[numeroDeLinea][k].setColor(tablero[numeroDeLinea-1][k].getColor());
					
				}
			}
		}
		pintarOtrasPiezas(numeroPieza);
	}

	private void pintarOtrasPiezas(int numeroPieza) {
		for (int i = 0; i < piezasActiva.size(); i++) {
			if(i!=numeroPieza) {
				actualizarColoresTablero(i);
			}
		}
	}

	private void borrarOtrasPiezas(int numeroPieza) {
		for (int i = 0; i < piezasActiva.size(); i++) {
			if(i!=numeroPieza) {
				borrarPiezaActiva(i);
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

	public void borrarPiezaActiva(int numeroPieza) {
		for (int i = 0; i < piezasActiva.get(numeroPieza).getCasillas().length; i++) {
			tablero[piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionX()][piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()].setColor(Color.BLACK);
		}
	}

	public void actualizarColoresTablero(int numeroPieza) {
		for (int i = 0; i < piezasActiva.get(numeroPieza).getCasillas().length; i++) {
			tablero[piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionX()][piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()].setColor(piezasActiva.get(numeroPieza).getColor());
		}
	}

	public void ponerPiezaNextEnTablero(int numeroPieza) {
		for (int i = 0; i < piezasNext.get(numeroPieza).getCasillas().length; i++) {
			getTablero()[piezasNext.get(numeroPieza).getCasillas()[i].getPosicionX()][piezasNext.get(numeroPieza).getCasillas()[i].getPosicionY()].setColor(piezasNext.get(numeroPieza).getColor());
		}
		this.piezasActiva.set(numeroPieza,  piezasNext.get(numeroPieza));
		this.piezasNext.set(numeroPieza, generarPieza(numeroPieza));
		
	}
	
	public void modificarTablero(int filas,int columnas) {
		this.tablero = new Casilla [filas+3][columnas];
		this.filas = filas;
		this.columnas = columnas;
		llenarTableroDeCasillas();
	}
	
	public void cambiarFormaPieza(int numeroPieza) {
		piezasActiva.get(numeroPieza).cambiarFormaPieza();
		recolocarPieza(numeroPieza);
		if(comprobarColisionCambiarPieza(0,0, numeroPieza)) {
			piezasActiva.get(numeroPieza).cambiarFormaPieza();
			piezasActiva.get(numeroPieza).cambiarFormaPieza();
			piezasActiva.get(numeroPieza).cambiarFormaPieza();
		}
		
	}

	private boolean comprobarColisionCambiarPieza(int lateral,int vertical,int numeroPieza) {
		boolean retorno = false;
		for (int i = 0; i < piezasActiva.get(numeroPieza).getCasillas().length; i++) {
			if((piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()+lateral>=tablero[0].length||piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()+lateral<0) ||
					(tablero[piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionX()+vertical][piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()+lateral].getColor()!=Color.BLACK &&
						!isPropia(tablero[piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionX()+vertical][piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()+lateral], numeroPieza))) {
				retorno=true;
			}
		}	
		
		return retorno;
	}

	private void recolocarPieza(int numeroPieza) {
		for (int i = 0; i < piezasActiva.get(numeroPieza).getCasillas().length; i++) {
			comprobarIzquierdaCambioPieza(i, numeroPieza);
			comprobarDerechaCambioPieza(i, numeroPieza);
			comprobarAbajoCambioPieza(i, numeroPieza);
		}
	}

	private void comprobarAbajoCambioPieza(int i,int numeroPieza) {
		if(piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionX()>=tablero.length) {
			int vertical = (tablero.length-1) - piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionX();
			if(!comprobarColisionCambiarPieza(0,vertical, numeroPieza)) {
				piezasActiva.get(numeroPieza).moverPieza(0, vertical);
			}
		}
	}

	private void comprobarDerechaCambioPieza(int i,int numeroPieza) {
		if(piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()>=tablero[0].length) {
			int lateral = (tablero[0].length-1) - piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY();
			if(!comprobarColisionCambiarPieza(lateral,0, numeroPieza)) {
				piezasActiva.get(numeroPieza).moverPieza(lateral, 0);
			}
		}
	}

	private void comprobarIzquierdaCambioPieza(int i,int numeroPieza) {
		if(piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY()<0) {
			int lateral = 0 - piezasActiva.get(numeroPieza).getCasillas()[i].getPosicionY();
			if(!comprobarColisionCambiarPieza(lateral,0, numeroPieza)) {
				piezasActiva.get(numeroPieza).moverPieza(lateral, 0);
			}
		}
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

	public ArrayList<Pieza> getPiezasNext() {
		return piezasNext;
	}

	public void setPiezasNext(ArrayList<Pieza> piezasNext) {
		this.piezasNext = piezasNext;
	}

	public ArrayList<Pieza> getPiezasActiva() {
		return piezasActiva;
	}

	public void setPiezasActiva(ArrayList<Pieza> piezasActiva) {
		this.piezasActiva = piezasActiva;
	}

	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
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
