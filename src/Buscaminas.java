import java.io.IOException;
import java.util.Scanner;

public class Buscaminas {

	private TableroMinas tableroMinas;
	
	private static Scanner scanner = new Scanner(System.in); 
	private static ScannerEntrada scannerEntrada;
	
	private static int m_maxminas = 99;
	private static int m_nminas = 30;
	private static int m_dimX = 10;
	private static int m_dimY = 10;
	private static int m_nbanderas = 3;
	
	private static TableroJugador tableroJug = new TableroJugador(m_dimX,m_dimY,m_nbanderas,m_nminas);

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println("Bienvenido a BUSCAMINAS, the Game \n \n");
		setScannerEntrada(new ScannerEntrada());
		Menu();
	}
	
	public static void setScannerEntrada(ScannerEntrada se) {
		scannerEntrada=se;
	}
	
	public static void setTableroJugador(TableroJugador tj) {
		tableroJug = tj;
	}
	
	/*
	 * M�todo encargado de printar el men� principal del juego.
	 */
	public static void Menu() {	
				
		int selection;
		boolean salir = false;
		while(!salir) {
			System.out.println("Por favor selecciona una de las diferentes opciones para jugar: \n");
			System.out.println("1. JUGAR \n");
			System.out.println("2. OPCIONES DE PARTIDA \n"); 
			System.out.println("3. EXIT \n");
			System.out.println("-------------------------------------------------------");
			
			selection = scannerEntrada.getEntrada();
			switch (selection) {
				case 1:
					Jugar();
					break;
				case 2:
					OpcionesPartida();
					System.out.println("Opciones actualizadas correctamente. Volviendo al men� principal... \n");					
					break;
				case 3:
					System.out.println("Gracias por jugar, esperamos que vuelvas pronto.");
					salir = true;
					break;
				default:
					System.out.println("Por favor selecciona un valor correcto del men�.");
					break;		
			}		
		}
		
	}
	
	/*
	 * M�todo encargado de gestionar y controlar los valores introducidos por el usuario
	 * en las opciones de la partida.
	 */
	public static void OpcionesPartida() {
		
		boolean correct_minas = false;		
		boolean correct_banderas = false;

		boolean correctX = false;
		boolean correctY = false;
		int result;
		
		System.out.println("Bienvenido selecciona las diferentes opciones para el juego. Los valores deber�n de ser num�ricos. \n");
				
		while(correctX == false) {
			
			System.out.println("Selecciona la dimensi�n X del tablero (Puedes seleccionar de 2-10):");
			result =  scannerEntrada.getEntrada();
			
			if(result > 1 && result < 11 ) {
				m_dimX = result;
				correctX = true;
			} else {
				System.out.println("Por favor selecciona un valor v�lido para X (Entre 2-10) y vuelve a intentarlo. \n");
			}
		}

		while(correctY == false) {
			
			System.out.println("Selecciona la dimensi�n Y del tablero: (Puedes seleccionar de 2-10):");
			result = scannerEntrada.getEntrada();
			
			if(result > 1 && result < 11 ) {
				m_dimY = result;
				correctY = true;
			} else {
				System.out.println("Por favor selecciona un valor v�lido para Y (Entre 2-10) y vuelve a intentarlo. \n");
			}	
		}
		
		m_maxminas = (m_dimX * m_dimY) - 1; 
				
		while(correct_minas == false) {
			
			System.out.println("Selecciona el n�mero de minas (Puedes seleccionar de 1-" + m_maxminas + "):");
			result =  scannerEntrada.getEntrada();

			//Comprobamos que el valor de minas sea v�lido (el valor tiene que ser > 0 y < a las minas maximas +1)
			if(result > 0 && result < m_maxminas + 1 ) {
				m_nminas = result;
				correct_minas = true;
			} else {
				System.out.println("Por favor selecciona un valor v�lido (Entre 1-" + m_maxminas + ")");
			}	
		}
		
		while(correct_banderas == false) {

            System.out.println("Selecciona el n�mero de banderas (Puedes seleccionar de 1-" + m_maxminas + "):");
            result =  scannerEntrada.getEntrada();

            //Comprobamos que el valor de banderas sea v�lido (el valor tiene que ser > 0 y < a las minas maximas +1)
            if(result > 0 && result < m_maxminas + 1 ) {
                m_nbanderas = result;
                correct_banderas = true;
            } else {
                System.out.println("Por favor selecciona un valor v�lido (Entre 1-" + m_maxminas + ")");
            }
        }
		
		 tableroJug = new TableroJugador(m_dimX,m_dimY,m_nbanderas,m_nminas);;
			
	}
	
	/*
	 * M�todo encargado de comprobar que la acci�n introducida es correcta.
	 * Devuelve la acci�n seleccionada (int)
	 */
	public static int IndicarAccion() {
		boolean correcto = false;
		int accion = 0;
		
		while(!correcto) {
			System.out.println("Indicar acci�n: 0 (Destapar casilla), 1 (Marcar Bandera), 2 (Desmarcar Bandera), 3 (Salir)");
			
			accion = scannerEntrada.getEntrada();
			
			if(accion==0 || accion==1 || accion==2 || accion==3) {
				correcto=true;
			}else {
				System.out.println("Valor incorrecto");
			}
		}
		
		return accion;
	}
	
	/*
	 * M�todo encargado de asignar la posici�n indicada por el usuario en los valores
	 * definidos de la clase.
	 */
	public static int[] IndicarPosicion() {
		boolean correcto = false;
		
		int auxX = -1;
		int auxY = -1;
		int[] pos= new int[2];
		
		while(!correcto) {
			System.out.println("Indicar posicion X:");						
			auxX = scannerEntrada.getEntrada();
			
			System.out.println("Indicar posicion Y:");
			auxY = scannerEntrada.getEntrada();

			//Comprobaci�n de X e Y para ver que sean v�lidos.
			if(auxX>=0 && auxX<m_dimX && auxY>=0 && auxY<m_dimY) {
				correcto=true;
				pos[0]=auxX;
				pos[1]=auxY;
			}else {
				System.out.println("Valores incorrectos");
			}
			
		}
		
		return pos;	
	}
	
	/*
	 * M�todo encargado de gestionar el bucle principal del juego.
	 */
 	public static void Jugar(){
		
 		boolean acabado = false;
		int accion = -1;
		int[] Posicion = new int[2];
		

		while(!acabado) {
			tableroJug.PintarPuntuacion(); 
			tableroJug.PintarTablero(); 
			//Almacenamos las variables
			accion = IndicarAccion(); 
			
			if(accion == 3) {
				System.out.println("Saliendo");  
				acabado=true;						  
			}else {
				Posicion = IndicarPosicion();
				
				if(accion==0) {
					if(!tableroJug.DestaparCasilla(Posicion[0], Posicion[1])) {
						System.out.println("Posicion no valida");
					}
				}else if(accion ==1 ) {
					if(!tableroJug.MarcarInterrogante(Posicion[0], Posicion[1])) {
						System.out.println("Posicion no valida");
					}
				}else{
					if(!tableroJug.QuitarInterrogante(Posicion[0], Posicion[1])) {
						System.out.println("Posicion no valida");
					}
				}
				
				acabado = tableroJug.ComprobarTablero();	
			}
		}


		System.out.println("Juego finalizado");
 	}
		
}
