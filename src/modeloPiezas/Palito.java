package modeloPiezas;

import modelo.Casilla;
import utiles.Colores;

public class Palito extends Pieza {
	private final int tamanio=4;
	
	public Palito(int centroTablero) {
		super(centroTablero);
		casillas = new Casilla[tamanio];
		color = Colores.palito.getColor();
		for (int i = 0; i < casillas.length; i++) {
			casillas[i] = new Casilla(color, centroTablero);
			casillas[i].setPosicionX(i);
			casillas[i].setPosicionY(centroTablero);
		}
	}

	@Override
	public void cambiarFormaPieza() {
		if (isVertical()) {
			ponerHorizontal();
		}
		else {
			ponerVertical();
		}
	}

	/**
	 * 
	 */
	private void ponerVertical() {
		this.casillas[0].desplazar(1, -1);
		this.casillas[2].desplazar(-1, +1);
		this.casillas[3].desplazar(-2, +2);
	}

	/**
	 * 
	 */
	private void ponerHorizontal() {
		this.casillas[0].desplazar(-1, 1);
		this.casillas[2].desplazar(1, -1);
		this.casillas[3].desplazar(2, -2);
	}

	/**
	 * @return
	 */
	private boolean isVertical() {
		return this.casillas[0].getPosicionX()!=this.casillas[1].getPosicionX();
	}
	@Override
	public String toString() {
		return "palito";
	}
	
	
}
