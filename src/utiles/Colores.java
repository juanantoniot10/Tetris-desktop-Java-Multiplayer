package utiles;

import java.awt.Color;

public enum Colores {
	palito(Color.CYAN), eleInversa(Color.BLUE), ele(Color.ORANGE), cuadrado(Color.YELLOW), zeta(Color.GREEN), zetaInversa(Color.RED),te(Color.MAGENTA);
	
	private Color color;

	private Colores(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

}
