package utiles;

import java.awt.Container;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Utiles {
	public static final String RUTAJUGADORES = "./data/jugadores/jugadores.data";
	
	public static ImageIcon createScaledIcon(ImageIcon Imagen, int height) {
		return new ImageIcon(Imagen.getImage().getScaledInstance(height - 2, height - 2, Image.SCALE_SMOOTH));
	}
	
	public static int crearRandom(int min,int max) {
		int numeroAleatorio=((int)(Math.random()*((max-min)+1)))+min;
		return numeroAleatorio;
	}
	public static void actualizar(Container container){
  		SwingUtilities.updateComponentTreeUI(container);
  	}
	
	public static void actualizar(JPanel panel) {
	  	SwingUtilities.updateComponentTreeUI(panel);
	}

	public static void borrarCarpeta(File carpetaGenerada) {
	    if (carpetaGenerada.isDirectory()) { 
	        for (File f : carpetaGenerada.listFiles()) { 
	        	borrarCarpeta(f);  } 
	    } 
	    carpetaGenerada.delete(); 
	}
}