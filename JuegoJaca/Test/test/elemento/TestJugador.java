package test.elemento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;

class TestJugador {

	@Test
	void fuerzaParaLucharElfo() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.ELFO);
			assertTrue(j.getFuerzaParaLuchar()>=0&&j.getFuerzaParaLuchar()<=Constantes.ELFO_FUERZA);
		}
		
	}
	
	@Test
	void fuerzaParaLucharGuerrero() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.GUERRERO);
			assertTrue(j.getFuerzaParaLuchar()>=0&&j.getFuerzaParaLuchar()<=Constantes.GUERRERO_FUERZA);
		}
		
	}
	
	@Test
	void fuerzaParaLucharMago() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.MAGO);
			assertTrue(j.getFuerzaParaLuchar()>=0&&j.getFuerzaParaLuchar()<=Constantes.MAGO_FUERZA);
		}
		
	}
	
	@Test
	void fuerzaParaLucharOgro() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.OGRO);
			assertTrue(j.getFuerzaParaLuchar()>=0&&j.getFuerzaParaLuchar()<=Constantes.OGRO_FUERZA);
		}
		
	}
	
	@Test
	void magiaParaLucharElfo() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.ELFO);
			assertTrue(j.getMagiaParaLuchar()>=0&&j.getMagiaParaLuchar()<=Constantes.ELFO_MAGIA);
		}
		
	}
	
	@Test
	void magiaParaLucharGuerrero() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.GUERRERO);
			assertTrue(j.getMagiaParaLuchar()>=0&&j.getMagiaParaLuchar()<=Constantes.GUERRERO_MAGIA);
		}
		
	}
	
	@Test
	void magiaParaLucharMago() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.MAGO);
			assertTrue(j.getMagiaParaLuchar()>=0&&j.getMagiaParaLuchar()<=Constantes.MAGO_MAGIA);
		}
		
	}
	
	@Test
	void magiaParaLucharOgro() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.OGRO);
			assertTrue(j.getMagiaParaLuchar()>=0&&j.getMagiaParaLuchar()<=Constantes.OGRO_MAGIA);
		}
		
	}
	
	@Test
	void velocidadParaLucharElfo() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.ELFO);
			assertTrue(j.getVelocidadParaLuchar()>=0&&j.getVelocidadParaLuchar()<=Constantes.ELFO_VELOCIDAD);
		}
		
	}
	
	@Test
	void velocidadParaLucharGuerrero() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.GUERRERO);
			assertTrue(j.getVelocidadParaLuchar()>=0&&j.getVelocidadParaLuchar()<=Constantes.GUERRERO_VELOCIDAD);
		}
		
	}
	
	@Test
	void velocidadParaLucharMago() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.MAGO);
			assertTrue(j.getVelocidadParaLuchar()>=0&&j.getVelocidadParaLuchar()<=Constantes.MAGO_VELOCIDAD);
		}
		
	}
	
	@Test
	void velocidadParaLucharOgro() {
		for(int i=0;i<20;i++) {
			Jugador j= new Jugador(PlayerType.OGRO);
			assertTrue(j.getVelocidadParaLuchar()>=0&&j.getVelocidadParaLuchar()<=Constantes.OGRO_VELOCIDAD);
		}
		
	}
	
	@Test
	void mostrarDinero() {
		Jugador j= new Jugador(PlayerType.ELFO);
		assertEquals(0, j.getDinero());
	}
	
	@Test
	void introducirDinero() {
		Jugador j= new Jugador(PlayerType.ELFO);
		try {
			j.setDinero(2);
			assertEquals(2, j.getDinero());
		} catch (JugadorException e) {
			
			
		}
	
	}
	
	@Test
	void introducirDineroFueraLimite() {
		Jugador j= new Jugador(PlayerType.ELFO);
		try {
			j.setDinero(3);
			fail("Tendria que saltar una exception");
		} catch (JugadorException e) {
			System.out.println("Error no puede ser mayor la cantidad de dinero a la constante");
		}
	}

	@Test
	void mostrarPociones() {
		Jugador j= new Jugador(PlayerType.ELFO);
		assertEquals(0, j.getPociones());
	}
	
	@Test
	void introducirPociones() {
		Jugador j= new Jugador(PlayerType.ELFO);
		try {
			j.setPociones(3);
			assertEquals(3, j.getPociones());
		} catch (JugadorException e) {
			
			
		}
	
	}
	
	@Test
	void introducirPocionesFueraLimite() {
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
	void mostrarGemas() {
		Jugador j= new Jugador(PlayerType.ELFO);
		assertEquals(0, j.getGemas());
	}
	
	@Test
	void introducirGemas() {
		Jugador j= new Jugador(PlayerType.ELFO);
		try {
			j.setGemas(5);
			assertEquals(5, j.getGemas());
		} catch (JugadorException e) {
			
			
		}
	
	}
	
	@Test
	void introducirGemasFueraLimite() {
		Jugador j= new Jugador(PlayerType.ELFO);
		try {
			j.setGemas(6);
			fail("Tendria que saltar una exception");
		} catch (JugadorException e) {
			System.out.println("Error no puede ser mayor la cantidad de gemas a la constante");
		}
	}
	
	@Test
	void lucha() {
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
	void luchaConPociones() throws JugadorException {
		
		for(int i =0;i<20;i++) {//Estan dentro del bucle para que siempre tengan 1 poción los dos
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
	void luchaConDinero() throws JugadorException {
		
		for(int i =0;i<20;i++) {//Estan dentro del bucle para que siempre tengan 1 poción los dos
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
	void rocaConGema() throws JugadorException {
		
		for(int i =0;i<20;i++) {//Estan dentro del bucle para que siempre tengan 1 poción los dos
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
	void rocaSinGema() throws JugadorException {
		
		for(int i =0;i<20;i++) {//Estan dentro del bucle para que siempre tengan 1 poción los dos
			Jugador j = new Jugador(PlayerType.OGRO);
			
			try {
				int combate =j.encuentraRoca();
				assertTrue(combate==1 || combate==2);
			} catch (Exception e) {
				
			}
		}
	}
	
	@Test
	void encuentraDinero() {
		Jugador j = new Jugador(PlayerType.OGRO);
		try {
			j.encuentraDinero();
			assertEquals(1, j.getDinero());
		} catch (JugadorException e) {
			
		}
	}
	
	@Test
	void encuentraPocion() {
		Jugador j = new Jugador(PlayerType.OGRO);
		try {
			j.encuentraProcion();
			assertEquals(1, j.getPociones());
		} catch (JugadorException e) {
			
		}
	}
	
	@Test
	void encuentraGema() {
		Jugador j = new Jugador(PlayerType.OGRO);
		try {
			j.encuentraGema();;
			assertEquals(1, j.getGemas());
		} catch (JugadorException e) {
			
		}
	}
}
