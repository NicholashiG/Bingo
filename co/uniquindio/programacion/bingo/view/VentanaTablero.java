package co.uniquindio.programacion.bingo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.uniquindio.programacion.bingo.model.Bingo;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.SystemColor;

/**
 * @version 2.3
 * 
 * @author Nicolas Jurado, Kevin Garcia
 * 
 *         Esta clase es la encargada de mostrar los tableros
 * 
 */

public class VentanaTablero extends JFrame implements WindowListener, ActionListener {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	// Se declaran los atributos
	private JButton btnTablero[][];
	private JButton btnRegresar;
	private VentanaBingo miVentanaBingo;
	private Bingo miBingo;
	private JPanel panelSuperior;
	private JLabel lblTitulo;
	private JPanel panelCentro;
	private JPanel panelInferior;
	private int numeroTablero = 0;
	private VentanaNumerosBingo miVentanaNumerosBingo;
	int[] vector = new int[75];
	ArrayList<Integer> balotasVT = new ArrayList<Integer>();
	int numeroTableroBingo;
	int contadorBingo;

	/*
	 * inicializa la VentanaTablero y recibe los parametros miVentanaBingo,
	 * numTablero y misNumerosBingo
	 */
	public VentanaTablero(VentanaBingo miVentanaBingo, int numTablero, VentanaNumerosBingo misNumerosBingo) {
		numeroTableroBingo = numTablero;
		this.miVentanaNumerosBingo = misNumerosBingo;
		getContentPane();
		miVentanaBingo.setVisible(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.miVentanaBingo = miVentanaBingo;
		int tam = miVentanaBingo.getTamanioTablero();
		int tablero[][] = miVentanaBingo.devolverTablero(numTablero);
		btnTablero = new JButton[tam][tam];
		crearPanelSuperior();
		crearPanelCentro(tam, tablero);
		crearPanelInferior();
		addWindowListener(this);
		this.numeroTablero = numTablero + 1;
		repaint();
		setTitle("Tablero " + (numeroTableroBingo + 1));
		setSize(500, 700);
		setVisible(true);
		miVentanaNumerosBingo.miVentanaTablero = this;
		balotasVT = VentanaNumerosBingo.balotas;
		actualizarComponentes(balotasVT);
	}

	/*
	 * actualiza los componentes del tablero
	 */
	public void actualizarComponentes(ArrayList<Integer> balotas) {
		System.out.println("x");
		int k = 0;
		for (int i = 0; i < btnTablero.length; i++) {
			for (int j = 0; j < btnTablero[0].length; j++) {
				String numTab = "" + btnTablero[i][j].getText();
				for (int l = 0; l < balotas.size(); l++) {
					String balotaStr = "" + balotas.get(l);

					if (numTab.equalsIgnoreCase(balotaStr)) {
						btnTablero[i][j].setForeground(SystemColor.cyan);
						k++;
					}
				}

			}
		}
		contadorBingo = k;

		vector[numeroTableroBingo] = contadorBingo;
		isBingo(contadorBingo);

	}

	/*
	 * revisa si alguno de los tableros ya tiene el bingo completo
	 */
	public void isBingo(int contadorBingo) {
		if (contadorBingo >= 24) {
			Dialogo miD = new DialogoDeAdvertencia("Hay un ganador de Bingo");
			miD.mostrarMensaje();
		}
	}

	public void crearPanelSuperior() {

		panelSuperior = new JPanel();
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
		lblTitulo = new JLabel("Tablero " + (numeroTableroBingo + 1));
		panelSuperior.add(lblTitulo);

	}

	public void crearPanelCentro(int tam, int tablero[][]) {

		panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(tam, tam, 0, 0));
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {

				btnTablero[i][j] = new JButton();
				if (i == 2 && j == 2) {
					ImageIcon iconLogo = new ImageIcon("1.png");
					btnTablero[i][j].setIcon(iconLogo);

				} else {
					btnTablero[i][j].setText("" + tablero[i][j]);
				}
				btnTablero[i][j].setVisible(true);
				panelCentro.add(btnTablero[i][j]);
			}
		}
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
		if (e.getSource() == miVentanaNumerosBingo.btnGenerarBalota) {
			actualizarComponentes(balotasVT);
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
