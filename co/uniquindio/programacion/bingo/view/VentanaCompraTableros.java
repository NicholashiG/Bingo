package co.uniquindio.programacion.bingo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaCompraTableros extends JFrame {
	private JTextField IDComprador;
	private JTextField TablerosAComprar;
	static ArrayList<Integer> tablerosRepetidos = new ArrayList<Integer>();
	public ArrayList<ArrayList<String>> usuariosCU = new ArrayList<ArrayList<String>>();
	public VentanaCrearUsuarios miVentanaCU;

	/**
	 * Create the application.
	 */
	public VentanaCompraTableros(VentanaCrearUsuarios miVentanaCrearUsuarios) {
		initialize(miVentanaCrearUsuarios);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	/*
	 * verifica si un valor esta repetido dentro del arraylist
	 */
	public static boolean isRepetido(ArrayList<Integer> numerosTableros, int tablero) {
		boolean repetido = false;
		for (int i = 0; i < numerosTableros.size(); i++) {
			int tab = numerosTableros.get(i);
			if (tab == tablero) {
				repetido = true;
			}
		}
		return repetido;
	}

	/*
	 * genera los numeros de tablero repetido para darle al usuario
	 */ public static int generarNumerosTableros(ArrayList<Integer> tablerosRepetidos) {
		boolean tableroRepetido = true;
		int tablero = 0;
		while (tableroRepetido == true) {
			int tableroRnd = (int) ((Math.random() * 70));
			if (!isRepetido(tablerosRepetidos, tableroRnd)) {
				tableroRepetido = false;
				tablero = tableroRnd;
			}
		}
		return tablero;
	}

	/*
	 * ingresa en el arraylist de usuario un nuevo dato, que seria los tableros que
	 * tiene
	 */
	public void ingresarEnUsuario(ArrayList<ArrayList<String>> usuariosCU, String ID, String tableroStr) {
		for (int i = 0; i < usuariosCU.size(); i++) {
			ArrayList<String> usuario = new ArrayList<String>();
			usuario = usuariosCU.get(i);
			for (int j = 0; j < usuario.size(); j++) {
				String IDUsuario = usuario.get(1);
				if (IDUsuario.contains(ID)) {
					usuario.add(tableroStr);
				}
			}
		}
	}

	private void initialize(VentanaCrearUsuarios miVentanaCrearUsuarios) {
		setBounds(100, 100, 450, 232);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.miVentanaCU = miVentanaCrearUsuarios;

		JPanel panelTitulo = new JPanel();
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new MigLayout("", "[211px]", "[19px]"));

		JLabel lblTitulo = new JLabel("Compra un Tablero a 2000");
		lblTitulo.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		panelTitulo.add(lblTitulo, "cell 0 0,alignx left,aligny top");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[61px][][grow]", "[16px][][][][]"));

		JLabel lblIDComprador = new JLabel("ID del Comprador");
		panel.add(lblIDComprador, "cell 0 0,alignx left,aligny top");

		IDComprador = new JTextField();
		panel.add(IDComprador, "cell 2 0,growx");
		IDComprador.setColumns(10);

		JLabel lblCantidadTablerosComprar = new JLabel("Cantidad de Tableros A Comprar");
		panel.add(lblCantidadTablerosComprar, "cell 0 2");

		TablerosAComprar = new JTextField();
		panel.add(TablerosAComprar, "cell 2 2,growx");
		TablerosAComprar.setColumns(10);

		JButton btnBorrar = new JButton("Borrar");
		panel.add(btnBorrar, "cell 0 4");

		JButton btnComprar = new JButton("Comprar Tablero(s)");
		panel.add(btnComprar, "cell 2 4");

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDComprador.setText("");
				TablerosAComprar.setText("");
			}
		});

		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablerosStr = "";
				int cantTableros = Integer.parseInt(TablerosAComprar.getText());
				for (int i = 0; i < cantTableros; i++) {
					int tablero = generarNumerosTableros(tablerosRepetidos);
					tablerosStr += ("," + tablero);
				}
				String ID = IDComprador.getText();
				ingresarEnUsuario(usuariosCU, ID, tablerosStr);
				System.out.println(usuariosCU);
			}
		});

	}

}
