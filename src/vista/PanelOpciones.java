package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

public class PanelOpciones extends JPanel{
	private JButton btnNivel;
	private JButton btnTamaopantalla;
	private JButton btnColorDeFondo;
	private JButton btnIniciarJuego;
	private JPanel panelNombreOpcion;
	private JPanel panelValorOpcion;
	private JTextField nombreJugador;
	public PanelOpciones() {
		setOpaque(false);
		setLayout(new GridLayout(0, 2, 0, 0));
		
		panelNombreOpcion = new JPanel();
		panelNombreOpcion.setOpaque(false);
		panelNombreOpcion.setBackground(Color.BLACK);
		add(panelNombreOpcion);
		panelNombreOpcion.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnNivel = new JButton("Nivel inicial");
		btnNivel.setForeground(Color.LIGHT_GRAY);
		btnNivel.setBackground(new Color(51, 51, 51));
		btnNivel.setMinimumSize(new Dimension(43, 23));
		btnNivel.setMargin(new Insets(20, 20, 20, 20));
		btnNivel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNivel.setFont(new Font("Pristina", Font.BOLD, 18));
		btnNivel.setMaximumSize(new Dimension(2220, 400));
		btnNivel.setHorizontalTextPosition(SwingConstants.LEADING);
		panelNombreOpcion.add(btnNivel);
		
		btnTamaopantalla = new JButton("Tama\u00F1o tablero");
		btnTamaopantalla.setForeground(Color.LIGHT_GRAY);
		btnTamaopantalla.setBackground(new Color(51, 51, 51));
		btnTamaopantalla.setMinimumSize(new Dimension(43, 23));
		btnTamaopantalla.setMaximumSize(new Dimension(2220, 400));
		btnTamaopantalla.setMargin(new Insets(20, 20, 20, 20));
		btnTamaopantalla.setHorizontalTextPosition(SwingConstants.LEADING);
		btnTamaopantalla.setFont(new Font("Pristina", Font.BOLD, 18));
		panelNombreOpcion.add(btnTamaopantalla);
		
		btnColorDeFondo = new JButton("Color de fondo");
		btnColorDeFondo.setForeground(Color.LIGHT_GRAY);
		btnColorDeFondo.setBackground(new Color(51, 51, 51));
		panelNombreOpcion.add(btnColorDeFondo);
		btnColorDeFondo.setMinimumSize(new Dimension(43, 23));
		btnColorDeFondo.setMaximumSize(new Dimension(2220, 400));
		btnColorDeFondo.setMargin(new Insets(20, 20, 20, 20));
		btnColorDeFondo.setHorizontalTextPosition(SwingConstants.LEADING);
		btnColorDeFondo.setFont(new Font("Pristina", Font.BOLD, 18));
		
		btnIniciarJuego = new JButton("INICIAR JUEGO");
		btnIniciarJuego.setForeground(Color.WHITE);
		btnIniciarJuego.setBackground(new Color(51, 102, 51));
		btnIniciarJuego.setMinimumSize(new Dimension(43, 23));
		btnIniciarJuego.setMaximumSize(new Dimension(2220, 400));
		btnIniciarJuego.setMargin(new Insets(20, 20, 20, 20));
		btnIniciarJuego.setHorizontalTextPosition(SwingConstants.LEADING);
		btnIniciarJuego.setFont(new Font("Pristina", Font.BOLD, 18));
		panelNombreOpcion.add(btnIniciarJuego);
		
		nombreJugador = new JTextField();
		nombreJugador.setToolTipText("Player1");
		nombreJugador.setText("Player1");
		nombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJugador.setFont(new Font("Pristina", Font.BOLD, 17));
		nombreJugador.setColumns(10);
		panelNombreOpcion.add(nombreJugador);
		
		panelValorOpcion = new JPanel();
		panelValorOpcion.setOpaque(false);
		add(panelValorOpcion);
		panelValorOpcion.setLayout(new GridLayout(0, 1, 0, 0));
	}
	public JButton getBtnNivel() {
		return btnNivel;
	}
	public void setBtnNivel(JButton btnNivel) {
		this.btnNivel = btnNivel;
	}
	public JButton getBtnTamaopantalla() {
		return btnTamaopantalla;
	}
	public void setBtnTamaopantalla(JButton btnTamaopantalla) {
		this.btnTamaopantalla = btnTamaopantalla;
	}

	public JButton getBtnColorDeFondo() {
		return btnColorDeFondo;
	}

	public JButton getBtnIniciarJuego() {
		return btnIniciarJuego;
	}

	public JPanel getPanelNombreOpcion() {
		return panelNombreOpcion;
	}

	public JPanel getPanelValorOpcion() {
		return panelValorOpcion;
	}

	public JTextField getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(JTextField nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public void setBtnColorDeFondo(JButton btnColorDeFondo) {
		this.btnColorDeFondo = btnColorDeFondo;
	}
	public void setBtnIniciarJuego(JButton btnIniciarJuego) {
		this.btnIniciarJuego = btnIniciarJuego;
	}
	public void setPanelNombreOpcion(JPanel panelNombreOpcion) {
		this.panelNombreOpcion = panelNombreOpcion;
	}
	public void setPanelValorOpcion(JPanel panelValorOpcion) {
		this.panelValorOpcion = panelValorOpcion;
	}	
	
}
