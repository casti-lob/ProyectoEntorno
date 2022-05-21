package test.logicaJuego;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;
import elementos.Element;
import elementos.ElementType;
import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;
import logicaJuego.Juego;
import logicaJuego.JuegoException;

public class TestJuego {
	
	@Test
	public void crearJugadores() {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		for(int i=0;i<Constantes.NUM_JUGADORES;i++) {
			jugadores[i]=PlayerType.ELFO;
		}
		Juego j = new Juego(jugadores);
		
		assertEquals("El jugador 1 es un ELFO El jugador 2 es un ELFO El jugador 3 es un ELFO El jugador 4 es un ELFO ", j.imprimeNombreJugadores());
	
	}
	
	@Test
	public void valorDado() {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		for(int i=0;i<Constantes.NUM_JUGADORES;i++) {
			jugadores[i]=PlayerType.ELFO;
		}
		Juego j = new Juego(jugadores);
		j.setDado();
	
		for(int i=0;i<20;i++) {
			assertTrue(j.getValorDado()<= Constantes.ELFO_VELOCIDAD&& j.getValorDado()>0);
			
		}
		
	}
	
	@Test
	public void decrementarDado() {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		for(int i=0;i<Constantes.NUM_JUGADORES;i++) {
			jugadores[i]=PlayerType.ELFO;
		}
		Juego j = new Juego(jugadores);
		j.setDado();
		int valorDado = j.getValorDado();
		j.decrementaDado();
		assertEquals(valorDado-1, j.getValorDado());
		
	}
	
	@Test
	public void proximoJugador() {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		jugadores[0]=PlayerType.ELFO;
		jugadores[1]=PlayerType.MAGO;
		jugadores[2]=PlayerType.ELFO;
		jugadores[3]=PlayerType.ELFO;
		
		Juego j = new Juego(jugadores);
		j.proximoJugador();
		
		
		assertEquals("MAGO", j.getNombreJuegadorQueJuega());
		
	}
	public void proximoJugadorReinicio() {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		jugadores[0]=PlayerType.ELFO;
		jugadores[1]=PlayerType.MAGO;
		jugadores[2]=PlayerType.MAGO;
		jugadores[3]=PlayerType.MAGO;
		
		Juego j = new Juego(jugadores);
		for(int i=0;i<Constantes.NUM_JUGADORES-1;i++) {
			j.proximoJugador();
		}
		
		
		
		assertEquals("ELFO", j.getNombreJuegadorQueJuega());
		
	}
	@Test
	public void partidaTerminada() throws JugadorException {//No se como comprobarlo
		PlayerType[]jugadores = new PlayerType[1];
		
		jugadores[0]=PlayerType.MAGO;
		
		
		Juego j = new Juego(jugadores);
		
		assertTrue(j.isTerminado());
		
	}
	/*
	 * partida no terminada
	 */
	
	@Test
	public void partidaNoTerminada() throws JugadorException {//No se como comprobarlo
		PlayerType[]jugadores = new PlayerType[2];
		
		jugadores[0]=PlayerType.MAGO;
		jugadores[1]=PlayerType.MAGO;
		
		Juego j = new Juego(jugadores);
		
		assertFalse(j.isTerminado());
		
	}
	//Partida ganada con dinero
	@Test
	public void partidaTerminadaDinero() throws JugadorException {//No se como comprobarlo
		PlayerType[]jugadores = new PlayerType[2];
		
		jugadores[0]=PlayerType.MAGO;
		jugadores[1]=PlayerType.MAGO;
		
		Juego j = new Juego(jugadores);
		Coordenada c = j.obtenerCoordenadaJugadorJuega();
		Jugador participante =(Jugador) j.obtenerElementoTablero(c);
		participante.setDinero(Constantes.NUM_DINERO);
		
		assertTrue(j.isTerminado());
		
	}
	
	//MOVER PLAYER N
	
	@Test
	public void moverN() throws JugadorException, JuegoException {
		PlayerType[]jugadores = new PlayerType[2];
		
		jugadores[0]=PlayerType.MAGO;
		jugadores[1]=PlayerType.MAGO;
		for(int i=0;i<10;i++) {
			Juego j = new Juego(jugadores);
			
			Coordenada c =j.obtenerCoordenadaJugadorJuega();
			if(c.getY()!=0) {
				j.movePlayer('N');
				c.goUp();
				assertEquals(c, j.obtenerCoordenadaJugadorJuega());
			}
		}
		
		
	}
	
	//MOVER PLAYER S
	
	@Test
	public void moverS() throws JugadorException, JuegoException {//No se como comprobarlo
		PlayerType[]jugadores = new PlayerType[2];
		
		jugadores[0]=PlayerType.MAGO;
		jugadores[1]=PlayerType.MAGO;
		for(int i=0;i<10;i++) {
			Juego j = new Juego(jugadores);
			
			Coordenada c =j.obtenerCoordenadaJugadorJuega();
			if(c.getY()!=9) {
				j.movePlayer('S');
				c.goDown();
				assertEquals(c, j.obtenerCoordenadaJugadorJuega());
			}
		}
		
	}
	
	//MOVER PLAYER E
	
		@Test
		public void moverE() throws JugadorException, JuegoException {//No se como comprobarlo
			PlayerType[]jugadores = new PlayerType[2];
			
			jugadores[0]=PlayerType.MAGO;
			jugadores[1]=PlayerType.MAGO;
			for(int i=0;i<10;i++) {
				Juego j = new Juego(jugadores);
				
				Coordenada c =j.obtenerCoordenadaJugadorJuega();
				if(c.getX()!=9) {
					j.movePlayer('E');
					c.goRight();
					assertEquals(c, j.obtenerCoordenadaJugadorJuega());
				}
			}
			
		}
		
		//MOVER PLAYER O
		
		@Test
		public void moverO() throws JugadorException, JuegoException {//No se como comprobarlo
			PlayerType[]jugadores = new PlayerType[2];
			
			jugadores[0]=PlayerType.MAGO;
			jugadores[1]=PlayerType.MAGO;
			for(int i=0;i<10;i++) {
				Juego j = new Juego(jugadores);
				
				Coordenada c =j.obtenerCoordenadaJugadorJuega();
				if(c.getX()!=0) {
					j.movePlayer('O');
					c.goLeft();
					assertEquals(c, j.obtenerCoordenadaJugadorJuega());
				}
			}
			
		}
		
		//MOVER PLAYER Mal
		
				@Test
				public void moverError() throws JugadorException {//No se como comprobarlo
					PlayerType[]jugadores = new PlayerType[2];
					
					jugadores[0]=PlayerType.MAGO;
					jugadores[1]=PlayerType.MAGO;
					
					Juego j = new Juego(jugadores);
						
					Coordenada c =j.obtenerCoordenadaJugadorJuega();
						
					try {
						j.movePlayer('J');
						fail("Tendria que saltar una exception");
					} catch (JuegoException e) {
						
						System.out.println("Parametro de movimiento no contemplado");
					
					
					
				}
				}
}
