import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TableroMinasTest {

	@Test

	void testDistribuirMinas() {
		TableroMinas tablero1 = new TableroMinas(10,10,0); // Loop testing valor 0
		tablero1.setGeneradorAleatorio(new GeneradorAleatorio());
		tablero1.DistribuirMinas();
		
		TableroMinas tablero2 = new TableroMinas(5,5,1); // Loop testing valor 1
		tablero2.setGeneradorAleatorio(new GeneradorAleatorio());
		tablero2.DistribuirMinas();
		
		TableroMinas tablero3 = new TableroMinas(5,5,2); // Loop testing valor 2
		tablero3.setGeneradorAleatorio(new GeneradorAleatorio());
		tablero3.DistribuirMinas();
		
		TableroMinas tablero4 = new TableroMinas(5,5,12); // Loop testing valor 50 (habitual)
		tablero4.setGeneradorAleatorio(new GeneradorAleatorio());
		tablero4.DistribuirMinas();
		
		TableroMinas tablero5 = new TableroMinas(5,5,24); // Loop testing valor MAXIM-1
		tablero5.setGeneradorAleatorio(new GeneradorAleatorio());
		tablero5.DistribuirMinas();
		
		TableroMinas tablero6 = new TableroMinas(5,5,25); // Loop testing valor MAXIM
		tablero6.setGeneradorAleatorio(new GeneradorAleatorio());
		tablero6.DistribuirMinas();
	}
	
	
	@Test

	void testDistribuirPuntuacion() {
		
		//Creacion del objeto MOCK OBJECT
		MockGeneradorAleatorio mockGen = new MockGeneradorAleatorio();
		
		TableroMinas tablero1 = new TableroMinas(4,3,3);
		
		//asignacion de la opcion que se va a utilizar dentro del objecto Mock
		mockGen.setOpcion(1);
		//asignacion de del objeto MockGeneradorAleatorio a la clase tablero minas
		//la cual utilizara la llamada GetNumeroAleatorio de la clase MOCK
		tablero1.setGeneradorAleatorio(mockGen);
		tablero1.IniciarTablero();
		int[][] mResultado1 = new int[][]{{1,1,2,9}, {2,9,2,1}, {9,2,1,0}};
		assertArrayEquals(mResultado1, tablero1.getTablero());// Statement coverage
		/*
		TableroMinas tablero2 = new TableroMinas(2,3,3);
		//int[][] matriz2 = new int[][] {{0,0},{9,0},{9,9}};
		mockGen.setOpcion(2);
		tablero2.setGeneradorAleatorio(mockGen);
		tablero2.DistribuirMinas();
		tablero2.DistribuirPuntuacion();	
		int[][] mResultado2 = new int[][]{{1,1},{9,3},{9,9}};
		assertArrayEquals(mResultado2, tablero2.getTablero());*/
		
		
		/*TableroMinas tablero3 = new TableroMinas(3,3,0);
		//int[][] matriz2 = new int[][] {{0,0,0},{0,0,0},{0,0,0}};
		mockGen.setOpcion(3);
		tablero3.setGeneradorAleatorio(mockGen);
		tablero3.DistribuirMinas();
		tablero3.DistribuirPuntuacion();	
		int[][] mResultado3 = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
		assertArrayEquals(mResultado3, tablero3.getTablero());*/
		
		/*TableroMinas tablero4 = new TableroMinas(3,3,8);
		//int[][] matriz4 = new int[][] {{9,9,9},{9,0,9},{9,9,9}};
		mockGen.setOpcion(4);
		tablero4.setGeneradorAleatorio(mockGen);
		tablero4.DistribuirMinas();
		tablero4.DistribuirPuntuacion();	
		int[][] mResultado4 = new int[][]{{9,9,9},{9,8,9},{9,9,9}};
		assertArrayEquals(mResultado4, tablero4.getTablero());*/
	}

}
