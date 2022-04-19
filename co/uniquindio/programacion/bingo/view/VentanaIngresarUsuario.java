package co.uniquindio.programacion.bingo.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import javax.swing.JLabel;

public class VentanaIngresarUsuario extends JFrame {

	public VentanaCrearUsuarios miVentanaCU;
	private JTextField numID;
	private JTextField nombre;
	public ArrayList<ArrayList<String>> usuariosCU = new ArrayList<ArrayList<String>>();

	/**
	 * Create the application y recibe por parametro la VentanaCrearUsuarios para
	 * obtener los datos de las personas ya ingresadas
	 */
	public VentanaIngresarUsuario(VentanaCrearUsuarios miVentanaCrearUsuarios) {
		initialize(miVentanaCrearUsuarios);
	}

	/*
	 * comprueba que el usuario exista basandose en su nombre y ID
	 */ public boolean comprobarUsuario(ArrayList<ArrayList<String>> UsuariosCU, String ID, String nombre) {
		boolean existe = false;
		for (int i = 0; i < usuariosCU.size(); i++) {
			ArrayList<String> usuario = new ArrayList<String>();
			usuario = usuariosCU.get(i);
			for (int j = 0; j < usuario.size(); j++) {
				String IDUsuario = usuario.get(1);
				String nombreUsuario = usuario.get(0);
				if (IDUsuario.contains(ID) && nombreUsuario.contains(nombre)) {
					existe = true;
				}
			}
		}
		return existe;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(VentanaCrearUsuarios miVentanaCrearUsuarios) {
		setResizable(false);
		this.miVentanaCU = miVentanaCrearUsuarios;
		setTitle("Ingresar Usuario");
		setBounds(100, 100, 428, 222);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panelTitulo = new JPanel();
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new MigLayout("", "[382px]", "[19px]"));

		JLabel lblTitulo = new JLabel("Bienvenido, aqui puede ingresar con un usuario existente");
		lblTitulo.setFont(new Font("Telugu MN", Font.PLAIN, 15));
		panelTitulo.add(lblTitulo, "cell 0 0,grow");

		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new MigLayout("", "[11px][52px][165px][11px]", "[26px][][][][][][][][][][][][][][]"));

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCentro.add(lblNombre, "cell 1 1,alignx left,aligny center");

		nombre = new JTextField();
		panelCentro.add(nombre, "cell 2 1 1 2,alignx center,aligny center");
		nombre.setColumns(10);

		JLabel lblNumeroID = new JLabel("Numero de Identificacion");
		lblNumeroID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCentro.add(lblNumeroID, "cell 1 4,alignx left,aligny center");

		numID = new JTextField();
		panelCentro.add(numID, "cell 2 4,alignx center,aligny center");
		numID.setColumns(10);

		JButton btnBorrar = new JButton("Borrar");
		panelCentro.add(btnBorrar, "cell 1 7");

		JButton btnIngresarUsuario = new JButton("Ingresar");
		panelCentro.add(btnIngresarUsuario, "cell 2 7");

		usuariosCU = miVentanaCU.usuarios;

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre.setText("");
				numID.setText("");
			}
		});

		btnIngresarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = numID.getText();
				String nombreUsuario = nombre.getText();
				boolean existe = comprobarUsuario(usuariosCU, ID, nombreUsuario);
				if (existe) {
					Dialogo miD = new DialogoDeAdvertencia("Bienvenido, " + nombreUsuario);
					miD.mostrarMensaje();
					nombre.setText("");
					numID.setText("");
				} else {
					Dialogo miD = new DialogoDeError(
							"Debe crear primero un usuario o su número de identidad es erróneo");
					miD.mostrarMensaje();
				}
			}
		});
	}

}
