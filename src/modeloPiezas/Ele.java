package modeloPiezas;

import modelo.Casilla;
import utiles.Colores;

public class Ele extends Pieza {
	private final int tamanio=4;
	private int estado;
	
	public Ele(int centroTablero) {
		super(centroTablero);
		this.estado = 0;
		casillas = new Casilla[tamanio];
		color = Colores.eleInversa.getColor();
		for (int i = 0; i < casillas.length; i++) {
			casillas[i] = new Casilla(color, centroTablero);
			if(i==0) {
				casillas[i].setPosicionX(2);
				casillas[i].setPosicionY(centroTablero+3);
			}
			else {
				casillas[i].setPosicionX(3);
				casillas[i].setPosicionY(centroTablero+i);
			}
			
		}
	}

	@Override
	public void cambiarFormaPieza() {
		switch (estado) {
		case 0:
			this.casillas[0].desplazar(0, 2);
			this.casillas[1].desplazar(1,-1);
			this.casillas[3].desplazar(-1, 1);
			break;
		case 1:
			this.casillas[0].desplazar(-2, 0);
			this.casillas[1].desplazar(1, 1);
			this.casillas[3].desplazar(-1, -1);
			break;
		case 2:
			this.casillas[0].desplazar(0, -2);
			this.casillas[1].desplazar(-1, 1);
			this.casillas[3].desplazar(1, -1);
			break;
		case 3:
			this.casillas[0].desplazar(2, 0);
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
		return "ele";
	}
	
	
}
