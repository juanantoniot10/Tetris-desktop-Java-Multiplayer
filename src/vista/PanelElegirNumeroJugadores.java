package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class PanelElegirNumeroJugadores extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton unJugador;
	private JButton dosJugadores;
	private JButton tresJugadores;
	private JButton cuatroJugadores;
	private JTextField nombreJugadorUno;
	private JTextField nombreJugadorDos;
	private JTextField nombreJugadorTres;
	private JTextField nombreJugadorCuatro;
	
	public PanelElegirNumeroJugadores() {
		setLayout(new GridLayout(4, 2, 0, 0));
		unJugador = new JButton("1");
		unJugador.setForeground(Color.LIGHT_GRAY);
		unJugador.setBackground(new Color(0, 51, 0));
		unJugador.setName("0");
		unJugador.setMinimumSize(new Dimension(43, 23));
		unJugador.setMaximumSize(new Dimension(2220, 400));
		unJugador.setMargin(new Insets(20, 20, 20, 20));
		unJugador.setHorizontalTextPosition(SwingConstants.LEADING);
		unJugador.setFont(new Font("Pristina", Font.BOLD, 25));
		add(unJugador);
		
		nombreJugadorUno = new JTextField();
		nombreJugadorUno.setToolTipText("");
		nombreJugadorUno.setText("Player1");
		nombreJugadorUno.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJugadorUno.setFont(new Font("Pristina", Font.BOLD, 17));
		nombreJugadorUno.setColumns(10);
		nombreJugadorUno.setName("0");
		add(nombreJugadorUno);
		
		dosJugadores = new JButton("2");
		dosJugadores.setForeground(Color.LIGHT_GRAY);
		dosJugadores.setBackground(new Color(0, 102, 0));
		dosJugadores.setName("1");
		dosJugadores.setMinimumSize(new Dimension(43, 23));
		dosJugadores.setMaximumSize(new Dimension(2220, 400));
		dosJugadores.setMargin(new Insets(20, 20, 20, 20));
		dosJugadores.setHorizontalTextPosition(SwingConstants.LEADING);
		dosJugadores.setFont(new Font("Pristina", Font.BOLD, 25));
		add(dosJugadores);
		
		nombreJugadorDos = new JTextField();
		nombreJugadorDos.setName("1");
		nombreJugadorDos.setEnabled(false);
		nombreJugadorDos.setToolTipText("");
		nombreJugadorDos.setText("Player2");
		nombreJugadorDos.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJugadorDos.setFont(new Font("Pristina", Font.BOLD, 17));
		nombreJugadorDos.setColumns(10);
		add(nombreJugadorDos);
		
		tresJugadores = new JButton("3");
		tresJugadores.setForeground(Color.LIGHT_GRAY);
		tresJugadores.setBackground(new Color(102, 153, 0));
		tresJugadores.setName("2");
		tresJugadores.setMinimumSize(new Dimension(43, 23));
		tresJugadores.setMaximumSize(new Dimension(2220, 400));
		tresJugadores.setMargin(new Insets(20, 20, 20, 20));
		tresJugadores.setHorizontalTextPosition(SwingConstants.LEADING);
		tresJugadores.setFont(new Font("Pristina", Font.BOLD, 25));
		add(tresJugadores);
		
		nombreJugadorTres = new JTextField();
		nombreJugadorTres.setName("2");
		nombreJugadorTres.setEnabled(false);
		nombreJugadorTres.setToolTipText("");
		nombreJugadorTres.setText("Player3");
		nombreJugadorTres.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJugadorTres.setFont(new Font("Pristina", Font.BOLD, 17));
		nombreJugadorTres.setColumns(10);
		add(nombreJugadorTres);
		
		cuatroJugadores = new JButton("4");
		cuatroJugadores.setForeground(Color.LIGHT_GRAY);
		cuatroJugadores.setBackground(new Color(102, 102, 0));
		cuatroJugadores.setName("3");
		cuatroJugadores.setMinimumSize(new Dimension(43, 23));
		cuatroJugadores.setMaximumSize(new Dimension(2220, 400));
		cuatroJugadores.setMargin(new Insets(20, 20, 20, 20));
		cuatroJugadores.setHorizontalTextPosition(SwingConstants.LEADING);
		cuatroJugadores.setFont(new Font("Pristina", Font.BOLD, 25));
		add(cuatroJugadores);
		
		nombreJugadorCuatro = new JTextField();
		nombreJugadorCuatro.setName("3");
		nombreJugadorCuatro.setEnabled(false);
		nombreJugadorCuatro.setToolTipText("");
		nombreJugadorCuatro.setText("Player4");
		nombreJugadorCuatro.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJugadorCuatro.setFont(new Font("Pristina", Font.BOLD, 17));
		nombreJugadorCuatro.setColumns(10);
		add(nombreJugadorCuatro);
		
	}

	public JButton getUnJugador() {
		return unJugador;
	}

	public void setUnJugador(JButton unJugador) {
		this.unJugador = unJugador;
	}

	public JButton getDosJugadores() {
		return dosJugadores;
	}

	public void setDosJugadores(JButton dosJugadores) {
		this.dosJugadores = dosJugadores;
	}

	public JButton getTresJugadores() {
		return tresJugadores;
	}

	public void setTresJugadores(JButton tresJugadores) {
		this.tresJugadores = tresJugadores;
	}

	public JButton getCuatroJugadores() {
		return cuatroJugadores;
	}

	public void setCuatroJugadores(JButton cuatroJugadores) {
		this.cuatroJugadores = cuatroJugadores;
	}

	public JTextField getNombreJugadorUno() {
		return nombreJugadorUno;
	}

	public void setNombreJugadorUno(JTextField nombreJugadorUno) {
		this.nombreJugadorUno = nombreJugadorUno;
	}

	public JTextField getNombreJugadorDos() {
		return nombreJugadorDos;
	}

	public void setNombreJugadorDos(JTextField nombreJugadorDos) {
		this.nombreJugadorDos = nombreJugadorDos;
	}

	public JTextField getNombreJugadorTres() {
		return nombreJugadorTres;
	}

	public void setNombreJugadorTres(JTextField nombreJugadorTres) {
		this.nombreJugadorTres = nombreJugadorTres;
	}

	public JTextField getNombreJugadorCuatro() {
		return nombreJugadorCuatro;
	}

	public void setNombreJugadorCuatro(JTextField nombreJugadorCuatro) {
		this.nombreJugadorCuatro = nombreJugadorCuatro;
	}
	
}
