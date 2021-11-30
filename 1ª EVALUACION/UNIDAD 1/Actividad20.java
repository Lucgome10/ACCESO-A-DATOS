package act20;

import java.io.*;
import java.util.Scanner;

/**^
 * 
 * @author Lucas Gómez Rodero
 *
 */
public class Actividad20 {

	/*
	  Escribe un programa en Java que vaya leyendo un fichero por líneas y lo vaya escribiendo también
	por líneas en otro fichero. Ambos ficheros deben pedirse al usuario por teclado.
	 */
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Por favor, escribe la ruta del fichero de lectura:");
		String rutaLectura = scanner.nextLine();
		//String rutaLectura = "src\\act20\\lectura.txt";

		System.out.println("Por favor, escribe la ruta del fichero de escritura:");
		String rutaEscritura = scanner.nextLine();
		//String rutaEscritura = "src\\act20\\escritura.txt";

		File fileLectura = new File(rutaLectura);
		File fileEscritura = new File(rutaEscritura);

		// Se generan los BufferedReader y BufferedWriter dentro del try with resources para evitar problemas al cerrar.
		try (BufferedReader br = new BufferedReader(new FileReader(fileLectura));
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileEscritura))) {
			fileEscritura.createNewFile(); //Generamos archivo de escritura en caso de que no exista.
			String linea;
			do {
				linea = br.readLine();
				if (linea == null) {
					break;
				}
				bw.write(linea);
				bw.newLine();
			} while (!(linea==null));
			
		} catch (EOFException eof) {
			System.out.println("Se ha llegado al final del fichero.");
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
