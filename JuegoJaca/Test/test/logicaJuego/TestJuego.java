package test.logicaJuego;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;
import logicaJuego.Juego;

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
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES];
		
		jugadores[0]=null;
		jugadores[1]=null;
		jugadores[2]=null;
		jugadores[3]=PlayerType.MAGO;
		
		Juego j = new Juego(jugadores);
		
		assertTrue(j.isTerminado());//No se acumula el dinero
		
	}
	//No se como comprobar obtenerElementoTablero y obtenerCoordenadaJugadorJuega

}
