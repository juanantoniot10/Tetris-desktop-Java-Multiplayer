package accesoTests;

import static org.junit.Assert.*;
import java.io.File;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import acceso.DAO;
import modelo.Jugador;
import utiles.Utiles;

public class DAOTest {
	
	Jugador jugadorPrueba = new Jugador("JugadorPrueba");
	Jugador jugadorPruebaDos = new Jugador("jugadorPruebaDos");
	TreeSet<Jugador> jugadores = new TreeSet<>();
	DAO<Jugador> instancia;

	@Before
	public void setUp() throws Exception {
		instancia = new DAO<>();
		jugadores.add(jugadorPrueba);
		jugadores.add(jugadorPruebaDos);
	}

	@After
	public void tearDown() throws Exception {
		Utiles.borrarCarpeta(new File("./data"));
	}

	@Test
	public void testLeerString() {
		assertTrue(instancia.grabar(Utiles.RUTAJUGADORES, jugadorPrueba));
		assertEquals(jugadorPrueba, instancia.leer(Utiles.RUTAJUGADORES));
	}

	@Test
	public void testLeerStringInt() {
		assertTrue(instancia.grabar(Utiles.RUTAJUGADORES, jugadorPrueba,true));
		assertTrue(instancia.grabar(Utiles.RUTAJUGADORES, jugadorPruebaDos,true));
		assertEquals(jugadorPrueba, instancia.leer(Utiles.RUTAJUGADORES, 0));
		assertEquals(jugadorPruebaDos, instancia.leer(Utiles.RUTAJUGADORES,1));
		assertNull(instancia.leer(Utiles.RUTAJUGADORES, 2));
	}

	@Test
	public void testGrabarStringT() {
		assertTrue(instancia.grabar(Utiles.RUTAJUGADORES, jugadorPrueba));
		assertEquals(jugadorPrueba, instancia.leer(Utiles.RUTAJUGADORES));
	}

	@Test
	public void testGrabarStringTBoolean() {
		assertTrue(instancia.grabar(Utiles.RUTAJUGADORES, jugadorPrueba,true));
		assertTrue(instancia.grabar(Utiles.RUTAJUGADORES, jugadorPruebaDos,true));
		assertEquals(jugadorPrueba, instancia.leer(Utiles.RUTAJUGADORES, 0));
		assertEquals(jugadorPruebaDos, instancia.leer(Utiles.RUTAJUGADORES,1));
		assertNull(instancia.leer(Utiles.RUTAJUGADORES, 2));
	}

	@Test
	public void testBorrar() {
		assertTrue(instancia.grabar(Utiles.RUTAJUGADORES, jugadorPrueba,true));
		assertTrue(instancia.grabar(Utiles.RUTAJUGADORES, jugadorPruebaDos,true));
		assertEquals(jugadorPrueba, instancia.leer(Utiles.RUTAJUGADORES, 0));
		assertEquals(jugadorPruebaDos, instancia.leer(Utiles.RUTAJUGADORES,1));
		assertNull(instancia.leer(Utiles.RUTAJUGADORES, 2));
		instancia.borrar(Utiles.RUTAJUGADORES);
		assertNull(instancia.leer(Utiles.RUTAJUGADORES));
	}

	@Test
	public void testBorrarElemtento() {
		assertTrue(instancia.grabar(Utiles.RUTAJUGADORES, jugadorPrueba,true));
		assertTrue(instancia.grabar(Utiles.RUTAJUGADORES, jugadorPruebaDos,true));
		assertEquals(jugadorPrueba, instancia.leer(Utiles.RUTAJUGADORES, 0));
		assertEquals(jugadorPruebaDos, instancia.leer(Utiles.RUTAJUGADORES,1));
		assertNull(instancia.leer(Utiles.RUTAJUGADORES, 2));
		assertTrue(instancia.borrarElemtento(Utiles.RUTAJUGADORES, 0));
		assertNotEquals(instancia.leer(Utiles.RUTAJUGADORES, 0), jugadorPrueba);
		assertEquals(jugadorPruebaDos, instancia.leer(Utiles.RUTAJUGADORES,0));
		assertNull(instancia.leer(Utiles.RUTAJUGADORES,1));
		assertTrue(instancia.borrarElemtento(Utiles.RUTAJUGADORES, 0));
		assertNull(instancia.leer(Utiles.RUTAJUGADORES,0));
	}

}
