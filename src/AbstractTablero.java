	/*
	 * Clase abstracta que contiene el tablero. Con metodos setters y getters de la varibale mTablero
	 */
public abstract class AbstractTablero {
	protected int[][] mTablero;
	protected int numX;
	protected int numY;
	
	public AbstractTablero(int numX, int numY) {
		this.numX = numX;
		this.numY = numY;
		mTablero = new int[numY][numX];
	}
	
	public void setTablero(int[][] mTablero) {
		this.mTablero = mTablero;
	}
	
	public int[][] getTablero() {
		return mTablero;
	}
	
	public int GetCasilla(int posX, int posY) {
		return mTablero[posY][posX];
	}

}
