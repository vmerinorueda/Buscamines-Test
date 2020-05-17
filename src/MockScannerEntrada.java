/*
 * El MOCK OBJECT de MockScannerEntrada esta formado por 4 clase (MockScannerEntrada.java, ScannerEntrada.java,
 * Buscaminas.java y BuscaminasTest.java) 
 * Este MOCK es creado para poder simular una supuesta interaccion del usuario con el juego, controlando asi
 * que movimientos exactos se van a realizar. Sirve para hacer test de todos esos metodos que necesitan
 * que el usuario interaccione por teclado.
 */
public class MockScannerEntrada extends ScannerEntrada {
	
	private int opcion;
	/*
	 * Segun el tipo de test que estemos realizando, se asignara un valor de opcion
	 * el cual devolvera una serie de numeros (simulacion de entrada de usuario)
	 * segun nos convenga
	 */
	
	private int[] opcion0 = { 4, -1, 10, 0 };
	private int[] opcion1 =  { 4, -1, 10, 1 };
	private int[] opcion2 =  { 4, -1, 10, 2 };
	private int[] opcion3 =  { 4, -1, 10, 3 };

	
	private int[] opcion20 =  {10,10,0,0};
	private int[] opcion21 =  {-1,-1,1,1};
	private int[] opcion22 =  { 2,16,9,9};			
	private int[] opcion23 =  {-2,6,2,6};

	private int[] opcion30 = {-1,1,11,5,-1,1,11,5,-1,0,25,12,-1,0,25,12};
	
	private int[] opcion40 = {-1,4,2,5,5,5,4,3};
	private int[] opcion41 = {1,3,3};

	private int[] opcion50 = { 0,0,1,       0,0,1,      1,0,1,   1,0,0,   2,0,1,      2,0,0,     3};
							//(destapar)(destapar Mal)(MInt mal) (MInt)(QitInt mal)(QitIntBien)(salir)
	
	
	private int indice = 0;

	/*
	 * Marcamos la opcion de configuracion deseada para el test case
	 */
	public void setConfig(int opcion) {
		indice = 0;
		this.opcion = opcion;
	}
	
	/*
	 * Funcion test getEntrada que sobreescrive a la funcion getEntrada original con
	 * los valores de salida convenientes
	 */
	public int getEntrada() {
		int entrada = 0;

		switch (opcion) {
		case 0:
			entrada = opcion0[indice];
			indice++;
			if (indice == opcion0.length) {
				indice = 0;
			}
			break;		
		case 1:
			entrada = opcion1[indice];
			indice++;
			if (indice == opcion1.length) {
				indice = 0;
			}
			break;
		case 2:
			entrada = opcion2[indice];
			indice++;
			if (indice == opcion2.length) {
				indice = 0;
			}
			break;
		case 3:
			entrada = opcion3[indice];
			indice++;
			if (indice == opcion3.length) {
				indice = 0;
			}
			break;	
		case 20:
			entrada = opcion20[indice];
			indice++;
			if (indice == opcion20.length) {
				indice = 0;
			}
			break;	
			
		case 21:
			entrada = opcion21[indice];
			indice++;
			if (indice == opcion21.length) {
				indice = 0;
			}
			break;	
		
		case 22:
			entrada = opcion22[indice];
			indice++;
			if (indice == opcion22.length) {
				indice = 0;
			}
			break;	
		
		case 23:
			entrada = opcion23[indice];
			indice++;
			if (indice == opcion23.length) {
				indice = 0;
			}
			break;	
		case 30:
				entrada = opcion30[indice];
				indice++;
				if (indice == opcion30.length) {
					indice = 0;
				}
				break;	
		case 40:
			entrada = opcion40[indice];
			indice++;
			if (indice == opcion40.length) {
				indice = 0;
			}
			break;
		case 41:
			entrada = opcion41[indice];
			indice++;
			if (indice == opcion41.length) {
				indice = 0;
			}
			break;
		case 50:
			entrada = opcion50[indice];
			indice++;
			if (indice == opcion50.length) {
				indice = 0;
			}
			break;
	}
		return entrada;
		
	}
}
