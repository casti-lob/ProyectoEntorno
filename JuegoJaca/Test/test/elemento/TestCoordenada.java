package test.elemento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;
import elementos.CoordenadaException;

class TestCoordenada {
	
	@Test
	public void coordenadaXSuperior() {
		try {
			Coordenada c = new Coordenada(10, 0);
			fail("Error, debería haber lanzado una exception");
		} catch (CoordenadaException e) {
			System.out.println("Coordenada x superior a lo permitido");
		}
		
	}
	@Test
	public void coordenadaXInferior() {
		try {
			Coordenada c = new Coordenada(-1, 0);
			fail("Error, debería haber lanzado una exception");
		} catch (CoordenadaException e) {
			System.out.println("Coordenada x superior a lo permitido");
		}
	}
	
	@Test
	public void coordenadaYSuperior() {
		try {
			Coordenada c = new Coordenada(0, 10);
			fail("Error, debería haber lanzado una exception");
		} catch (CoordenadaException e) {
			System.out.println("Coordenada x superior a lo permitido");
		}
	}
	
	@Test
	public void coordenadaYInferior() {
		try {
			Coordenada c = new Coordenada(0, -1);
			fail("Error, debería haber lanzado una exception");
		} catch (CoordenadaException e) {
			System.out.println("Coordenada x superior a lo permitido");
		}
	}
	
	@Test
	public void generacionCoordenadaAuto() {
	
		for(int i=0;i<1000;i++) {
			
			Coordenada c = new Coordenada();
			assertTrue(c.getX()>-1&&c.getX()<10&&c.getY()>-1&&c.getY()<10);
		}
		
	}
	
	@Test
	public void clonarCoordenada() {
		Coordenada c = new Coordenada();
		Coordenada clon = c.clone();
		assertNotSame(c, clon);
	}
}
