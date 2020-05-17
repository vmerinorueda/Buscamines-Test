public class ClaseTest  {

	
	public ClaseTest() {
		TableroMinasTest tableroMinas = new TableroMinasTest();

		tableroMinas.testDistribuirMinas();
		tableroMinas.testDistribuirPuntuacion();
		
		TableroJugadorTest tableroJugador = new TableroJugadorTest();
		
		tableroJugador.testComprobarCasilla();
		tableroJugador.testComprobarTablero();
		tableroJugador.testDestaparCasilla();
		tableroJugador.testIniciarTablero();
		tableroJugador.testMarcarInterrogante();
		tableroJugador.testPintarPuntuacion();
		tableroJugador.testPintarTablero();
		tableroJugador.testQuitarInterrogante();
		
		BuscaminasTest buscamines = new BuscaminasTest();
		
		buscamines.testIndicarAccion();
		buscamines.testIndicarPosicion();
		buscamines.testOpcionesPartida();
		buscamines.testMenu();
		buscamines.testJugar();
		
	}
}
