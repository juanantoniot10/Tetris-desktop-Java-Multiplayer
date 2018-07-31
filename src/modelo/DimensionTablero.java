package modelo;

public class DimensionTablero {
	private int filas;
	private int columnas;
	
	public DimensionTablero(int filas, int columnas) {
		super();
		this.filas = filas;
		this.columnas = columnas;
	}
	
	public int getFilas() {
		return filas;
	}
	public void setFilas(int filas) {
		this.filas = filas;
	}
	public int getColumnas() {
		return columnas;
	}
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}
	
	
}
