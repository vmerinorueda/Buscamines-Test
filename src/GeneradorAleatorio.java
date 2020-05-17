/*
 * La clase GeneradorAleatorio forma parte del MOCK OBJECT de MockGeneradorAleatorio.
 * Es la clase que realiza la funcion GetNumeroAleatorio que finalmente utilizara el juego
 * la cual genera valores aleatorios. (Para ver mas informacion acerca de este MOCK
 * ver clase MockGetNumeroAleatorio.java)
 */
public class GeneradorAleatorio {

	/*
	 * Devuelve un valor aleatorio entre 0 y el numMax pasado
	 */
	public int GetNumeroAleatorio(int numMax) {
		return (int) (Math.random()*(numMax));//(N-M+1)+M - Valor entre M y N, ambos incluidos.
	}
}
