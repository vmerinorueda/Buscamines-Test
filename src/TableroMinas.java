	/*
	 * La clase TableroMinas contiene un tablero con los valores internos de cada posicion.
	 * Con valores del 0-8 (correspondiente a su puntuacion) o 9 si contiene una mina.
	 * La distribucion de las minas se hace mediente la llamada a la función GetNumAleatorio
	 * (funcion correspondiente a la estructura del MOCK OBJECT de generador aleatorio.
	 * La puntuación de las casillas se asigna en consecuencia con la distribucion
	 * de las minas. 
	 */
public class TableroMinas extends AbstractTablero {

	private GeneradorAleatorio genAl;
	private int nMinas;

	public TableroMinas(int numX, int numY, int nMinas) {
		super(numX, numY);
		this.nMinas = nMinas;
	}	

	/*
	 * Funcion setGeneradorAleatorio permite asignar el tipo de 
	 * objeto que hara la llamada getNumeroAleatorio, indicandole
	 * en el caso de realizar un test, su MOCK OBJECT correspondiente.
	 */
	public void setGeneradorAleatorio(GeneradorAleatorio g) {
		genAl = g;
	}	
	
	public void IniciarTablero() {
		DistribuirMinas();
		DistribuirPuntuacion();
	}
	
	/*
	 * Funcion que distribuye las minas de forma aleatoria por el tablero
	 */
	public void DistribuirMinas(){
		int randX = 0;
		int randY = 0;
		
		for (int mina = 0; mina<nMinas && mina<(numY*numX); mina++) {
			do {								
			    randY = genAl.GetNumeroAleatorio(numY);
				randX = genAl.GetNumeroAleatorio(numX);
			}while(mTablero[randY][randX]==9);
			mTablero[randY][randX] = 9;
		}
	}
	
	/*
	 * Funcion que asigna la puntuacion correspondiente a cada casilla
	 * en funcion de si tiene como vecina una mina en sus 8 casillas vecinas.
	 * Puntuacion de 0 a 8.
	 */
	public void DistribuirPuntuacion(){
		for(int y = 0; y < mTablero.length; y++) {
			for(int x = 0; x <mTablero[y].length; x++) {
				int puntuacion = 0;
				if(mTablero[y][x]!=9) {
					if((x-1>=0) && (y-1>=0) && (mTablero[y-1][x-1]==9)) {
						puntuacion++;
					}
					if((y-1>=0) && (mTablero[y-1][x]==9)) {
						puntuacion++;
					}
					if((y-1>=0) && (x+1<mTablero[y-1].length) && (mTablero[y-1][x+1]==9)) {
						puntuacion++;
					}
					if((x-1>=0) && (mTablero[y][x-1]==9)) {
						puntuacion++;
					}
					if((x+1<mTablero[y].length) && (mTablero[y][x+1]==9)) {
						puntuacion++;
					}
					if((x-1>=0) && (y+1<mTablero.length) && (mTablero[y+1][x-1]==9)) {
						puntuacion++;
					}
					if((y+1<mTablero.length) && (mTablero[y+1][x]==9)) {
						puntuacion++;
					}
					if((x+1<mTablero[y].length) && (y+1<mTablero.length) && (mTablero[y+1][x+1]==9)) {
						puntuacion++;
					}					
					mTablero[y][x] = puntuacion;
				}
			}
		}
	}	
	
}
