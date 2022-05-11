package test.logicaJuego;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
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
	
	//No se como comprobar obtenerElementoTablero y obtenerCoordenadaJugadorJuega

}
