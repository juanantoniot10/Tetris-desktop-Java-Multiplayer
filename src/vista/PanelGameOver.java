package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.border.LineBorder;

import acciones.ListenerJuego;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.GridBagLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelGameOver extends JPanel{
	private JPanel panelJugadores;
	
	public PanelGameOver(JPanel panelJugadores) {
		this.panelJugadores = panelJugadores;
		setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblGame = new JLabel("GAME");
		lblGame.setForeground(new Color(255, 140, 0));
		lblGame.setOpaque(true);
		lblGame.setBackground(new Color(0, 0, 0));
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setFont(new Font("Wide Latin", Font.BOLD, 28));
		add(lblGame);
		
		JLabel lblOver = new JLabel("OVER");
		lblOver.setOpaque(true);
		lblOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblOver.setForeground(new Color(255, 140, 0));
		lblOver.setFont(new Font("Wide Latin", Font.BOLD, 30));
		lblOver.setBackground(Color.BLACK);
		add(lblOver);
		
	}
	
}
