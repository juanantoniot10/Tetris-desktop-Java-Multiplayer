package facade;

import java.util.TreeSet;
import almacenes.AlmacenIndividualSet;
import modelo.Jugador;
import utiles.Utiles;

public class Datos {
	private AlmacenIndividualSet<Jugador> jugadores;
	private TreeSet<Jugador> jugadoresSet = new TreeSet<>();

	public Datos() {
		super();
		this.jugadores = new AlmacenIndividualSet<>(jugadoresSet, Utiles.RUTAJUGADORES);
	}

	public boolean grabar(Jugador jugador) {
		return jugadores.grabar(jugador);
	}

	public boolean borrar(Jugador jugador) {
		return jugadores.borrar(jugador);
	}

	public Jugador obtenerJugador(int idJugador) {
		return jugadores.obtener(idJugador);
	}

	public int obtenerTotalJugadores() {
		return jugadores.obtenerTotalJugadores();
	}
}