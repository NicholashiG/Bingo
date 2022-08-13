package co.uniquindio.programacion.bingo;

import co.uniquindio.programacion.bingo.view.VentanaBingo;
import co.uniquindio.programacion.bingo.view.VentanaNumerosBingo;

/**
 * @version 2.5
 *
 * Ya está subida a github :3
 * Ya está probada en Linux UwU
 * @author Nicolas Jurado, Kevin Garcia
 * 
 *         Esta clase es la encargada de iniciar el sistema
 * 
 */

public class Aplicacion {

	/**
	 * Metodo principal
	 * 
	 * @param args argumentos enviados por el sistema operativo
	 */

	public static void main(String[] args) {
		VentanaBingo miVentanaBingo;
		VentanaNumerosBingo misNumerosBingo;
		misNumerosBingo = new VentanaNumerosBingo();
		miVentanaBingo = new VentanaBingo(misNumerosBingo);
		miVentanaBingo.setVisible(true);
		misNumerosBingo.setVisible(true);
		miVentanaBingo.setLocationRelativeTo(null);
		misNumerosBingo.setLocationRelativeTo(null);

	}

}
