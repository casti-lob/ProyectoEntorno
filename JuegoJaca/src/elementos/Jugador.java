package elementos;

import java.util.Random;

import logicaJuego.Constantes;

public class Jugador extends Element {
	private int dinero;
	private int pocion;
	private int gemas;
	private PlayerType player;
	private Random r;
	
	public Jugador(PlayerType player) {
		super(ElementType.valueOf(player.name()));
		this.player = player;
		this.dinero=0;
		this.pocion=0;
		this.gemas=0;
		
	}
	
	public String getNombre() {
		return player.name();
	}
	
	public int getFuerzaParaLuchar() {
		r = new Random();
		return r.nextInt(player.getFuerza());
	}
	private int getFuerza() {//Pide el metodo la documentación
		return player.getFuerza();
	}
	private int getMagia() {//Pide el metodo la documentación
		return player.getMagia();
	}
	public int getMagiaParaLuchar() {
		r= new Random();
		return r.nextInt(player.getMagia());
	}
	private int getVelocidad() {//Pide el metodo la documentación
		return player.getVelocidad();
	}
	public int getVelocidadParaLuchar() {
		r = new Random();
		return r.nextInt(player.getVelocidad()-1)+1;
		
	}

	public int getDinero() {
		return this.dinero;
	}
	
	public void setDinero(int dinero) throws JugadorException {
		if(dinero>Constantes.NUM_DINERO) {
			throw new JugadorException("Esa cantidad de dinero es mayor al maximo");
		}
		this.dinero += dinero;
	}
	
	public int getPociones() {
		return this.pocion;
	}
	public void setPociones(int pocion) throws JugadorException {
		if(pocion>Constantes.NUM_POCIONES) {
			throw new JugadorException("Esa cantidad de pociones es mayor al maximo");
		}
		this.pocion+=pocion;
	}
	
	public int getGemas() {
		return this.gemas;
	}
	
	public void setGemas(int gema) throws JugadorException {
		if(gema > Constantes.NUM_GEMAS) {
			throw new JugadorException("Esa cantidad de gemas es mayor al maximo");
		}
		this.gemas+=gema;
	}
	
	public String resume() {
		return player+ "dinero= "+dinero+"pociones= "+pocion+"gemas= "+gemas;
	}
	
	public PlayerType getPlayer() {
		return player;
	}
	
	public int lucha(Jugador enemigo) throws JugadorException { //Revisar 
		int resultado=0;
		int fuerzaJugador= getFuerzaParaLuchar();
		int fuerzaEnemigo= enemigo.getFuerzaParaLuchar();
		
		
		
		if(fuerzaJugador==fuerzaEnemigo) {
			resultado=Constantes.EMPATE;
			
		}else if(fuerzaJugador>fuerzaEnemigo&& enemigo.getPociones()>0) {
			resultado = Constantes.GANA_USA_POCIMA;
			enemigo.setPociones(-1);
		}else if(fuerzaJugador>fuerzaEnemigo&& enemigo.getDinero()>0) {
			resultado =Constantes.GANA_DINERO;
			enemigo.setDinero(-getDinero());
		}else if(fuerzaJugador<fuerzaEnemigo&&getPociones()>0) {
			resultado=Constantes.PIERDE_USA_POCIMA;
			this.setPociones(-1);
		}else if(fuerzaJugador<fuerzaEnemigo&& getDinero()>0) {
			resultado= Constantes.PIERDE_DINERO;
			this.setDinero(-getDinero());
			
		}else if(fuerzaJugador>fuerzaEnemigo) {
			resultado= Constantes.GANA_MUERE;
		
		}else {
			resultado= Constantes.PIERDE_MUERE;
			
		}
		
		return resultado;
	}
	
	public int encuentraRoca() throws JugadorException {
		int resultado=0;
		if(getGemas()>0) {
			resultado= Constantes.ROMPE_ROCA_CON_GEMA;
			setGemas(-1);
			//No se como colocar al jugador en la posiciďż˝n de la roca
		}else if(getMagiaParaLuchar()>4) {
			resultado= Constantes.GANA_A_LA_ROCA;
		}else {
			resultado= Constantes.PIERDE_A_LA_ROCA;
		}
		return resultado;
	}
	
	public void encuentraDinero() throws JugadorException {
		if(this.dinero>=Constantes.NUM_DINERO) {
			throw  new JugadorException("Ya a acumulado todo el dinero");
		}
		setDinero(1);
	}
	
	public void encuentraPocion() throws JugadorException {
		if(this.pocion>=Constantes.NUM_POCIONES) {
			throw new JugadorException("Ya a acumulado todas las pociones");
		}
		setPociones(1);
	}
	
	public void encuentraGema() throws JugadorException {
		if(this.gemas>=Constantes.NUM_GEMAS) {
			throw new JugadorException("Ya a acumulado todas las gemas");
		}
		setGemas(1);
	}
}
