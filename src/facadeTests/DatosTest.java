package facadeTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.File;
import org.junit.After;
import org.junit.Test;
import facade.Datos;
import modelo.Jugador;
import utiles.Utiles;

public class DatosTest {
	Datos instancia = new Datos();
	Jugador jugadorUno = new Jugador("JugadorPruebaUno");
	Jugador jugadorDos = new Jugador("JugadorPruebaDos");
	
	@After
	public void tearDown() throws Exception {
		Utiles.borrarCarpeta(new File("./data"));
	}
	
	
	@Test
	public void testGrabarJugador() {
		assertTrue(instancia.grabar(jugadorUno));
		assertEquals(instancia.obtenerJugador(jugadorUno.getIdJugador()),jugadorUno);
		assertTrue(instancia.grabar(jugadorDos));
		assertEquals(instancia.obtenerJugador(jugadorDos.getIdJugador()),jugadorDos);
	}

	@Test
	public void testBorrarJugador() {
		assertTrue(instancia.grabar(jugadorUno));
		assertEquals(instancia.obtenerJugador(jugadorUno.getIdJugador()),jugadorUno);
		assertTrue(instancia.grabar(jugadorDos));
		assertEquals(instancia.obtenerJugador(jugadorDos.getIdJugador()),jugadorDos);
		instancia.borrar(jugadorUno);
		assertNotEquals(instancia.obtenerJugador(jugadorUno.getIdJugador()),jugadorUno);
		assertEquals(instancia.obtenerJugador(jugadorUno.getIdJugador()),jugadorDos);
		instancia.borrar(jugadorDos);
		assertNull(instancia.obtenerJugador(jugadorDos.getIdJugador()));
	}

	@Test
	public void testObtenerJugador() {
		assertTrue(instancia.grabar(jugadorUno));
		assertEquals(instancia.obtenerJugador(jugadorUno.getIdJugador()),jugadorUno);
		assertTrue(instancia.grabar(jugadorDos));
		assertEquals(instancia.obtenerJugador(jugadorDos.getIdJugador()),jugadorDos);
	}

}