package elementos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import logicaJuego.Constantes;
import logicaJuego.Juego;

public class Pruebas {

	public static void main(String[] args) {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		for(int i=0;i<Constantes.NUM_JUGADORES;i++) {
			jugadores[i]=PlayerType.ELFO;
		}
		Juego j = new Juego(jugadores);
		System.out.println(j.imprimeNombreJugadores());
		
	}

}
