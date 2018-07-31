package modelo;

import java.io.Serializable;

import utiles.Utiles;

public class Jugador implements Serializable,Comparable<Jugador>{
	private String nombre;
	private int puntuacion;
	private int lineas;
	private int nivel;
	private int puntuacionMaxima;
	private int idJugador;
	
	public Jugador(String nombre){
		super();
		this.nombre = nombre;
		this.puntuacion = 0;
		this.puntuacionMaxima = 0;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getPuntuacionMaxima() {
		return puntuacionMaxima;
	}

	public void setPuntuacionMaxima(int puntuacionMaxima) {
		this.puntuacionMaxima = puntuacionMaxima;
	}

	@Override
	public int compareTo(Jugador o) {
		return this.nombre.compareTo(o.nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Jugador)obj).idJugador==this.idJugador;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getLineas() {
		return lineas;
	}

	public void setLineas(int lineas) {
		this.lineas = lineas;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
}
