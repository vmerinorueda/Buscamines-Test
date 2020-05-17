import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuscaminasTest {

	
	@Test

	void testIndicarPosicion() {
		MockScannerEntrada mockSca = new MockScannerEntrada();

		Buscaminas buscaminas1 = new Buscaminas();
		mockSca.setConfig(20);
		buscaminas1.setScannerEntrada(mockSca);
		int[] resultado1 = new int[]{0,0};
		assertArrayEquals(buscaminas1.IndicarPosicion(),resultado1);

		Buscaminas buscaminas2 = new Buscaminas();
		mockSca.setConfig(21);
		buscaminas2.setScannerEntrada(mockSca);
		int[] resultado2 = new int[]{1,1};
		assertArrayEquals(buscaminas2.IndicarPosicion(), resultado2);

		Buscaminas buscaminas3 = new Buscaminas();
		mockSca.setConfig(22);
		buscaminas3.setScannerEntrada(mockSca);
		int[] resultado3 = new int[]{9,9};
		assertArrayEquals( buscaminas3.IndicarPosicion(), resultado3);
		
		Buscaminas buscaminas4 = new Buscaminas();
		mockSca.setConfig(23);
		buscaminas4.setScannerEntrada(mockSca);
		int[] resultado4 = new int[]{2,6};
		assertArrayEquals( buscaminas4.IndicarPosicion(), resultado4);		
	}
	
	@Test

	void testIndicarAccion() {
		MockScannerEntrada mockSca = new MockScannerEntrada();
		
		Buscaminas buscaminas1 = new Buscaminas();
		mockSca.setConfig(0);
		buscaminas1.setScannerEntrada(mockSca);
		int result1 = buscaminas1.IndicarAccion();
		assertEquals(result1, 0);
		
		Buscaminas buscaminas2 = new Buscaminas();
		mockSca.setConfig(1);
		buscaminas2.setScannerEntrada(mockSca);
		int result2 = buscaminas2.IndicarAccion();
		assertEquals(result2, 1);

		Buscaminas buscaminas3 = new Buscaminas();
		mockSca.setConfig(2);
		buscaminas3.setScannerEntrada(mockSca);
		int result3 = buscaminas3.IndicarAccion();
		assertEquals(result3, 2);
		
		Buscaminas buscaminas4 = new Buscaminas();
		mockSca.setConfig(3);
		buscaminas4.setScannerEntrada(mockSca);
		int result4 = buscaminas4.IndicarAccion();
		assertEquals(result4, 3);
	}
	
	@Test

	void testOpcionesPartida() {
		MockScannerEntrada mockSca = new MockScannerEntrada();

		Buscaminas buscaminas = new Buscaminas();
		mockSca.setConfig(30);
		buscaminas.setScannerEntrada(mockSca);
		buscaminas.OpcionesPartida();
	}
	
	@Test
	void testMenu() {
		MockScannerEntrada mockSca = new MockScannerEntrada();

		Buscaminas buscaminas = new Buscaminas();
		mockSca.setConfig(40);
		buscaminas.setScannerEntrada(mockSca);
		buscaminas.Menu();//opcion -1 erronea
		
		mockSca.setConfig(41);
		TableroMinas tableroMinas = new TableroMinas(2,2,1);
		int[][] matriz1 = new int[][]{{9,1}, {1,1}};
		tableroMinas.setTablero(matriz1);
		
		TableroJugador tj = new TableroJugador(2, 2, 2,  1,  tableroMinas);
		tj.IniciarTablero();
		buscaminas.setTableroJugador(tj);
		buscaminas.setScannerEntrada(mockSca);

		buscaminas.Menu();//opcion 1 Jugar
	}
	
	
	@Test
	void testJugar() {
		MockScannerEntrada mockSca = new MockScannerEntrada();
		mockSca.setConfig(50);
		
		TableroMinas tableroMinas = new TableroMinas(2,2,1);
		int[][] matriz1 = new int[][]{{9,1}, {1,1}};
		tableroMinas.setTablero(matriz1);
		
		TableroJugador tj = new TableroJugador(2, 2, 2,  1,  tableroMinas);
		tj.IniciarTablero();
		Buscaminas buscaminas = new Buscaminas();
		buscaminas.setTableroJugador(tj);
		buscaminas.setScannerEntrada(mockSca);

		buscaminas.Jugar();
	
		
	}
}
