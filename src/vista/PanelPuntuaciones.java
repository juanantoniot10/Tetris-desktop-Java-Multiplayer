package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Insets;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JButton;

public class PanelPuntuaciones extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[][] data;
	private String[] nombresColumnas = { "Nombre", "Puntos", "Lineas", "Nivel" };
	private DefaultTableModel modeloTabla = new DefaultTableModel(data, nombresColumnas);
	private JTable table;
	private JButton botonSalir;
	private JButton botonReiniciar;

	/**
	 * Create the frame.
	 */
	public PanelPuntuaciones() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		table = new JTable(modeloTabla);
		table.setEnabled(true);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		botonReiniciar = new JButton("REINICIAR");
		panel.add(botonReiniciar);
		
		botonSalir = new JButton("SALIR");
		panel.add(botonSalir);

		GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
		gbc_textFieldDescripcion.gridheight = 3;
		gbc_textFieldDescripcion.gridwidth = 3;
		gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDescripcion.fill = GridBagConstraints.BOTH;
		gbc_textFieldDescripcion.gridx = 4;
		gbc_textFieldDescripcion.gridy = 1;

		GridBagConstraints gbc_textFieldPrecio = new GridBagConstraints();
		gbc_textFieldPrecio.gridwidth = 3;
		gbc_textFieldPrecio.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrecio.gridx = 4;
		gbc_textFieldPrecio.gridy = 5;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public JTable getTablaCliente() {
		return table;
	}

	public String[][] getData() {
		return data;
	}

	public void setData(String[][] data) {
		this.data = data;
	}

	public String[] getNombresColumnas() {
		return nombresColumnas;
	}

	public void setNombresColumnas(String[] nombresColumnas) {
		this.nombresColumnas = nombresColumnas;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBotonSalir() {
		return botonSalir;
	}

	public void setBotonSalir(JButton botonSalir) {
		this.botonSalir = botonSalir;
	}

	public JButton getBotonReiniciar() {
		return botonReiniciar;
	}

	public void setBotonReiniciar(JButton botonReiniciar) {
		this.botonReiniciar = botonReiniciar;
	}
	
}
