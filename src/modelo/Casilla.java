package modelo;

import java.awt.Color;

public class Casilla {
	private Color color;
	private int posicionX;
	private int posicionY;
	
	public Casilla(Color color, int posicionX, int posicionY) {
		super();
		this.color = color;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	
	public Casilla(Color color,int posicionY) {
		super();
		this.color = color;
		this.posicionX = 0;
		this.posicionY = posicionY;
	}

	public void desplazar(int lateral, int vertical) {
		this.posicionX+=vertical;
		this.posicionY+=lateral;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((Casilla)obj).color.equals(this.color)&&
				((Casilla)obj).posicionX==this.getPosicionX()&&
				((Casilla)obj).posicionY==this.getPosicionY();
	}		
}
