package co.uniquindio.programacion.bingo.model;

import java.util.ArrayList;

/**
 * @version 2.3
 * 
 *          Esta es la clase principal del mundo
 * 
 */

public class Bingo {
	private ArrayList<int[][]> tableros;

	private static final int TAM = 5;

	/**
	 * M�todo constructor de la clase Bingo
	 *
	 */
	public Bingo() {
		tableros = new ArrayList<int[][]>();
	}

	/**
	 * 
	 * Metodo que compara la posicion de la fila y la columna, en el caso que sea
	 * i=3 y j=3, no se pondra el numero, sino que se pondra una palabra o algo
	 * relacionado
	 * 
	 * @param i, j
	 * @return centro
	 */
	public static boolean compararCentroFilasColumnas(int i, int j) {
		boolean centro = false;
		if (i == 2 && j == 2) {
			centro = true;
		}
		return centro;
	}

	/* metodo que mira si un numero ya esta repetido */

	public static boolean isRepetido(ArrayList<Integer> numeros, int numero) {
		boolean repetido = false;
		for (int i = 0; i < numeros.size(); i++) {
			int num = numeros.get(i);
			if (num == numero) {
				repetido = true;
			}
		}
		return repetido;
	}

	/*
	 * metodo que crea los tableros, c es la cantidad de tableros a crear
	 */
	public void crearTableros() {
		int tableroBingo[][] = null;
		int num = 0;
		for (int c = 0; c < 75; c++) {
			ArrayList<Integer> numeros = new ArrayList<Integer>();
			boolean repetido = true;
			tableroBingo = new int[TAM][TAM];
			for (int i = 0; i < TAM; i++) {
				for (int j = 0; j < TAM; j++) {
					if (compararCentroFilasColumnas(i, j)) {
						tableroBingo[i][j] = 0;
					} else {
						while (repetido == true) {
							num = (int) (Math.random() * 15) + (15 * j) + 1;
							if (!(isRepetido(numeros, num))) {
								repetido = false;
								numeros.add(num);
							}
						}
						tableroBingo[i][j] = num;
						repetido = true;
					}
				}
			}
			tableros.add(tableroBingo);
		}
	}

	/*
	 * este metodo genera la balota y recibe un arraylist de balotas que esta en la
	 * ventana VentanaNumerosBingo
	 */
	public static int generarBalota(ArrayList<Integer> balotas) {
		boolean balotaRepetida = true;
		int balota = 0;
		while (balotaRepetida == true) {
			int balotaRnd = (int) ((Math.random() * 75) + 1);
			if (!isRepetido(balotas, balotaRnd)) {
				balotaRepetida = false;
				balota = balotaRnd;
			}
		}
		return balota;
	}

	public void venderTableros(int numeroTab) {
		tableros.remove(numeroTab);
	}

	public static void comprobarLinea(int numeroTab) {

	}

	public static void comprobarBingo(int numeroTab) {

	}

	public String toStringTablero(int tableroBingo[][]) {
		String res = "";
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				res = res + tableroBingo[i][j] + "    ";
			}
			res = res + "\n";
		}
		return res;

	}

	public ArrayList<int[][]> getTableros() {
		return tableros;
	}

	public int[][] devolverTablero(int i) {
		return tableros.get(i);
	}

	public static int getTam() {
		return TAM;
	}

}