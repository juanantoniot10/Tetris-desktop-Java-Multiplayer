package modeloPiezas;

import modelo.Casilla;
import utiles.Colores;

public class EleInversa extends Pieza {
	private final int tamanio=4;
	private int estado;
	
	public EleInversa(int centroTablero) {
		super(centroTablero);
		this.estado=0;
		casillas = new Casilla[tamanio];
		color = Colores.ele.getColor();
		for (int i = 0; i < casillas.length; i++) {
			casillas[i] = new Casilla(color, centroTablero);
			if(i<1) {
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
		switch (estado) {
		case 0:
			this.casillas[0].desplazar(2, 0);
			this.casillas[1].desplazar(1,-1);
			this.casillas[3].desplazar(-1, 1);
			break;
		case 1:
			this.casillas[0].desplazar(0, 2);
			this.casillas[1].desplazar(1, 1);
			this.casillas[3].desplazar(-1, -1);
			break;
		case 2:
			this.casillas[0].desplazar(-2, 0);
			this.casillas[1].desplazar(-1, 1);
			this.casillas[3].desplazar(1, -1);
			break;
		case 3:
			this.casillas[0].desplazar(0, -2);
			this.casillas[1].desplazar(-1, -1);
			this.casillas[3].desplazar(1, 1);
			break;

		default:
			break;
		}
		estado++;
		if(estado>3)estado=0;
	}
	@Override
	public String toString() {
		return "eleInversa";
	}
	
	
}
