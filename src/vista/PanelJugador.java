package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;

import reproductor.ReproductorBSO;

import javax.swing.JButton;

public class PanelJugador extends JPanel{
	
	private static final int numeroFilasNext = 2;
	private static final int numeroColumnasNext = 4;
	private JLabel lineas;
	private JLabel nivel;
	private JLabel puntos;
	private JPanel panelNext;
	private JLabel nombre;
	private JButton btnMusicOnoff;
	
	
	public PanelJugador(String nombreJugador) {
		setBorder(new LineBorder(new Color(204, 204, 102), 2, true));
		setOpaque(false);
		setMinimumSize(new Dimension(100, 100));
		setPreferredSize(new Dimension(187, 92));
		setMaximumSize(new Dimension(155, 100));
		setBackground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {90, 90};
		gridBagLayout.rowHeights = new int[] {15, 15, 15, 15, 30};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		nombre = new JLabel(nombreJugador);
		nombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		nombre.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.fill = GridBagConstraints.VERTICAL;
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.gridx = 0;
		gbc_nombre.gridy = 0;
		add(nombre, gbc_nombre);
		
		btnMusicOnoff = new JButton("music on/off");
		GridBagConstraints gbc_btnMusicOnoff = new GridBagConstraints();
		gbc_btnMusicOnoff.insets = new Insets(0, 0, 5, 0);
		gbc_btnMusicOnoff.gridx = 1;
		gbc_btnMusicOnoff.gridy = 0;
		add(btnMusicOnoff, gbc_btnMusicOnoff);
		
		JLabel lblLineas = new JLabel("LINEAS");
		lblLineas.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblLineas.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblLineas = new GridBagConstraints();
		gbc_lblLineas.fill = GridBagConstraints.VERTICAL;
		gbc_lblLineas.insets = new Insets(0, 0, 5, 5);
		gbc_lblLineas.gridx = 0;
		gbc_lblLineas.gridy = 1;
		add(lblLineas, gbc_lblLineas);
		
		lineas = new JLabel("0");
		lineas.setForeground(Color.LIGHT_GRAY);
		lineas.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lineas = new GridBagConstraints();
		gbc_lineas.fill = GridBagConstraints.VERTICAL;
		gbc_lineas.insets = new Insets(0, 0, 5, 0);
		gbc_lineas.gridx = 1;
		gbc_lineas.gridy = 1;
		add(lineas, gbc_lineas);
		
		JLabel lblNivel = new JLabel("NIVEL");
		lblNivel.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNivel.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblNivel = new GridBagConstraints();
		gbc_lblNivel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNivel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivel.gridx = 0;
		gbc_lblNivel.gridy = 2;
		add(lblNivel, gbc_lblNivel);
		
		nivel = new JLabel("1");
		nivel.setForeground(Color.LIGHT_GRAY);
		nivel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_nivel = new GridBagConstraints();
		gbc_nivel.fill = GridBagConstraints.VERTICAL;
		gbc_nivel.insets = new Insets(0, 0, 5, 0);
		gbc_nivel.gridx = 1;
		gbc_nivel.gridy = 2;
		add(nivel, gbc_nivel);
		
		JLabel lblPuntuacion = new JLabel("PTS");
		lblPuntuacion.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblPuntuacion.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblPuntuacion = new GridBagConstraints();
		gbc_lblPuntuacion.fill = GridBagConstraints.VERTICAL;
		gbc_lblPuntuacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntuacion.gridx = 0;
		gbc_lblPuntuacion.gridy = 3;
		add(lblPuntuacion, gbc_lblPuntuacion);
		
		puntos = new JLabel("0");
		puntos.setForeground(Color.LIGHT_GRAY);
		puntos.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_puntos = new GridBagConstraints();
		gbc_puntos.fill = GridBagConstraints.VERTICAL;
		gbc_puntos.insets = new Insets(0, 0, 5, 0);
		gbc_puntos.gridx = 1;
		gbc_puntos.gridy = 3;
		add(puntos, gbc_puntos);
		
		JLabel lblNext = new JLabel("NEXT");
		lblNext.setForeground(Color.LIGHT_GRAY);
		lblNext.setFont(new Font("Tahoma", Font.BOLD, 9));
		GridBagConstraints gbc_lblNext = new GridBagConstraints();
		gbc_lblNext.fill = GridBagConstraints.VERTICAL;
		gbc_lblNext.insets = new Insets(0, 0, 0, 5);
		gbc_lblNext.gridx = 0;
		gbc_lblNext.gridy = 4;
		add(lblNext, gbc_lblNext);
		
		panelNext = new JPanel();
		panelNext.setOpaque(false);
		panelNext.setMinimumSize(new Dimension(10, 30));
		panelNext.setPreferredSize(new Dimension(10, 30));
		panelNext.setMaximumSize(new Dimension(1000, 1000));
		panelNext.setBackground(Color.BLACK);
		GridBagConstraints gbc_panelNext = new GridBagConstraints();
		gbc_panelNext.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelNext.gridx = 1;
		gbc_panelNext.gridy = 4;
		add(panelNext, gbc_panelNext);
		panelNext.setLayout(new GridLayout(numeroFilasNext, numeroColumnasNext, 0, 0));
		
		for (int i = 0; i < numeroFilasNext; i++) {
			for (int j = 0; j < numeroColumnasNext; j++) {
				panelNext.add(new LabelVacia());
			}
		}
	}


	public JLabel getNombre() {
		return nombre;
	}


	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}


	public JLabel getLineas() {
		return lineas;
	}


	public void setLineas(JLabel lineas) {
		this.lineas = lineas;
	}


	public JLabel getNivel() {
		return nivel;
	}


	public void setNivel(JLabel nivel) {
		this.nivel = nivel;
	}


	public JLabel getPuntos() {
		return puntos;
	}


	public void setPuntos(JLabel puntos) {
		this.puntos = puntos;
	}


	public JPanel getPanelNext() {
		return panelNext;
	}


	public void setPanelNext(JPanel panelNext) {
		this.panelNext = panelNext;
	}


	public JButton getBtnMusicOnoff() {
		return btnMusicOnoff;
	}


	public void setBtnMusicOnoff(JButton btnMusicOnoff) {
		this.btnMusicOnoff = btnMusicOnoff;
	}


	
	
}