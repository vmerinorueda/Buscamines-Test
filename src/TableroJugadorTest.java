import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableroJugadorTest {

	@Test
	void testComprobarTablero() {
		TableroJugador tablero1 ;
		tablero1  = new TableroJugador(4,3,3,4);

		//PARTIDA NO FINALIZADA
		int[][] matriz1 = new int[][]{{11,4,10,11}, {11,11,11,11}, {11,3,11,8}};
		tablero1.setTablero(matriz1);
		assertEquals(false, tablero1.ComprobarTablero());
		
		//PARTIDA PERDIDA
		matriz1 = new int[][]{{11,4,10,11}, {11,11,9,11}, {11,3,11,8}};
		tablero1.setTablero(matriz1);
		assertEquals(true, tablero1.ComprobarTablero());
		
		//PARTIDA GANADA
		matriz1 = new int[][]{{3,4,10,1}, {2,3,5,10}, {2,4,5,8}};
		tablero1.setTablero(matriz1);
		assertEquals(true, tablero1.ComprobarTablero());
	}
	
	@Test
	void testIniciarTablero() {
		//Caja negra
		TableroJugador tableroJugador = new TableroJugador(4,4,4,4);
		tableroJugador.IniciarTablero();
		int[][] mResultado1 = new int[][]{{11,11,11,11},{11,11,11,11},{11,11,11,11},{11,11,11,11}};
		assertArrayEquals(mResultado1, tableroJugador.getTablero());
		
		//Caja negra
		TableroJugador tableroJugador1 = new TableroJugador(2,2,4,4);
		tableroJugador1.IniciarTablero();
		int[][] mResultado2 = new int[][]{{11,11},{11,11}};
		assertArrayEquals(mResultado2, tableroJugador1.getTablero());
						
	}
	
	@Test
	void testComprobarCasilla() {
		TableroJugador tablero1 ;
		tablero1  = new TableroJugador(4,3,3,4);
		int[][] matriz1 = new int[][]{{11,4,5,11}, {11,11,10,11}, {11,3,11,8}};
		tablero1.setTablero(matriz1);
				
		tablero1.setTablero(matriz1);
		boolean marcado = tablero1.ComprobarCasilla(-1, 0); //Comprobamos limite EXTERIOR izquierdo frontera no valida
		assertEquals(false, marcado);

		tablero1.setTablero(matriz1);
		boolean marcado1 = tablero1.ComprobarCasilla(0, -1); //Comprobamos limite EXTERIOR superior frontera no valida
		assertEquals(false, marcado1);
		
		tablero1.setTablero(matriz1);
		boolean marcado2 = tablero1.ComprobarCasilla(4, 0); //Comprobamos limite EXTERIOR derecho frontera no valida
		assertEquals(false, marcado2);
		
		tablero1.setTablero(matriz1);
		boolean marcado3 = tablero1.ComprobarCasilla(2, 3); //Comprobamos limite EXTERIOR inferior frontera no valida
		assertEquals(false, marcado3);

		tablero1.setTablero(matriz1);
		boolean marcado4 = tablero1.ComprobarCasilla(0, 0); //Comprobamos limite INTERIOR superior-izquierda frontera - limit
		assertEquals(true, marcado4);

		tablero1.setTablero(matriz1);
		boolean marcado5 = tablero1.ComprobarCasilla(3, 0); //Comprobamos limite INTERIOR superior-derecha frontera - limit
		assertEquals(true, marcado5);
		
		tablero1.setTablero(matriz1);
		boolean marcado6 = tablero1.ComprobarCasilla(0,2); //Comprobamos limite INTERIOR inferior-izquierda frontera - limit
		assertEquals(true, marcado6);
		
		tablero1.setTablero(matriz1);
		boolean marcado7 = tablero1.ComprobarCasilla(3, 2); //Comprobamos limite INTERIOR inferior-derecha frontera - limit
		assertEquals(false, marcado7);
		
		tablero1.setTablero(matriz1);
		boolean marcado8 = tablero1.ComprobarCasilla(9, -2); //Comprobamos valor NO valido cualquiera (part. equivalente)
		assertEquals(false, marcado8);

		boolean marcado9 = tablero1.ComprobarCasilla(2,0); //Comprobamos que la casilla tiene puntuacion (part. equivalente)
		assertEquals(false, marcado9);
		
		boolean marcado10 = tablero1.ComprobarCasilla(2,1); ////La casilla tiene bandera(part. equivalente)
		assertEquals(false, marcado10);
		
		boolean marcado11 = tablero1.ComprobarCasilla(0,0); //Casilla valida cualquiera (part equivalente)
		assertEquals(true, marcado11);

		//Partition coverage
		//Condition coverage
		//Decision coverage
		//Path coverage
	}
	
	@Test
	void testDestaparCasilla() {
		/*MockGeneradorAleatorio mockGen = new MockGeneradorAleatorio();
		TableroMinas tablero1 = new TableroMinas(4,3,3);
		mockGen.setOpcion(1);
		tablero1.setGeneradorAleatorio(mockGen);
		tablero1.DistribuirMinas();
		tablero1.DistribuirPuntuacion();	
		// TABLERO : {1,1,2,9}, {2,9,2,1}, {9,2,1,0}
		assertArrayEquals(mResultado1, tablero1.getTablero());
		*/
		
		
		TableroJugador tablero1 ;
		tablero1  = new TableroJugador(4,3,3,4);
		int[][] matriz1 = new int[][]{{11,4,11,11}, {11,11,11,11}, {11,3,11,8}};
		tablero1.setTablero(matriz1);
				
		tablero1.setTablero(matriz1);
		boolean marcado3 = tablero1.DestaparCasilla(9, -2);
		assertEquals(false, marcado3);

		boolean marcado6 = tablero1.DestaparCasilla(1,0); //La casilla esta desmarcada ya
		assertEquals(false, marcado6);
		
		boolean marcado7 = tablero1.DestaparCasilla(0,0); //La casilla no esta desmarcada valor limite
		assertEquals(true, marcado7);
		
		tablero1.setTablero(matriz1);
		boolean marcado8 = tablero1.DestaparCasilla(-1, 0); //Comprobamos limite EXTERIOR izquierdo frontera no valida y x no valida
		assertEquals(false, marcado8);
		
		tablero1.setTablero(matriz1);
		boolean marcado9 = tablero1.DestaparCasilla(0, -1); //Comprobamos limite EXTERIOR superior frontera no valida y y no válida
		assertEquals(false, marcado9);
		
		tablero1.setTablero(matriz1);
		boolean marcado10 = tablero1.DestaparCasilla(4, 0); //Comprobamos limite EXTERIOR derecho frontera no valida
		assertEquals(false, marcado10);
		
		tablero1.setTablero(matriz1);
		boolean marcado11 = tablero1.DestaparCasilla(2, 3); //Comprobamos limite EXTERIOR inferior frontera no valida
		assertEquals(false, marcado11);
			
		//Condition coverage
		//Decision coverage
		//Path coverage
	}
	
	@Test
	void testQuitarInterrogante() {
		
		TableroJugador tablero1 ;
		tablero1  = new TableroJugador(4,3,3,4);
		int[][] matriz1 = new int[][]{{10,4,10,10}, {10,11,11,10}, {10,3,11,10}};

		tablero1.setTablero(matriz1);
		boolean marcado = tablero1.QuitarInterrogante(-1, 0);  //Comprobamos que el segundo if en X es falso negativo
		assertEquals(false, marcado);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(100);
		boolean marcado1 = tablero1.QuitarInterrogante(4, 0);  //Comprobamos que el segundo if en X es falso positivo 
		assertEquals(false, marcado1);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(100);
		boolean marcado2 = tablero1.QuitarInterrogante(0,-1); //Comprobamos que el segundo if en Y es falso negativo 
		assertEquals(false, marcado2);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(100);
		boolean marcado3 = tablero1.QuitarInterrogante(0, 4);  //Comprobamos que el segundo if en Y es falso positivo 
		assertEquals(false, marcado3);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(100);
		boolean marcado4 = tablero1.QuitarInterrogante(9, -2); //Comprobamos valor no válido cualquiera
		assertEquals(false, marcado4);

		tablero1.setTablero(matriz1);
		tablero1.setbanderas(100);
		boolean marcado5 = tablero1.QuitarInterrogante(0,0); //Comprobamos que hay una bandera y el limite superior izquierda
		assertEquals(true, marcado5);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(100);
		boolean marcado8 = tablero1.QuitarInterrogante(3,0); //Comprobamos limite de la tabla en esquina superior derecha
		assertEquals(true, marcado8);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(100);
		boolean marcado9 = tablero1.QuitarInterrogante(0,2); //Comprobamos limite de la tabla en esquina inferior izquierda
		assertEquals(true, marcado9);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(100);
		boolean marcado10 = tablero1.QuitarInterrogante(3,2); //Comprobamos limite de la tabla en esquina inferior derecha
		assertEquals(true, marcado10);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(100);
		boolean marcado11 = tablero1.QuitarInterrogante(1,1); //Comprobamos que no hay bandera
		assertEquals(false, marcado11);
		
		int[][] matrizEsperada = new int[][]{{11,4,10,11}, {11,11,11,11}, {11,3,11,8}};
		matriz1 = new int[][]{{10,4,10,11}, {11,11,11,11}, {11,3,11,8}};
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(10);
		boolean marcado12 = tablero1.QuitarInterrogante(0, 0);
		assertEquals(true, marcado12);
		assertArrayEquals(matrizEsperada, tablero1.getTablero()); //Comprobamos que nos devuelve la matriz correcta en (0,0)
		
		
		int[][] matrizEsperada1 = new int[][]{{11,4,10,11}, {11,11,11,11}, {11,3,11,8}};
		matriz1 = new int[][]{{11,4,10,11}, {11,11,11,11}, {11,3,10,8}};
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(10);
		boolean marcado13 = tablero1.QuitarInterrogante(2, 2);
		assertEquals(true, marcado13);
		assertArrayEquals(matrizEsperada1, tablero1.getTablero()); //Comprobamos que nos devuelve la matriz correcta en un sitio cualquiera.
	
		TableroJugador tablero2 ;
		tablero2  = new TableroJugador(4,3,3,4);
		int[][] matriz11 = new int[][]{{11,4,10,11}, {11,11,11,11}, {11,3,11,8}};
		tablero2.setTablero(matriz11);
		tablero2.setbanderas(0);
		boolean marcado14 = tablero2.QuitarInterrogante(1,1); //Comprobamos banderas>=maxBanderas => no entramos en el if 
		assertEquals(false, marcado14); 
		

	}
	
	@Test
	void testMarcarInterrogante() {
		TableroJugador tablero1 ;
		tablero1  = new TableroJugador(4,3,3,4);
		int[][] matriz1 = new int[][]{{11,4,10,11}, {11,11,11,11}, {11,3,11,11}};

		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado = tablero1.MarcarInterrogante(-1, 0); //Comprobamos que el segundo if en X es falso negativo 
		assertEquals(false, marcado);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado1 = tablero1.MarcarInterrogante(4, 0);  //Comprobamos que el segundo if en X es falso positivo 
		assertEquals(false, marcado1);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado2 = tablero1.MarcarInterrogante(0,-1); //Comprobamos que el segundo if en Y es falso negativo 
		assertEquals(false, marcado2);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado3 = tablero1.MarcarInterrogante(0, 4);  //Comprobamos que el segundo if en Y es falso positivo 
		assertEquals(false, marcado3);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado4 = tablero1.MarcarInterrogante(9, -2); //Comprobamos valor no válido cualquiera
		assertEquals(false, marcado4);

		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado5 = tablero1.MarcarInterrogante(2,0); //Comprobamos que hay una bandera
		assertEquals(false, marcado5);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado6 = tablero1.MarcarInterrogante(0,0); //Comprobamos limite de la tabla en esquina superior izquierda
		assertEquals(true, marcado6);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado8 = tablero1.MarcarInterrogante(3,0); //Comprobamos limite de la tabla en esquina superior derecha
		assertEquals(true, marcado8);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado9 = tablero1.MarcarInterrogante(0,2); //Comprobamos limite de la tabla en esquina inferior izquierda
		assertEquals(true, marcado9);
		
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado10 = tablero1.MarcarInterrogante(3,2); //Comprobamos limite de la tabla en esquina inferior derecha
		assertEquals(true, marcado10);
		
		
		int[][] matrizEsperada = new int[][]{{10,4,10,11}, {11,11,11,11}, {11,3,11,8}};
		matriz1 = new int[][]{{11,4,10,11}, {11,11,11,11}, {11,3,11,8}};
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado12 = tablero1.MarcarInterrogante(0, 0);
		assertEquals(true, marcado12);
		assertArrayEquals(matrizEsperada, tablero1.getTablero()); //Comprobamos que nos devuelve la matriz correcta en (0,0)
		
		
		int[][] matrizEsperada1 = new int[][]{{11,4,10,11}, {11,11,11,11}, {11,3,10,8}};
		matriz1 = new int[][]{{11,4,10,11}, {11,11,11,11}, {11,3,11,8}};
		tablero1.setTablero(matriz1);
		tablero1.setbanderas(0);
		boolean marcado13 = tablero1.MarcarInterrogante(2, 2);
		assertEquals(true, marcado13);
		assertArrayEquals(matrizEsperada1, tablero1.getTablero()); //Comprobamos que nos devuelve la matriz correcta en un sitio cualquiera.
	
		TableroJugador tablero2 ;
		tablero2  = new TableroJugador(4,3,3,4);
		int[][] matriz11 = new int[][]{{11,4,10,11}, {11,11,11,11}, {11,3,11,8}};
		tablero2.setTablero(matriz11);
		tablero2.setbanderas(100);
		boolean marcado11 = tablero2.MarcarInterrogante(1,1); //Comprobamos banderas>=maxBanderas => no entramos en el if 
		assertEquals(false, marcado11); 
			
	
	}
		
	//Statement coverage 
	@Test
	void testPintarTablero() {
		TableroJugador tablero1 ;
		tablero1  = new TableroJugador(4,3,3,4);
		int[][] matriz1 = new int[][]{{11,4,11,11}, {11,10,11,11}, {11,3,11,8}};
		tablero1.setTablero(matriz1);
		tablero1.PintarTablero();
			
	}
	
	//Statement Coverage
	@Test
	void testPintarPuntuacion() {
		TableroJugador tablero1 ;
		tablero1  = new TableroJugador(4,3,3,4);
		int[][] matriz1 = new int[][]{{11,4,11,11}, {11,10,11,11}, {11,3,11,8}};
		tablero1.setTablero(matriz1);
		tablero1.PintarPuntuacion();
	}
	
	
}
