package co.uniquindio.programacion.bingo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * @version 2.3
 * 
 * @author Nicolas Jurado, Kevin Garcia
 * 
 *         Esta clase es la encargada de mostrar la ayuda
 * 
 */

public class VentanaAyuda extends JFrame implements WindowListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Se declaran los atributos
	private JButton btnRegresar;
	private VentanaBingo miVentanaBingo;
	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JLabel lblTitulo;
	private JPanel panelInferior;

	
	/*
	 * este es el inicializador de la VentanaAyuda, recibe por parametro la
	 * ventanaBingo
	 */	
	public VentanaAyuda(VentanaBingo miVentanaBingo) {

		getContentPane();
		miVentanaBingo.setVisible(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.miVentanaBingo = miVentanaBingo;
		crearPanelSuperior();
		crearPanelCentral();
		crearPanelInferior();

		addWindowListener(this);

		repaint();
		setTitle("Como Jugar?");
		setSize(500, 700);
		setVisible(true);

	}

	public void crearPanelSuperior() {

		panelSuperior = new JPanel();
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
		lblTitulo = new JLabel("Como Jugar?");
		panelSuperior.add(lblTitulo);

	}

	public void crearPanelCentral() {
		panelCentral = new JPanel();
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		lblTitulo = new JLabel("<html>" + "<body>Estas son las instrucciones: " + "<br>"
				+ "<br> 1. El bingo consta de 75 bolas que contienen los"
				+ "<br> numeros que tendremos que ir tachando de un carton en el que suelen"
				+ "<br> haber total de 15 numeros que se disponen en cinco filas"
				+ "<br> de cinco numeros cada una, la tercera columna solo tiene 4 numeros y un"
				+ "<br> espacio en toda la mitad." + "<br>"
				+ "<br> 2. El programa cantaria los numeros, y jugadores que tengan el numero cantado en "
				+ "<br> su carton, lo tienen que tachar." + "<br>"
				+ "<br> 3. El jugador que tache los cinco numeros de una LINEA (columna) debe decir "
				+ "<br> LINEA y seria premiado con el dinero que se haya destinado para la linea." + "<br>"
				+ "<br> 4. El jugador que logre tachar todos los numeros de su carton, tendria"
				+ "<br> que decir en voz alta BINGO y cobrar el dinero asignado para ello." + "</body></html>");
		panelCentral.add(lblTitulo);

	}

	public void crearPanelInferior() {

		panelInferior = new JPanel();
		getContentPane().add(panelInferior, BorderLayout.SOUTH);
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(this);
		panelInferior.add(btnRegresar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnRegresar) {
			dispose();
			miVentanaBingo.setVisible(true);
		}
	}

	/**
	 * Acciones a seguir si se cierra la ventana
	 */
	public void windowClosing(WindowEvent arg0) {
		miVentanaBingo.setVisible(true);
	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		miVentanaBingo.setVisible(true);
	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
