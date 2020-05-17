/*
 * El MOCK OBJECT de MockGeneradorAleatorio esta formado por 4 clase (MockGeneradorAleatorio.java, GeneradorAleatorio.java,
 * TableroMinas.java y TableroMinasTest.java) 
 * Este MOCK es creado para poder simular una ubicacion concreta de las minas en luar de generase de forma aleatorio.
 * En algunos tipos de test nos interesa conocer la ubicacion concreta de las minas, por lo que este MOCK realiza dicha accion
 * simulando que asigna aleatoriamente las posiciones de las minas.
 */
public class MockGeneradorAleatorio extends GeneradorAleatorio {

	private int opcion;
	/*
	 * Segun el tipo de test que estemos realizando, se asignara un valor de opcion
	 * el cual devolvera una serie de numeros (simulacion de numeros aleatorios)
	 * segun nos convenga
	 */
	private int[] opcion1 = { 0, 3, 1, 1, 2, 0 };
	private int[] opcion2 = { 1, 0, 2, 0, 2, 1 };
	private int[] opcion3 = {};
	private int[] opcion4 = { 0,0,0,1,0,2,1,0,1,2,2,0,2,1,2,2};

	private int indice = 0;
	
	/*
	 * Marcamos la opcion de configuracion deseada para el test case
	 */
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}


	/*
	 * Funcion test GetNumeroAleatorio que sobreescrive a la funcion GetNumeroAleatorio original con
	 * los valores de salida convenientes
	 */
	public int GetNumeroAleatorio(int numMax) {
		int numAleatorio = 0;
		switch (opcion) {
		case 1:
			numAleatorio = opcion1[indice];
			indice++;
			if (indice == opcion1.length) {
				indice = 0;
			}
			break;			
		/*case 2:
			numAleatorio = opcion2[indice];
			indice++;
			if (indice == opcion2.length) {
				indice = 0;
			}
			break;
		case 3:
			numAleatorio = opcion3[indice];
			indice++;
			if (indice == opcion3.length) {
				indice = 0;
			}
			break;		
		case 4:
			numAleatorio = opcion4[indice];
			indice++;
			if (indice == opcion4.length) {
				indice = 0;
			}
			break;*/
		
		}
		return numAleatorio;
	}

}
