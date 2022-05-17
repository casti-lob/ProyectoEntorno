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

	public Juego(PlayerType[] jugadores) {//Preguntar por la exception
		super();
		tablero= new HashMap<>();
		coordenadaJugadores = new ArrayList<>();
		crearTablero();
		for(int i=0;i< Constantes.NUM_JUGADORES;i++){
			crearJugador(jugadores[i]);
		}
		
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
			while(tablero.containsKey(c)) {
				c=new Coordenada();
			}
			Element r = new Element(ElementType.ROCA);
			tablero.put(c, r); 
		}
	}
	
	private boolean crearJugador(PlayerType type) {
		boolean creado = false;
		Jugador j = new Jugador(type);
		Coordenada c =new Coordenada();
		while(coordenadaJugadores.contains(c)&& tablero.containsKey(c)) {//Copruebo si ya esta ocupado la coordenada
			c =new Coordenada();
		}
		coordenadaJugadores.add(c);
		tablero.put(c, j);
		creado = true;
		return creado;
	}
	
	private void crearGemas() {
		for(int i =0;i<Constantes.NUM_GEMAS;i++) {
			Coordenada c = new Coordenada();
			while(tablero.containsKey(c)) {
				c=new Coordenada();
			}
			Element r = new Element(ElementType.GEMA);
			tablero.put(c, r); 
		}
	}
	
	private void crearPociones() {
		for(int i =0;i<Constantes.NUM_POCIONES;i++) {
			Coordenada c = new Coordenada();
			while(tablero.containsKey(c)) {
				c=new Coordenada();
			}
			Element r = new Element(ElementType.POCION);
			tablero.put(c, r); 
		}
	}
	
	private void crearDinero() {
		for(int i =0;i<Constantes.NUM_DINERO;i++) {
			Coordenada c = new Coordenada();
			while(tablero.containsKey(c)) {
				c=new Coordenada();
			}
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
		if(coordenadaJugadores.size()==1) {
			terminado= true;
		}
		for(Coordenada i:coordenadaJugadores) {
			if(tablero.get(i) != null) {
				Jugador j = (Jugador) this.tablero.get(i);
				if(j.getDinero()== Constantes.NUM_DINERO) {
					terminado= true;
				}
			}
		}
		return terminado;
	}
	
	public String imprimeNombreJugadores() {
		StringBuilder nombres= new StringBuilder();
		int contador =0;
		for(Coordenada i:coordenadaJugadores) {
			if(tablero.containsKey(i)) {
				contador+=1;
				Jugador j = (Jugador) tablero.get(i);
				nombres.append("El jugador "+contador+" es un "+j.getNombre()+" ");
			}
		}
		return nombres.toString();
	}
	
	public String imprimeValoreJugadores() {
		StringBuilder valores= new StringBuilder();
		
		for(Coordenada i:coordenadaJugadores) {
			if(tablero.containsKey(i)) {
				
				Jugador j = (Jugador) tablero.get(i);
				valores.append(j.getNombre()+" ");
			}
		}
		return valores.toString();
	}
	
	private void eliminarJugador(Coordenada coord) {
		coordenadaJugadores.remove(coord);
		tablero.remove(coord);
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
	private Coordenada getNextPosition (char direccion) throws JuegoException {
		Coordenada c = coordenadaJugadores.get(jugadorJuega);
		Coordenada nueva = c.clone();
		Coordenada nextPosition;
		if(direccion!='N'&& direccion!='S'&& direccion!='E'&& direccion!='O') {
			throw new JuegoException("No se aceptan estos valores");
		}
		
		switch (direccion) {
		case 'N': {
			nueva.goUp();
			break;
		}case 'S': {
			nueva.goDown();
			break;
		}case 'E': {
			nueva.goRight();
			break;
		}case 'O': {
			nueva.goLeft();
			break;
		}
		default:
			throw new JuegoException("Error inesperado");
		}
		if(nueva.getX()==0&&nueva.getY()==0) {
			nextPosition=c;
		}else {
			nextPosition=nueva;
		}
		return nextPosition;
	}
//Preguntar en que momento hay que invocar
	private void cambiaJugadorAPosicion(Coordenada coord) {
		Coordenada c = coordenadaJugadores.get(jugadorJuega);//Sacamos la coordenada del jugador
		coordenadaJugadores.remove(jugadorJuega);//Eliminamos la coordenada del jugador
		coordenadaJugadores.add(jugadorJuega, coord);//Colocamos la nueva coordenada del jugador en su misma posici�n
		Jugador j = (Jugador) tablero.get(c);//Obtenemos el jugador del mapa
		tablero.remove(c);//Eliminamos el registro del mapa
		tablero.put(coord, j);//Introducimos el jugador con la nueva coordenada
		
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

	public void proximoJugador() {
		if(this.jugadorJuega== coordenadaJugadores.size()-1) {
			jugadorJuega=0;
		}else {
			jugadorJuega+=1;
		}
	}
	
	public String getGanador() {
		String ganador="";
		Jugador j ;
		if(coordenadaJugadores.size()==1) {
			Coordenada c = coordenadaJugadores.get(0);
			j = (Jugador) tablero.get(c);
			ganador = j.resume();
		}
		for(Coordenada i: coordenadaJugadores) {
			j= (Jugador) tablero.get(i);
			if(j.getDinero()==Constantes.NUM_DINERO) {
				ganador=j.resume();
			}
		}
		return ganador;
	}
	public String getNombreJuegadorQueJuega() {
		Coordenada c = coordenadaJugadores.get(jugadorJuega);
		Jugador j = (Jugador) tablero.get(c);
		return j.getNombre();
	}
	
	public int getMovimientoJugador(){//Puede que se tenga que generar velocidad
		Coordenada c = coordenadaJugadores.get(jugadorJuega);
		Jugador j = (Jugador) tablero.get(c);
		return j.getVelocidadParaLuchar();
	}
	
	public int getValorDado() {
		return dado;
	}
	
	public void decrementaDado() {
		this.dado -=1;
	}
	
	public void setDado() {
		Coordenada c = coordenadaJugadores.get(jugadorJuega);
		Jugador j = (Jugador) tablero.get(c);
		this.dado = j.getVelocidadParaLuchar();
	}
	
	public Element obtenerElementoTablero(Coordenada coord) {
		return tablero.get(coord);
	}
	
	public Coordenada obtenerCoordenadaJugadorJuega() {
		return coordenadaJugadores.get(jugadorJuega);
	}
}
