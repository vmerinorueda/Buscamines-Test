
public class TableroJugador extends AbstractTablero {

	private int puntuacionTotal = 0;
	private int nMaxBanderas = 0;
	private int nBanderas = 1;
	
	private TableroMinas tableroMinas;
	/*
	* SIGNIFICADO DEL VALOR DE UNA CASILLA:
	* 0 - 8 = Puntuacion
	* 9 = Mina
	* 10 = Bandera
	* 11 = Sin destapar
	*/
	
	/*
	 * Constructor de la clase por par�metros que se encarga de iniciar el tablero.
	 */
	public TableroJugador(int numX, int numY, int nBanderas, int nMinas) {
		super(numX, numY);
		this.nMaxBanderas = nBanderas;
		tableroMinas = new TableroMinas(numX,numY,nMinas);
		tableroMinas.setGeneradorAleatorio(new GeneradorAleatorio());
		tableroMinas.IniciarTablero();
		IniciarTablero();
	}
	
	
	
	public void setbanderas(int b) {
		nBanderas = b;
	}
	
	/*
	 * Constructor por par�metros al cu�l le forzamos a pasarle un TableroMinas para 
	 * utilizarlo en nuestras pruebas de test.
	 */
	public TableroJugador(int numX, int numY, int nBanderas, int nMinas, TableroMinas tableroMinas) {
		super(numX,numY);
		this.nMaxBanderas = nBanderas;
		this.tableroMinas = tableroMinas;

	}
	
	/*
	 * M�todo encargado de colocar todas las casillas del tablero a 11 (sin destapar).
	 */
	public void IniciarTablero() {
		for (int y = 0; y < mTablero.length; y++) {
			for (int x = 0; x < mTablero[y].length; x++) {
				mTablero[y][x] = 11;
			}
		}
	}

	/*
	 * M�todo encargado de comprobar que en tablero del jugador a�n no se ha
	 * destapado ninguna casilla la cu�l contenga una mina.
	 */
	public boolean ComprobarTablero() {
		boolean acabado = true;
		
		//Recorremos el tablero entero.
		for(int y = 0; y < mTablero.length; y++) {
			for(int x = 0; x < mTablero[y].length; x++) {
				
				//S i el valor es igual a 9 = MINA.
				if(mTablero[y][x]==9) {
					System.out.println("BUUUUM!, has pulsado una mina.");
					return true;
				//Si el valor es 11 = SIN DESTAPAR.
				}else if(mTablero[y][x]==11 && tableroMinas.GetCasilla(x, y)!=9) {
					acabado = false;
				}
			}
		}
		
		return acabado;
	}
	
	/*
	 * M�todo encargado de comprobar si una casilla est� a valor 11 lo
	 * cu�l quiere decir que se puede destapar.
	 */
	public boolean ComprobarCasilla(int casillaX, int casillaY) {
		
		//Comprobamos que los valores X e Y sean validos y que la casilla sea igual a 11 (SIN DESTAPAR).
		if(casillaY<mTablero.length && casillaY>=0 
				&& casillaX <mTablero[casillaY].length && casillaX>=0 
				&& mTablero[casillaY][casillaX] == 11) {
			return true;		  
		}						
		return false;				
	}
	
	/*
	 * M�todo encargado de destapar una casilla.
	 * El m�todo hace las comprobaciones pertinentes para determinar que la casilla es v�lida.
	 * Despues recoger� el valor (puntuacion) de la casilla y lo sumar� al medidor de puntuaci�n
	 * total.
	 */
	public boolean DestaparCasilla(int casillaX, int casillaY) {
		//Comprobamos que los valores X e Y sean validos y que la casilla est� sin destapar.
		if(casillaY<mTablero.length && casillaY>=0 
				&& casillaX <mTablero[casillaY].length && casillaX>=0 
				&& ComprobarCasilla(casillaX,casillaY)){
			
			//Asignamos el valor de la casilla (almacenado en tableroMinas) en una variable integer.
			int valor = tableroMinas.GetCasilla(casillaX,casillaY);
			
			//Asignamos a la casilla de tablero jugador el valor de la puntuaci�n de �sta misma.
			mTablero[casillaY][casillaX] = valor;
			
			//Aumentamos la puntuaci�n total del jugador
			puntuacionTotal += valor;
						
			return true;
		}
		return false;
	}
	
	/*
	 * M�todo encargado de colocar en la casilla correspondiente el valor 10 (bandera).
	 * Si el valor es v�lido se incrementa el contador de banderas y se asigna el valor 10 a la
	 * casilla seleccionada
	 */
	public boolean MarcarInterrogante(int dudaX, int dudaY) {
		//Comprobamos que no hayamos llegado al m�ximo de banderas permitidas.
		if(nBanderas<=nMaxBanderas) {
			//Comprobamos que los valores X e Y sean validos y que la casilla est� sin destapar.
			if(dudaY<mTablero.length && dudaY>=0 
					&& dudaX <mTablero[dudaY].length && dudaX>=0 
					&& mTablero[dudaY][dudaX] == 11) {
				//Incrementamos el numero de banderas
				nBanderas++;
				//Colocamos la casilla a 10 (BANDERA)
				mTablero[dudaY][dudaX] = 10;
				return true;
			}
			
		}
		System.out.println("M�ximo de bandera superadas");
		return false;
	} 
	
	/*
	 * M�todo encargado de colocar en la casilla correspondiente el valor 11 (sin destapar).
	 * Si el valor es v�lido se incrementa el contador de banderas y se asigna el valor 10 a la
	 * casilla seleccionada.
	 */
	public boolean QuitarInterrogante(int dudaX, int dudaY) {
		//Comprobamos que la casilla seleccionado contenga el valor 10 (BANDERA)
			if(dudaY<mTablero.length && dudaY>=0 
				&& dudaX <mTablero[dudaY].length && dudaX>=0 
				&& mTablero[dudaY][dudaX] == 10) {
			//Decrementamos el numero de banderas del jugador.
			nBanderas--;
			//Colocamos la casilla a valor 11 (SIN DESTAPAR)
			mTablero[dudaY][dudaX] = 11;
			return true;
		
		}
		
		return false;	
		}	
	
	
	/*
	 * M�todo encargado de leer el valor de cada casilla del tablero y dibujarla
	 * por pantalla.
	 */
	public void PintarTablero() {
		System.out.print("\n   ");

		//Dibujamos la gu�a num�rica en X ( 0 1 2 3...).
		for(int x = 0; x <mTablero[0].length; x++) {
			 System.out.print(x + " ");
		}
		System.out.print("\n  ");
		for(int x = 0; x <mTablero[0].length; x++) {
			 System.out.print("--");
		}
		System.out.print("\n");

		//Dibujamos la gu�a num�rica en Y ( 0 1 2 3...).
		for(int y = 0; y< mTablero.length;y++) {	
			System.out.print(y + " |");

			//Para cada casilla miramos su valor y printamos el valor correspondiente.
			for(int x = 0; x <mTablero[y].length; x++) {
				switch(mTablero[y][x]) {
					case 10: System.out.print("B ");
							 break;
					case 11: System.out.print("X ");
							 break;
					default:
						 System.out.print(mTablero[y][x] + " ");
				}
			}
			System.out.print("\n");
		}
	}
	
	/*
	 * M�todo encargado de printar por pantalla la puntuaci�n.
	 */
	public void PintarPuntuacion() {
		System.out.println("PUNTUACI�N DE PARTIDA:" + puntuacionTotal + "  |  NUMERO DE BANDERAS:" + (nMaxBanderas-nBanderas+1));
	}
}