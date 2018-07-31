package almecenesTests;

import static org.junit.Assert.*;
import java.io.File;
import java.util.TreeSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import almacenes.AlmacenIndividualSet;
import modelo.Jugador;
import utiles.Utiles;

public class AlmacenIndividualSetTest {
	Jugador jugadorPrueba = new Jugador("JugadorPrueba");
	Jugador jugadorPruebaDos = new Jugador("jugadorPruebaDos");
	AlmacenIndividualSet<Jugador> instancia;

	@Before
	public void setUp() throws Exception {
		instancia = new AlmacenIndividualSet<>(new TreeSet<Jugador>(), Utiles.RUTAJUGADORES);
	}

	@After
	public void tearDown() throws Exception {
		Utiles.borrarCarpeta(new File("./data"));
	}

	@Test
	public void testObtner() {
		assertNull(instancia.obtener(0));
		assertTrue(instancia.grabar(jugadorPrueba));
		assertTrue(instancia.grabar(jugadorPruebaDos));
		assertEquals(jugadorPrueba, instancia.obtener(0));
		assertEquals(jugadorPruebaDos, instancia.obtener(1));
	}
	@Test
	public void testGrabar() {
		//La parametrizasda no permite otro tipo de objeto que el declarado
		//instancia.grabar(new Socio(1));
		assertTrue(instancia.grabar(jugadorPrueba));
		assertFalse(instancia.grabar(jugadorPrueba));
		assertTrue(instancia.grabar(jugadorPruebaDos));
		assertEquals(jugadorPrueba, instancia.obtener(0));
		assertEquals(jugadorPruebaDos, instancia.obtener(1));
		assertNull(instancia.obtener(2));
		try{
			//no puede grabar un objeto null
			assertTrue(instancia.grabar(null));
			fail();
		}catch(AssertionError e){
			
		}
	}
	
}
