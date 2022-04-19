package co.uniquindio.programacion.bingo.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import co.uniquindio.programacion.bingo.model.Bingo;

/**
 * @version 2.3
 * 
 * @author Nicolas Jurado, Kevin Garcia Esta clase es la encargada de manejar la
 *         interaccion con el usuario
 * 
 */

public class VentanaBingo extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private Bingo miBingo;
	// Se crean los elementos del men�
	private JMenuBar barraMenuPrincipal;
	private JMenu subMenuTablero;
	private JMenu subMenuAyuda;
	private JMenu subMenuUsuarios;
	private JMenuItem jMenuItemCreaTableros;
	private JMenuItem jMenuItemMuestraTablero;
	private JMenuItem jMenuItemVende;
	private JMenuItem jMenuItemCompra;
	private JMenuItem jMenuItemAyuda;
	private JMenuItem jMenuItemInformacion;
	private JMenuItem jMenuItemCreaUsuario;
	private JMenuItem jMenuItemIngresaUsuario;
	private JLabel titulo;
	public VentanaNumerosBingo miVentanaNumerosBingo;
	public VentanaCrearUsuarios miVentanaCrearUsuarios;

	/**
	 * M�todo constructor de la clase Bingo
	 *
	 */
	public VentanaBingo(VentanaNumerosBingo misNumerosBingo) {
		getContentPane();
		this.miVentanaNumerosBingo = misNumerosBingo;
		setLayout(null);
		titulo = new JLabel("Bingo");
		barraMenuPrincipal = new JMenuBar();
		/* Estos son los tres men�s que salen en la barra de menu */

		subMenuTablero = new JMenu();
		subMenuAyuda = new JMenu();
		subMenuUsuarios = new JMenu();
		jMenuItemCreaTableros = new JMenuItem();
		jMenuItemMuestraTablero = new JMenuItem();
		jMenuItemVende = new JMenuItem();
		jMenuItemCompra = new JMenuItem();
		jMenuItemAyuda = new JMenuItem();
		jMenuItemInformacion = new JMenuItem();
		jMenuItemCreaUsuario = new JMenuItem();
		jMenuItemIngresaUsuario = new JMenuItem();
		subMenuTablero.setText("Tablero");
		subMenuAyuda.setText("Ayuda");
		subMenuUsuarios.setText("Usuarios");
		jMenuItemCreaTableros.setText("Crear todos los tableros");
		jMenuItemMuestraTablero.setText("Muestra Tablero");
		jMenuItemVende.setText("Vender un tablero");
		jMenuItemCompra.setText("Compra uno o varios tableros");
		jMenuItemAyuda.setText("Como Jugar?");
		jMenuItemInformacion.setText("Informacion");
		jMenuItemCreaUsuario.setText("Crea un Nuevo Usuario");
		jMenuItemIngresaUsuario.setText("Ingresa");

		barraMenuPrincipal.add(subMenuTablero);
		barraMenuPrincipal.add(subMenuAyuda);
		barraMenuPrincipal.add(subMenuUsuarios);
		subMenuTablero.add(jMenuItemMuestraTablero);
		subMenuTablero.add(jMenuItemVende);
		subMenuTablero.add(jMenuItemCompra);
		subMenuAyuda.add(jMenuItemAyuda);
		subMenuAyuda.add(jMenuItemInformacion);
		subMenuUsuarios.add(jMenuItemCreaUsuario);
		subMenuUsuarios.add(jMenuItemIngresaUsuario);
		setJMenuBar(barraMenuPrincipal);
		titulo.setBounds(80, 30, 350, 30);
		miBingo = new Bingo();
		miBingo.crearTableros();
		titulo.setVisible(false);
		add(titulo);
		jMenuItemVende.addActionListener(this);
		jMenuItemCompra.addActionListener(this);
		jMenuItemCreaTableros.addActionListener(this);
		jMenuItemMuestraTablero.addActionListener(this);
		jMenuItemAyuda.addActionListener(this);
		jMenuItemInformacion.addActionListener(this);
		jMenuItemCreaUsuario.addActionListener(this);
		jMenuItemIngresaUsuario.addActionListener(this);
		setTitle("Bingo Uniquindiano");
		setSize(500, 500);
	}

	/**
	 * Permite configurar las acciones a realizar si ocurre un evento
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jMenuItemMuestraTablero) {

			int numTablero = Biblioteca.leerEntero("Digite el numero de tablero");
			VentanaTablero miVentanaTablero = new VentanaTablero(this, numTablero - 1, miVentanaNumerosBingo);
			miVentanaTablero.setVisible(true);

		}
	
		if (e.getSource() == jMenuItemAyuda) {
			VentanaAyuda miVentanaAyuda = new VentanaAyuda(this);
			miVentanaAyuda.setVisible(true);
		}

		if (e.getSource() == jMenuItemInformacion) {
			VentanaInformacion miVentanaInformacion = new VentanaInformacion(this);
			miVentanaInformacion.setVisible(true);
		}

		if (e.getSource() == jMenuItemVende) {
			VentanaVentaTablero miVentanaVentaTablero = new VentanaVentaTablero();
			miVentanaVentaTablero.setVisible(true);
		}

		if (e.getSource() == jMenuItemCompra) {
			VentanaCompraTableros miVentanaCompraTableros = new VentanaCompraTableros(miVentanaCrearUsuarios);
			miVentanaCompraTableros.setVisible(true);
		}

		if (e.getSource() == jMenuItemCreaUsuario) {
			this.miVentanaCrearUsuarios = new VentanaCrearUsuarios();
			miVentanaCrearUsuarios.setVisible(true);
		}

		if (e.getSource() == jMenuItemIngresaUsuario) {
			VentanaIngresarUsuario miVentanaIngresarUsuario = new VentanaIngresarUsuario(miVentanaCrearUsuarios);
			miVentanaIngresarUsuario.setVisible(true);
		}
	}

	public int getTamanioTablero() {
		return miBingo.getTam();
	}

	public int[][] devolverTablero(int i) {
		return miBingo.devolverTablero(i);
	}

	/**
	 * M�todo accesor
	 * 
	 * @return JButton[][] devuelve la informaci�n del array de botones
	 */

}