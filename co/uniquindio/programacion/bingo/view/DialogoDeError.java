package co.uniquindio.programacion.bingo.view;

import javax.swing.JOptionPane;

/**
 * @version 1.0
 * @created Nov-2006
 * @author Juli�n Esteban Guti�rrez Posada
 *
 *         Esta clase DialogoDeError tiene como responsabilidad mostrar un
 *         dialogo de error.
 */
public class DialogoDeError extends Dialogo {

	/**
	 * M�todo constructor de la clase DialogoDeError, su responsabilidad es enviar
	 * los argumentos necesarios a la super clase Dialogo ( titulo, tipo de dialogo,
	 * mensaje).
	 *
	 * @param String mensaje, mensaje que se desea mostrar en el dialogo.
	 */
	public DialogoDeError(String mensaje) {
		super("Dialogo de Error", JOptionPane.ERROR_MESSAGE, mensaje);
	}

	/**
	 * M�todo publico que permite mostrar el mensaje especificado en el dialogo.
	 */
	public void mostrarMensaje() {
		super.mostrarMensaje();
	}
}
