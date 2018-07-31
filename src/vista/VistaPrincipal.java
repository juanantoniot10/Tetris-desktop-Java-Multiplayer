package vista;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class VistaPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel panelParaJuego;
	protected JPanel panelJugadores;
	protected PanelOpciones panelOpciones;
	
	
	public VistaPrincipal() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setMinimumSize(new Dimension(300, 300));
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(Color.BLACK);
		getContentPane().add(panelCabecera, BorderLayout.NORTH);
		panelCabecera.setLayout(new BoxLayout(panelCabecera, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("T E T R I S");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setMaximumSize(new Dimension(3335, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(139, 0, 0), new Color(220, 20, 60), new Color(255, 0, 0), new Color(139, 0, 0)));
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 40));
		lblNewLabel.setBackground(Color.BLACK);
		panelCabecera.add(lblNewLabel);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.BLACK);
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[]{195, 90, 0};
		gbl_panelPrincipal.rowHeights = new int[]{0, 0, 0};
		gbl_panelPrincipal.columnWeights = new double[]{8.0, 1.0, Double.MIN_VALUE};
		gbl_panelPrincipal.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panelPrincipal.setLayout(gbl_panelPrincipal);
		
		panelParaJuego = new JPanel();
		panelParaJuego.setFocusTraversalPolicyProvider(true);
		panelParaJuego.setFocusCycleRoot(true);
		panelParaJuego.setBackground(Color.BLACK);
		GridBagConstraints gbc_panelJuego = new GridBagConstraints();
		gbc_panelJuego.fill = GridBagConstraints.BOTH;
		gbc_panelJuego.gridheight = 2;
		gbc_panelJuego.insets = new Insets(0, 0, 5, 5);
		panelPrincipal.add(panelParaJuego, gbc_panelJuego);
		panelParaJuego.setLayout(new GridLayout(1, 1, 1, 1));
		panelOpciones = new PanelOpciones();
		panelParaJuego.add(panelOpciones);
		
		panelJugadores = new JPanel();
		panelJugadores.setOpaque(false);
		panelJugadores.setBackground(Color.BLACK);
		GridBagConstraints gbc_panelJugadores = new GridBagConstraints();
		gbc_panelJugadores.gridheight = 2;
		gbc_panelJugadores.insets = new Insets(0, 0, 5, 0);
		gbc_panelJugadores.fill = GridBagConstraints.BOTH;
		gbc_panelJugadores.gridx = 1;
		gbc_panelJugadores.gridy = 0;
		panelPrincipal.add(panelJugadores, gbc_panelJugadores);
		panelJugadores.setLayout(new GridLayout(0, 1, 0, 0));
		
		PanelJugador panelJugador1 = new PanelJugador("Player1");
		panelJugador1.setOpaque(false);
		panelJugador1.setName("0");
		panelJugadores.add(panelJugador1);
	}
	
}
