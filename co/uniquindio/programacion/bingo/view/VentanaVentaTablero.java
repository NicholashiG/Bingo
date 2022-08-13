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

public class VentanaVentaTablero extends JFrame {

	private JTextField IDVendedor;
	private JTextField TablerosAVender;
	private JTextField IDComprador;

	/**
	 * Create the application.
	 */
	public VentanaVentaTablero() {
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 369, 252);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panelTitulo = new JPanel();
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new MigLayout("", "[119px][][][][][][][][][]", "[16px]"));

		JLabel lblTitulo = new JLabel("Ventas de Tableros");
		lblTitulo.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		panelTitulo.add(lblTitulo, "cell 0 0,alignx left,aligny top");

		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new MigLayout("", "[][][][grow][grow]", "[][][][][][][]"));

		JLabel lblVendedor = new JLabel("ID del Vendedor");
		panelCentro.add(lblVendedor, "cell 0 0");

		IDVendedor = new JTextField();
		panelCentro.add(IDVendedor, "cell 3 0,growx");
		IDVendedor.setColumns(10);

		JLabel lblTablerosAVender = new JLabel("Tableros a Vender");
		panelCentro.add(lblTablerosAVender, "cell 0 2");

		TablerosAVender = new JTextField();
		panelCentro.add(TablerosAVender, "cell 3 2,growx");
		TablerosAVender.setColumns(10);

		JLabel lblComprador = new JLabel("ID del Comprador");
		panelCentro.add(lblComprador, "cell 0 4");

		IDComprador = new JTextField();
		panelCentro.add(IDComprador, "cell 3 4,growx");
		IDComprador.setColumns(10);

		JButton btnBorrar = new JButton("Borrar");
		panelCentro.add(btnBorrar, "cell 0 6");

		JButton btnVenderTableros = new JButton("Vender Tableros");
		panelCentro.add(btnVenderTableros, "cell 3 6");

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDVendedor.setText("");
				TablerosAVender.setText("");
				IDComprador.setText("");
			}
		});

		btnVenderTableros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

}
