package co.uniquindio.programacion.bingo.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

import co.uniquindio.programacion.bingo.model.Bingo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaNumerosBingo extends JFrame {
	private Bingo miBingo;
	public VentanaTablero miVentanaTablero;
	static ArrayList<Integer> balotas = new ArrayList<Integer>();

	/**
	 * @version 2.3
	 * 
	 * @author Nicolas Jurado, Kevin Garcia
	 * 
	 *         Esta clase es la encargada de mostrar el tablero de numeros
	 */

	/**
	 * Launch the application.
	 */
	JLabel[] arraylblNumeros = new JLabel[76];
	JButton btnGenerarBalota = new JButton("Generar Balota");
	JLabel lblNumeroLlamado = new JLabel("Dame click");
	JButton btnGenerarDiezBalotas = new JButton("Generar Balota x10\n");

	/**
	 * Create the application.
	 */
	public VentanaNumerosBingo() {
		initialize();

	}

	/*
	 * actualiza los componentes de esta ventana
	 */
	public void actulizarComponentes(int balota) {
		int contador = 0;
		if (balota > 0 && balota <= 15) {
			lblNumeroLlamado.setText("B" + String.valueOf(balota));
		}
		if (balota > 15 && balota <= 30) {
			lblNumeroLlamado.setText("I" + String.valueOf(balota));
		}
		if (balota > 30 && balota <= 45) {
			lblNumeroLlamado.setText("N" + String.valueOf(balota));
		}
		if (balota > 45 && balota <= 60) {
			lblNumeroLlamado.setText("G" + String.valueOf(balota));
		}
		if (balota > 60 && balota <= 75) {
			lblNumeroLlamado.setText("O" + String.valueOf(balota));
		}
		arraylblNumeros[balota].setForeground(SystemColor.green);

		for (int i = 1; i < arraylblNumeros.length; i++) {
			if (arraylblNumeros[i].getForeground() == SystemColor.green) {
				contador++;
			}

		}
		if (contador == 64) {
			btnGenerarDiezBalotas.setEnabled(false);
		}

		if (contador == 75) {
			btnGenerarBalota.setEnabled(false);
			btnGenerarDiezBalotas.setEnabled(false);

		}
	}

	/*
	 * genera una balota random que se hace desde el Bingo.java
	 */
	public void generarBalota(ArrayList<Integer> balotas) {
		int balota = Bingo.generarBalota(balotas);
		balotas.add(balota);
		System.out.println(balotas);
		actulizarComponentes(balota);
		miVentanaTablero.actualizarComponentes(balotas);

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		System.out.println(balotas);
		setTitle("Numeros Bingo");
		setBounds(100, 100, 672, 459);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 16, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textText);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		lblNumeroLlamado.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroLlamado.setForeground(SystemColor.menu);
		lblNumeroLlamado.setFont(new Font("Arial", Font.BOLD, 45));

		panel_1.add(lblNumeroLlamado);

		JButton btnGenerarBalota = new JButton("Generar Balota");
		btnGenerarBalota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarBalota(balotas);
				Bingo.comprobarBingo(0);
				Bingo.comprobarLinea(0);
			}
		});
		btnGenerarBalota.setBackground(Color.WHITE);
		btnGenerarBalota.setForeground(Color.BLACK);
		panel_1.add(btnGenerarBalota);

		JButton btnGenerarDiezBalotas = new JButton("Generar Balota x10\n");
		btnGenerarDiezBalotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 10; i++) {
					generarBalota(balotas);
				}
			}
		});
		btnGenerarDiezBalotas.setBackground(Color.WHITE);
		btnGenerarDiezBalotas.setForeground(Color.BLACK);
		panel_1.add(btnGenerarDiezBalotas);
		int k = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 16; j++) {
				if (j == 0) {
					if (i == 0) {
						JLabel lblNumero = new JLabel("B");
						lblNumero.setForeground(SystemColor.red);
						lblNumero.setFont(new Font("PT Serif", Font.PLAIN, 20));
						panel.add(lblNumero);

					}
					if (i == 1) {
						JLabel lblNumero = new JLabel("I");
						lblNumero.setFont(new Font("PT Serif", Font.PLAIN, 20));
						lblNumero.setForeground(SystemColor.red);
						panel.add(lblNumero);

					}
					if (i == 2) {
						JLabel lblNumero = new JLabel("N");
						lblNumero.setFont(new Font("PT Serif", Font.PLAIN, 20));
						lblNumero.setForeground(SystemColor.red);
						panel.add(lblNumero);

					}
					if (i == 3) {
						JLabel lblNumero = new JLabel("G");
						lblNumero.setFont(new Font("PT Serif", Font.PLAIN, 20));
						lblNumero.setForeground(SystemColor.red);
						panel.add(lblNumero);

					}
					if (i == 4) {
						JLabel lblNumero = new JLabel("O");
						lblNumero.setFont(new Font("PT Serif", Font.PLAIN, 20));
						lblNumero.setForeground(SystemColor.red);
						panel.add(lblNumero);

					}
				} else {
					JLabel lblNumero = new JLabel("" + k);
					k++;
					lblNumero.setFont(new Font("Arial", Font.PLAIN, 16));
					panel.add(lblNumero);
					arraylblNumeros[k - 1] = lblNumero;
				}

			}
		}

	}
}
