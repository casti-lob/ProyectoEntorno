package test.elemento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;
import elementos.CoordenadaException;

class TestCoordenada {
	
	@Test
	public void coordenadaXSuperior() {
		
			Coordenada c = new Coordenada(10, 0);
			assertEquals(0, c.getX());

	}
	
	@Test
	public void coordenadaXInferior() {
		Coordenada c = new Coordenada(-1, 0);
		assertEquals(0, c.getX());
	}
	
	@Test
	public void coordenadaYSuperior() {
		Coordenada c = new Coordenada(10, 0);
		assertEquals(0, c.getY());
	}
	
	@Test
	public void coordenadaYInferior() {
		Coordenada c = new Coordenada(-1, 0);
		assertEquals(0, c.getY());
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
	
	@Test
	public void subirPosicion() {
		Coordenada c = new Coordenada(5, 5);
		assertTrue(c.goUp());
	}
	
	@Test
	public void salirsePorArriba() {
		Coordenada c = new Coordenada(5, 0);
		assertFalse(c.goUp());
	}
	
	@Test
	public void bajarPosicion() {
		Coordenada c = new Coordenada(5, 5);
		assertTrue(c.goDown());
	}
	
	@Test
	public void salirsePorAbajo() {
		Coordenada c = new Coordenada(5, 9);
		assertFalse(c.goDown());
	}
	
	@Test
	public void moverDerecha() {
		Coordenada c = new Coordenada(5, 5);
		assertTrue(c.goRight());
	}
	@Test
	public void salirseDerecha() {
		Coordenada c = new Coordenada(9, 5);
		assertFalse(c.goRight());
	}
	
	@Test
	public void moverIzquierda() {
		Coordenada c = new Coordenada(5, 5);
		assertTrue(c.goLeft());
	}
	@Test
	public void salirseIzquierda() {
		Coordenada c = new Coordenada(0, 5);
		assertFalse(c.goLeft());
	}
}
