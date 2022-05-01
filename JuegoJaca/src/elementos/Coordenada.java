package elementos;

import java.util.Objects;
import java.util.Random;

import logicaJuego.Constantes;



public class Coordenada {
	private int x;
	private int y;
	private Random r;
	
	
	public Coordenada() {
		super();
		this.generarCoordenadaX();
		this.generarCoordenadaY();
	}
	public Coordenada(int x, int y) throws CoordenadaException {
		super();
		this.setX(x);
		this.setY(y);
	}
	
	private void generarCoordenadaX() {
		int coordenadaX; 
		r = new Random();
		coordenadaX= r.nextInt(0,Constantes.TAMANNO);
		this.x= coordenadaX;
	}
	
	private void generarCoordenadaY() {
		int coordenadaY; 
		r = new Random();
		coordenadaY= r.nextInt(0,Constantes.TAMANNO);
		this.y= coordenadaY;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	private void setX(int x) throws CoordenadaException {
		if(x<0||x>9) {
			throw new CoordenadaException("La coordenada x no puede ser menor a 0 o meyor a 9");
		}
		this.x = x;
	}
	private void setY(int y) throws CoordenadaException {
		if(y<0||y>9) {
			throw new CoordenadaException("La coordenada y no puede ser menor a 0 o meyor a 9");
		}
		this.y = y;
	}
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		return x == other.x && y == other.y;
	}
	@Override
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
	}
	
	public boolean goRight() {
		boolean movimiento = false;
		if(this.x+1<Constantes.TAMANNO) {
			this.x+=1;
			movimiento= true;
		}
		return movimiento;
	}
	
	public boolean goLeft() {
		boolean movimiento = false;
		if(this.x!=1) {
			this.x-=1;
			movimiento= true;
		}
		return movimiento;
		
	}
	
	public boolean goUp() {
		boolean movimiento = false;
		if(this.y!=1) {
			this.y-=1;
			movimiento= true;
		}
		return movimiento;
	}
	
	public boolean goDown() {
		boolean movimiento = false;
		if(this.y+1<Constantes.TAMANNO) {
			this.y+=1;
			movimiento= true;
		}
		return movimiento;
	}
	
	public Coordenada clone() {
		Coordenada c = null;
		try {
			c = new Coordenada(this.x,this.y);
			
		} catch (CoordenadaException e) {
			System.out.println("Error al clonar la coordenada");
		}
		return c;
		
	}
}
