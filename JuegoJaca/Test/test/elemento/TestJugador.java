package test.elemento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;

class TestJugador {

	@Test
	public void fuerzaParaLucharElfo() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.ELFO);
			assertTrue(j.getFuerzaParaLuchar()>=0&&j.getFuerzaParaLuchar()<=Constantes.ELFO_FUERZA);
		}
		
	}
	
	@Test
	public void fuerzaParaLucharGuerrero() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.GUERRERO);
			assertTrue(j.getFuerzaParaLuchar()>=0&&j.getFuerzaParaLuchar()<=Constantes.GUERRERO_FUERZA);
		}
		
	}
	
	@Test
	public void fuerzaParaLucharMago() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.MAGO);
			assertTrue(j.getFuerzaParaLuchar()>=0&&j.getFuerzaParaLuchar()<=Constantes.MAGO_FUERZA);
		}
		
	}
	
	@Test
	public void fuerzaParaLucharOgro() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.OGRO);
			assertTrue(j.getFuerzaParaLuchar()>=0&&j.getFuerzaParaLuchar()<=Constantes.OGRO_FUERZA);
		}
		
	}
	
	@Test
	public void magiaParaLucharElfo() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.ELFO);
			assertTrue(j.getMagiaParaLuchar()>=0&&j.getMagiaParaLuchar()<=Constantes.ELFO_MAGIA);
		}
		
	}
	
	@Test
	public void magiaParaLucharGuerrero() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.GUERRERO);
			assertTrue(j.getMagiaParaLuchar()>=0&&j.getMagiaParaLuchar()<=Constantes.GUERRERO_MAGIA);
		}
		
	}
	
	@Test
	public void magiaParaLucharMago() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.MAGO);
			assertTrue(j.getMagiaParaLuchar()>=0&&j.getMagiaParaLuchar()<=Constantes.MAGO_MAGIA);
		}
		
	}
	
	@Test
	public void magiaParaLucharOgro() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.OGRO);
			assertTrue(j.getMagiaParaLuchar()>=0&&j.getMagiaParaLuchar()<=Constantes.OGRO_MAGIA);
		}
		
	}
	
	@Test
	public void velocidadParaLucharElfo() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.ELFO);
			assertTrue(j.getVelocidadParaLuchar()>=0&&j.getVelocidadParaLuchar()<=Constantes.ELFO_VELOCIDAD);
		}
		
	}
	
	@Test
	public void velocidadParaLucharGuerrero() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.GUERRERO);
			assertTrue(j.getVelocidadParaLuchar()>=0&&j.getVelocidadParaLuchar()<=Constantes.GUERRERO_VELOCIDAD);
		}
		
	}
	
	@Test
	public void velocidadParaLucharMago() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.MAGO);
			assertTrue(j.getVelocidadParaLuchar()>=0&&j.getVelocidadParaLuchar()<=Constantes.MAGO_VELOCIDAD);
		}
		
	}
	
	@Test
	public void velocidadParaLucharOgro() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.OGRO);
			assertTrue(j.getVelocidadParaLuchar()>=0&&j.getVelocidadParaLuchar()<=Constantes.OGRO_VELOCIDAD);
		}
		
	}
	
	@Test
	public void mostrarDinero() {
		Jugador j= new Jugador(PlayerType.ELFO);
		assertEquals(0, j.getDinero());
	}
	
	@Test
	public void introducirDinero() {
		Jugador j= new Jugador(PlayerType.ELFO);
		try {
			j.setDinero(2);
			assertEquals(2, j.getDinero());
		} catch (JugadorException e) {
			
			
		}
	
	}
	
	@Test
	public void introducirDineroFueraLimite() {
		Jugador j= new Jugador(PlayerType.ELFO);
		try {
			j.setDinero(3);
			fail("Tendria que saltar una exception");
		} catch (JugadorException e) {
			System.out.println("Error no puede ser mayor la cantidad de dinero a la constante");
		}
	}

	@Test
	public void mostrarPociones() {
		Jugador j= new Jugador(PlayerType.ELFO);
		assertEquals(0, j.getPociones());
	}
	
	@Test
	public void introducirPociones() {
		Jugador j= new Jugador(PlayerType.ELFO);
		try {
			j.setPociones(3);
			assertEquals(3, j.getPociones());
		} catch (JugadorException e) {
			
			
		}
	
	}
	
	@Test
	public void introducirPocionesFueraLimite() {
		Jugador j= new Jugador(PlayerType.ELFO);
		try {
			j.setPociones(4);
			fail("Tendria que saltar una exception");
		} catch (JugadorException e) {
			System.out.println("Error no puede ser mayor la cantidad de pociones a la constante");
		}
	}
	/*
	 * 
	 */
	@Test
	public void mostrarGemas() {
		Jugador j= new Jugador(PlayerType.ELFO);
		assertEquals(0, j.getGemas());
	}
	
	@Test
	public void introducirGemas() {
		Jugador j= new Jugador(PlayerType.ELFO);
		try {
			j.setGemas(5);
			assertEquals(5, j.getGemas());
		} catch (JugadorException e) {
			
			
		}
	
	}
	
	@Test
	public void introducirGemasFueraLimite() {
		Jugador j= new Jugador(PlayerType.ELFO);
		try {
			j.setGemas(6);
			fail("Tendria que saltar una exception");
		} catch (JugadorException e) {
			System.out.println("Error no puede ser mayor la cantidad de gemas a la constante");
		}
	}
	
	@Test
	public void lucha() {
		Jugador j = new Jugador(PlayerType.OGRO);
		Jugador enemigo = new Jugador(PlayerType.ELFO);
		for(int i =0;i<20;i++) {
			try {
				int combate =j.lucha(enemigo);
				assertTrue(combate==3 || combate==6 || combate==0);
			} catch (JugadorException e) {
				
			}
		}
	}
	
	@Test
	public void luchaConPociones() throws JugadorException {
		
		for(int i =0;i<20;i++) {//Estan dentro del bucle para que siempre tengan 1 poci�n los dos
			Jugador j = new Jugador(PlayerType.OGRO);
			Jugador enemigo = new Jugador(PlayerType.ELFO);
			j.setPociones(1);
			enemigo.setPociones(1);
			try {
				int combate =j.lucha(enemigo);
				assertTrue(combate==1 || combate==4|| combate==0);
			} catch (Exception e) {
				
			}
		}
	}
	
	@Test
	public void luchaConDinero() throws JugadorException {
		
		for(int i =0;i<20;i++) {//Estan dentro del bucle para que siempre tengan 1 poci�n los dos
			Jugador j = new Jugador(PlayerType.OGRO);
			Jugador enemigo = new Jugador(PlayerType.ELFO);
			j.setDinero(1);
			enemigo.setDinero(1);
			try {
				int combate =j.lucha(enemigo);
				assertTrue(combate==2 || combate==5|| combate==0);
			} catch (Exception e) {
				
			}
		}
	}
	
	@Test
	public void rocaConGema() throws JugadorException {
		
		for(int i =0;i<20;i++) {//Estan dentro del bucle para que siempre tengan 1 poci�n los dos
			Jugador j = new Jugador(PlayerType.OGRO);
			j.setGemas(1);
			try {
				int combate =j.encuentraRoca();
				assertTrue(combate==0 && j.getGemas()==0);
			} catch (Exception e) {
				
			}
		}
	}
	
	@Test
	public void rocaSinGema() throws JugadorException {
		
		for(int i =0;i<20;i++) {//Estan dentro del bucle para que siempre tengan 1 poci�n los dos
			Jugador j = new Jugador(PlayerType.OGRO);
			
			try {
				int combate =j.encuentraRoca();
				assertTrue(combate==1 || combate==2);
			} catch (Exception e) {
				
			}
		}
	}
	
	@Test
	public void encuentraDinero() {
		Jugador j = new Jugador(PlayerType.OGRO);
		try {
			j.encuentraDinero();
			assertEquals(1, j.getDinero());
		} catch (JugadorException e) {
		
		}
	}
	
	@Test
	public void encuentraPocion() {
		Jugador j = new Jugador(PlayerType.OGRO);
		try {
			j.encuentraPocion();
			assertEquals(1, j.getPociones());
		} catch (JugadorException e) {
			
		}
	}
	
	@Test
	public void encuentraGema() {
		Jugador j = new Jugador(PlayerType.OGRO);
		try {
			j.encuentraGema();;
			assertEquals(1, j.getGemas());
		} catch (JugadorException e) {
			
		}
	}
	
	
	@Test
	public void encuentraDineroDeMas() {
		Jugador j = new Jugador(PlayerType.OGRO);
		try {
			for(int i=0;i<Constantes.NUM_DINERO+1;i++) {
				j.encuentraDinero();
			}
			
			fail("Tendria que saltar un error");
		} catch (JugadorException e) {
			System.out.println("Limite de dinero alcanzado");
		}
	}
	
	@Test
	public void encuentraPocionDeMas() {
		Jugador j = new Jugador(PlayerType.OGRO);
		try {
			for(int i=0;i<Constantes.NUM_POCIONES+1;i++) {
				j.encuentraPocion();
			}
			
			fail("Tendria que saltar un error");
		} catch (JugadorException e) {
			System.out.println("Limite de pociones alcanzado");
		}
	}
	
	@Test
	public void encuentraGemaDeMas() {
		Jugador j = new Jugador(PlayerType.OGRO);
		try {
			for(int i=0;i<Constantes.NUM_GEMAS+1;i++) {
				j.encuentraGema();
			}
		
			fail("Tendria que saltar un error");
		} catch (JugadorException e) {
			System.out.println("Limite de gemas alcanzado");
		}
	}
}
