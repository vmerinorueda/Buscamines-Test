import java.util.Scanner;

/*
 * La clase ScannerEntrada forma parte del MOCK OBJECT de MockScannerEntrada.
 * Es la clase que realiza la funcion getEntrada que finalmente utilizara el juego
 * la cual interactua con el usuario. (Para ver mas informacion acerca de este MOCK
 * ver clase MockScannerEntrada.java)
 */
public class ScannerEntrada {

	/*
	 * Devuelve el valor introducido por el usuario siempre que sea un numero
	 */
	public int getEntrada() {
		Scanner s = new Scanner(System.in);
		
		while(!s.hasNextInt())
		{
		   System.out.println("Valor inválido, debes introducir un número"); 
		   s.next();
		}
		return s.nextInt();
	}
}
