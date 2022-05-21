package elementos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import logicaJuego.Constantes;
import logicaJuego.Juego;
import logicaJuego.JuegoException;

public class Pruebas {

	public static void main(String[] args) throws JuegoException, JugadorException {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		for(int i=0;i<Constantes.NUM_JUGADORES;i++) {
			jugadores[i]=PlayerType.ELFO;
		}
		Juego j = new Juego(jugadores);
		System.out.println(j.obtenerCoordenadaJugadorJuega());
		j.movePlayer('N');
		System.out.println(j.obtenerCoordenadaJugadorJuega());
		
		
	}

}
