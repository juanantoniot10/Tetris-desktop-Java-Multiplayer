package reproductor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Timer;

import javax.swing.SwingWorker;

import javazoom.jl.player.Player;

public class ReproductorBSO implements ActionListener{
	private boolean sonando = false;
	private SwingWorker worker;
	private Player reproductor;
	private long inicioCancion = 0;
	private long duracionCancion = 218000;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!sonando) {
			worker=  new SwingWorker<Object, Object>(){
				@Override
				protected Object doInBackground() throws Exception {
					reproducirAudio("audios/TetrisBSO.mp3");
					return null;
				}
			};	
			worker.execute();
			inicioCancion = System.currentTimeMillis();
			sonando = true;
		}
		else {
			reproductor.close();
			sonando = false;
		}
	}
	private void reproducirAudio(String ruta) {
		try {
			reproductor = new Player(new FileInputStream(String.valueOf(ruta)));
			reproductor.play();
			}
		catch (Exception tipoerror) {
			System.out.println("" + tipoerror);
		}
	}
	public boolean isSonando() {
		return sonando;
	}
	public void setSonando(boolean sonando) {
		this.sonando = sonando;
	}
	public boolean isCancionTerminada() {
		return System.currentTimeMillis()>=inicioCancion+duracionCancion;
	}

	public SwingWorker getWorker() {
		return worker;
	}
	public void setWorker(SwingWorker worker) {
		this.worker = worker;
	}
	public Player getReproductor() {
		return reproductor;
	}
	public void setReproductor(Player reproductor) {
		this.reproductor = reproductor;
	}
	public long getDuracionCancion() {
		return duracionCancion;
	}
	public void setDuracionCancion(long duracionCancion) {
		this.duracionCancion = duracionCancion;
	}
	
	
}
