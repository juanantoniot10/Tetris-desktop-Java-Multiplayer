package modeloPiezas;

import java.awt.Color;
import modelo.Casilla;

public abstract class Pieza {
	protected Casilla casillas [];
	protected boolean activa;
	protected Color color;
	protected int centroTablero;
	
	
	public Pieza(int centroTablero) {
		super();
		this.activa = false;
	}

	public abstract void cambiarFormaPieza();
	
	public void moverPieza(int lateral,int vertical) {
		for (int i = 0; i < this.casillas.length; i++) {
			this.casillas[i].desplazar(lateral, vertical);
		}
		
	}

	public Casilla[] getCasillas() {
		return casillas;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getCentroTablero() {
		return centroTablero;
	}

	public void setCentroTablero(int centroTablero) {
		this.centroTablero = centroTablero;
	}

	public void setCasillas(Casilla[] casillas) {
		this.casillas = casillas;
	}
}
