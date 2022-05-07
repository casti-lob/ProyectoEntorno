package logicaJuego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import elementos.*;

public class Juego {

	private HashMap<Coordenada, Element> tablero;
	private ArrayList<Coordenada> coordenadaJugadores;
	private int jugadorJuega;
	private int dado; // Dado para ver los movimientos del jugador que juega
	private Jugador[] jugadores =new Jugador[Constantes.NUM_JUGADORES];

	public Juego(Jugador[] jugadores) {//Preguntar por la exception
		super();
		this.jugadores = jugadores;
	}
	
	private void crearTablero() {//preguntar
		crearDinero();
		crearGemas();
		crearPociones();
		crearRocas();
	}
	
	private void crearRocas() {
		for(int i =0;i<Constantes.NUM_ROCAS;i++) {
			Coordenada c = new Coordenada();
			Element r = new Element(ElementType.ROCA);
			tablero.put(c, r); 
		}
	}
	
	private boolean crearJugador(PlayerType type) {
		boolean creado = false;
		Jugador j = new Jugador(type);
		for(int i=0;i<jugadores.length&&!creado;i++) {
			if(jugadores[i]==null) {
				jugadores[i]=j;
				creado= true;
			}
		}
		return creado;
	}
	
	private void crearGemas() {
		for(int i =0;i<Constantes.NUM_GEMAS;i++) {
			Coordenada c = new Coordenada();
			Element r = new Element(ElementType.GEMA);
			tablero.put(c, r); 
		}
	}
	
	private void crearPociones() {
		for(int i =0;i<Constantes.NUM_POCIONES;i++) {
			Coordenada c = new Coordenada();
			Element r = new Element(ElementType.POCION);
			tablero.put(c, r); 
		}
	}
	
	private void crearDinero() {
		for(int i =0;i<Constantes.NUM_DINERO;i++) {
			Coordenada c = new Coordenada();
			Element r = new Element(ElementType.DINERO);
			tablero.put(c, r); 
		}
	}
	
	
	

	/**
	 * Escribe el tablero en formato no gráfico. Devuelve el string con la
	 * información
	 */
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		resul.append(barra());
		resul.append("     |");

		for (int fila = 0; fila < Constantes.TAMANNO; fila++) {
			for (int columna = 0; columna < Constantes.TAMANNO; columna++) {
				Coordenada coor = new Coordenada(columna, fila);

				if (this.tablero.get(coor) != null) {
					resul.append(" " + this.tablero.get(coor).getType().getSymbol() + " ");
				} else {
					resul.append("   ");
				}

				resul.append("|");
			}
			resul.append("\n");
			resul.append(barra());
			resul.append("     |");
		}
		resul.delete(resul.length() - 5, resul.length());
		return resul.toString();
	}

	public boolean isTerminado() {
		boolean terminado= false;
		int numeroJugadores= Constantes.NUM_JUGADORES;
		for(int i=0;i<jugadores.length&&!terminado;i++) {
			if(jugadores[i].getDinero()==Constantes.NUM_DINERO) {
				terminado= true;
			}else if(jugadores[i]==null) {
				numeroJugadores-=1;//Si se ha eliminado al jugador se resta para saber cuantos jugadores estan en activo
			}
		}
		if(numeroJugadores==1) {
			terminado= true;
		}
		return terminado;
	}
	
	public String imprimeNombreJugadores() {
		StringBuilder nombres= new StringBuilder();
		for(int i =0;i<jugadores.length;i++) {
			if(jugadores[i]!=null) {
				nombres.append("El jugador "+i+"es un "+jugadores[i].getType()+" ");
			}
		}
		return nombres.toString();
	}
	
	public String imprimeValoreJugadores() {
		StringBuilder nombres= new StringBuilder();
		for(int i =0;i<jugadores.length;i++) {
			if(jugadores[i]!=null) {
				nombres.append("El jugador "+i+"es un "+jugadores[i].resume()+" ");
			}
		}
		return nombres.toString();
	}
	
	private void eliminarJugador(Coordenada coord) {//P�r hacer
		
	}
	
	/**
	 * Simplemente escribe una barra en pantalla
	 * 
	 * @return
	 */
	private String barra() {
		StringBuilder resul = new StringBuilder();
		resul.append("     ");
		for (int i = 0; i < Constantes.TAMANNO * 4; i++) {
			resul.append("-");
		}
		resul.append("\n");
		return resul.toString();
	}
	private Coordenada getNextPositionCoordenada (char direccion) throws JuegoException {
		Coordenada c;
		if(direccion!='N'&& direccion!='S'&& direccion!='E'&& direccion!='O') {
			throw new JuegoException("No se aceptan estos valores");
		}
		
		switch (direccion) {
		case 'N': {
			c = ne
			breack;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + direccion);
		}
	}

	/**
	 * Mover el jugador
	 * 
	 * @param direction
	 * @return
	 * @throws JuegoException
	 * @throws JugadorException
	 */
	public String movePlayer(char direction) throws JuegoException, JugadorException {
		// Si no es una dirección válida, mando un exception
		String resul = "";
		Jugador jugador = (Jugador) this.tablero.get(this.coordenadaJugadores.get(jugadorJuega));

		Coordenada coordDestino = getNextPosition(direction);

		// Tengo que ver que hay en la nueva casilla
		Element elemento = this.tablero.get(coordDestino);

		if (elemento != null) { // Hay algo en la casilla
			if (elemento instanceof Jugador) {

				Jugador enemigo = (Jugador) elemento;
				int resultadoLucha = jugador.lucha(enemigo);
				switch (resultadoLucha) {
				case Constantes.EMPATE:
					resul = "Empate entre los jugadore";
					break;
				case Constantes.GANA_USA_POCIMA:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una pócima al enemigo";
					break;
				case Constantes.GANA_DINERO:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita el dinero al enemigo";
					break;
				case Constantes.GANA_MUERE:
					resul = "El jugador " + jugador.getNombre() + " gana. El enemigo muere";
					this.eliminarJugador(coordDestino);
					// Si se elimina el jugador que juega el dado se pone a 0 para que no siga
					// tirando
					break;
				case Constantes.PIERDE_USA_POCIMA:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una pócima al jugador";
					break;
				case Constantes.PIERDE_DINERO:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita el dinero al jugador";
					break;
				case Constantes.PIERDE_MUERE:
					resul = "El enemigo " + enemigo.getNombre() + " gana. El jugador muere";
					this.eliminarJugador(this.coordenadaJugadores.get(jugadorJuega));
					dado = 0;
					// Decrementamos en uno el jugador, para que no se salte al siguiente
					// ya que al borrarlo el siguiente apunta al siguiente, y al incrementarlo
					// se le salta
					this.jugadorJuega--;
					break;
				}
				// Después de la lucha los jugadores no se mueven
			} else if (elemento.getType() == ElementType.ROCA) {
				int resultadoRoca = jugador.encuentraRoca();
				switch (resultadoRoca) {
				case Constantes.ROMPE_ROCA_CON_GEMA:
					resul = "El jugador " + jugador.getNombre() + " rompe la roca con una gema";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.GANA_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " gana a la roca";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.PIERDE_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " pierde. No se mueve";
					break;
				}
			} else if (elemento.getType() == ElementType.GEMA) {
				jugador.encuentraGema();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.DINERO) {
				jugador.encuentraDinero();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.POCION) {
				jugador.encuentraPocion();
				this.cambiaJugadorAPosicion(coordDestino);

			}

		} else {
			this.cambiaJugadorAPosicion(coordDestino);
		}

		return resul;
	}

	
}
