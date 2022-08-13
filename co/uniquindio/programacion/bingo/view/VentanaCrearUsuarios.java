package co.uniquindio.programacion.bingo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import co.uniquindio.programacion.bingo.model.Bingo;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;

public class VentanaCrearUsuarios extends JFrame {

	private JTextField numID;
	private JTextField nombre;
	ArrayList<ArrayList<String>> usuarios = new ArrayList<ArrayList<String>>();

	

	/**
	 * Create the application.
	 */
	public VentanaCrearUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setResizable(false);
		setTitle("Nuevo Usuario");
		setBounds(100, 100, 382, 215);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panelTitulo = new JPanel();
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new MigLayout("", "[382px]", "[19px]"));

		JLabel lblTitulo = new JLabel("Bienvenido, aqui puede crear un nuevo usuario ");
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

		JButton btnCrearUsuario = new JButton("Crear Nuevo Usuario");
		panelCentro.add(btnCrearUsuario, "cell 2 7");

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre.setText("");
				numID.setText("");
			}
		});

		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> usuario = new ArrayList<String>();
				String nombreStr = "" + nombre.getText();
				String numStr = "" + numID.getText();
				usuario.add(nombreStr);
				usuario.add(numStr);
				usuarios.add(usuario);
				System.out.println(usuarios);
				Dialogo miD = new DialogoDeAdvertencia("Se ha creado un nuevo usuario");
				miD.mostrarMensaje();
				nombre.setText("");
				numID.setText("");
			}
		});
	}

}
