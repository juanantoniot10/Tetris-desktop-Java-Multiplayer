package reproductor;

import java.io.FileInputStream;
import javax.swing.SwingWorker;

import javazoom.jl.player.Player;

public class ReproductorEFX{
		
	public static void reproducirAudio(String ruta) {
		SwingWorker worker=  new SwingWorker<Object, Object>(){
				@Override
				protected Object doInBackground() throws Exception {
					try {
						Player reproductor = new Player(new FileInputStream(String.valueOf(ruta)));
						reproductor.play();
						}
					catch (Exception tipoerror) {
						System.out.println("" + tipoerror);
					}
					return null;
				}
			};	
			worker.execute();
	}

}
