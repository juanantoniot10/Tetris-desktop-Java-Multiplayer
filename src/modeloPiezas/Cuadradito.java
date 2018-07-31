package modeloPiezas;

import modelo.Casilla;
import utiles.Colores;

public class Cuadradito extends Pieza {
	private final int tamanio=4;
	
	public Cuadradito(int centroTablero) {
		super(centroTablero);
		casillas = new Casilla[tamanio];
		color = Colores.cuadrado.getColor();
		for (int i = 0; i < casillas.length; i++) {
			casillas[i] = new Casilla(color, centroTablero);
			if(i<2) {
				casillas[i].setPosicionX(2);
				casillas[i].setPosicionY(centroTablero+i);
			}
			else {
				casillas[i].setPosicionX(3);
				casillas[i].setPosicionY(centroTablero+i-2);
			}
			
		}
	}

	@Override
	public void cambiarFormaPieza() {

	}

	@Override
	public String toString() {
		return "cuadradito";
	}
	
	
}
