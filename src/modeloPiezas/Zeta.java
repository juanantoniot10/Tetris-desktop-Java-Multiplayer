package modeloPiezas;

import modelo.Casilla;
import utiles.Colores;

public class Zeta extends Pieza {
	private final int tamanio=4;
	
	public Zeta(int centroTablero) {
		super(centroTablero);
		casillas = new Casilla[tamanio];
		color = Colores.zeta.getColor();
		for (int i = 0; i < casillas.length; i++) {
			casillas[i] = new Casilla(color, centroTablero);
			if(i<2) {
				casillas[i].setPosicionX(2);
				casillas[i].setPosicionY(centroTablero+i);
			}
			else {
				casillas[i].setPosicionX(3);
				casillas[i].setPosicionY(centroTablero+i-1);
			}
			
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
		this.casillas[2].desplazar(-1, 0);
		this.casillas[3].desplazar(-1, -2);
	}

	/**
	 * 
	 */
	private void ponerHorizontal() {
		this.casillas[2].desplazar(1, 0);
		this.casillas[3].desplazar(1, 2);
	}

	/**
	 * @return
	 */
	private boolean isVertical() {
		return this.casillas[2].getPosicionX()!=this.casillas[3].getPosicionX();
	}
	@Override
	public String toString() {
		return "zeta";
	}
	
	
}
