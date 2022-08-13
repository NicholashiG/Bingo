package co.uniquindio.programacion.bingo.view;

import javax.swing.JOptionPane;

/**
 * @version 1.0
 * @created Nov-2006
 * @author Juli�n Esteban Guti�rrez Posada
 *
 *         Esta clase DialogoDeAdvertencia tiene como responsabilidad mostrar un
 *         dialogo de advertencia.
 */
public class DialogoDeAdvertencia extends Dialogo {

	/**
	 * M�todo constructor de la clase DialogoDeAdvertencia, su responsabilidad es
	 * enviar los argumentos necesarios a la super clase Dialogo ( titulo, tipo de
	 * dialogo, mensaje).
	 *
	 * @param String mensaje, mensaje que se desea mostrar en el dialogo.
	 */
	public DialogoDeAdvertencia(String mensaje) {
		super("Dialogo de Advertencia", JOptionPane.WARNING_MESSAGE, mensaje);
	}

	/**
	 * M�todo publico que permite mostrar el mensaje especificado en el dialogo.
	 *
	 * @return un entero que determina que b�ton presion� (Aceptar o Cancelar).
	 */
	public int mostrarAdvertencia() {
		return mostrarMensaje(JOptionPane.OK_CANCEL_OPTION);
	}

}
