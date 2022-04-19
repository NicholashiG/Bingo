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
 *         Esta clase es la encargada de mostrar la informacion
 * 
 */

public class VentanaInformacion extends JFrame implements WindowListener, ActionListener {
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

	

	public VentanaInformacion(VentanaBingo miVentanaBingo) {

		getContentPane();
		miVentanaBingo.setVisible(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.miVentanaBingo = miVentanaBingo;
		crearPanelSuperior();
		crearPanelCentral();
		crearPanelInferior();

		addWindowListener(this);

		repaint();
		setTitle("Informacion");
		setSize(500, 700);
		setVisible(true);

	}

	public void crearPanelSuperior() {

		panelSuperior = new JPanel();
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
		lblTitulo = new JLabel("Acerca De");
		panelSuperior.add(lblTitulo);

	}

	public void crearPanelCentral() {
		panelCentral = new JPanel();
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		lblTitulo = new JLabel("<html>" + "<body>Este bingo fue creado por:" + "<br>" + "<br> Nicolas Jurado Ramirez"
				+ "<br> Kevin Andr�s Garc�a Aguirre" + "<br>"
				+ "<br> Fue creado en el segundo semestre de Ingenieria de Sistemas" + "<br> y Computacion" + "<br>"
				+ "<br> 2021-2" + "</body></html>");
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
