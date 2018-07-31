package vista;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class PanelJuego extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PanelJuego(int filas,int columnas) {
		setFocusCycleRoot(true);
		setFocusTraversalPolicyProvider(true);
		setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)), new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), new Color(153, 180, 209), new Color(153, 180, 209), new Color(153, 180, 209))));
		setOpaque(false);
		setLayout(new GridLayout(filas, columnas));
		setFocusable(true);
	}
	@Override
	public boolean isFocusTraversable() {
		return true;
	}
}
