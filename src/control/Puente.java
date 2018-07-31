package control;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import acciones.ListenerOpciones;
import vista.VistaPrincipal;

public class Puente extends VistaPrincipal{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActionListener listenerOpciones;
	
	public Puente() {
		super();
		this.listenerOpciones = new ListenerOpciones(this.panelOpciones,this.panelJugadores,this.panelParaJuego);
		for (int i = 0; i < ((JPanel)this.panelOpciones.getComponent(0)).getComponentCount(); i++) {
			((JButton)((JPanel)this.panelOpciones.getComponent(0)).getComponent(i)).addActionListener(listenerOpciones);
		}
	}

}
