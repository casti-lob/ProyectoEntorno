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
	public Coordenada(int x, int y) {
		super();
		this.setX(x);
		this.setY(y);
	}
	
	private void generarCoordenadaX() {
		int coordenadaX; 
		r = new Random();
		coordenadaX= r.nextInt(Constantes.TAMANNO);
		this.x= coordenadaX;
	}
	
	private void generarCoordenadaY() {
		int coordenadaY; 
		r = new Random();
		coordenadaY= r.nextInt(Constantes.TAMANNO);
		this.y= coordenadaY;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	private void setX(int x) {//Modificar junit
		if(x<0||x>Constantes.TAMANNO-1) {
			x=0;
		}
		this.x = x;
	}
	private void setY(int y) { //Modificar junit
		if(y<0||y>Constantes.TAMANNO-1) {
			y=0;
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
		if(this.x<Constantes.TAMANNO-1) {
			this.x+=1;
			movimiento= true;
		}
		return movimiento;
	}
	
	public boolean goLeft() {
		boolean movimiento = false;
		if(this.x!=0) {
			this.x-=1;
			movimiento= true;
		}
		return movimiento;
		
	}
	
	public boolean goUp() {
		boolean movimiento = false;
		if(this.y!=0) {
			this.y-=1;
			movimiento= true;
		}
		return movimiento;
	}
	
	public boolean goDown() {
		boolean movimiento = false;
		if(this.y<Constantes.TAMANNO-1) {
			this.y+=1;
			movimiento= true;
		}
		return movimiento;
	}
	
	
}
