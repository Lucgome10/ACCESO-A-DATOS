package act14;

import java.io.*;
/**
 * 
 * @author LUCAS GÓMEZ RODERO
 *
 */
public class Actividad14 {

	/*
	   Escribe un programa en Java que permita comparar el contenido de dos ficheros. En el caso de que
	no sean iguales deberá informarse por pantalla de las líneas (numeradas) donde se han encontrado
	diferencias imprimiendo las líneas por pantalla. 	 
	 */

	public static void main(String[] args) {

		//Definimos la ruta relativa de los dos ficheros que vamos a comparar.
		File archivo1 = new File("src\\act14\\archivo1.txt");
		File archivo2 = new File("src\\act14\\archivo2.txt");
		
		//Contar el número de líneas de ambos ficheros, para poder saber cuántas líneas debemos leer en el comparador.
		var totalLineas1 = countLineBufferedReader(archivo1.getAbsolutePath());
		var totalLineas2 = countLineBufferedReader(archivo2.getAbsolutePath());
		
		//Averiguamos cuál de los ficheros tiene más líneas, y creamos una variable con la que tenga más.
		//Prefiero asignar el valor de esta forma para acostumbrarme a ella de cara a aparentar más nivel en entrevistas técnicas :)
		int totalLineasContar = (totalLineas1 > totalLineas2) ? totalLineas1 : totalLineas2;

		
		// Genero los BufferedReader dentro del try para no tener que cerrarlos a mano.
		try (BufferedReader br1 = new BufferedReader(new FileReader(archivo1));
				BufferedReader br2 = new BufferedReader(new FileReader(archivo2));) {
			
			//Crear ficheros en caso de que no existan.
			archivo1.createNewFile();
			archivo2.createNewFile();

			String lineas1 = "";
			String lineas2 = "";

			int numLinea = 1;

			do {
				lineas1 = br1.readLine();
				lineas2 = br2.readLine();

				// Evito que las cadenas sean nulas para poder hacer comparaciones de líneas en blanco.
				if (lineas1 == null) {
					lineas1 = "";
				}
				if (lineas2 == null) {
					lineas2 = "";
				}
				if (!lineas1.equals(lineas2)) {
					System.out.println("Línea " + numLinea + ":");
					System.out.println("\t Archivo 1: " + lineas1);
					System.out.println("\t Archivo 2: " + lineas2);
				}
				numLinea++;
			} while  (numLinea < totalLineasContar);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método auxiliar para obtener el número de líneas de un fichero. Lo he obtenido de: https://mkyong.com/java/how-to-get-the-total-number-of-lines-of-a-file-in-java/
	public static int countLineBufferedReader(String fileName) {

		int lines = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			while (reader.readLine() != null) lines++;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;

	}
}
