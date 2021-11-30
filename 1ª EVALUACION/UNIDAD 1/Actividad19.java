package act19;

import java.io.*;

/**
 * 
 * @author Lucas G�mez Rodero
 *
 */
public class Actividad19 {

	
	/*
	 	Escribe un programa en Java que, haciendo uso de la clase BufferedWriter, escriba en un fichero el
	 siguiente contenido:
			�Esto es la primera l�nea del fichero.
			Esta es la segunda l�nea.
			Esta es la tercera l�nea.�
	 */
	
	public static void main(String[] args) {
		
		// Ruta relativa del fichero.
		File file = new File("src\\act19\\archivo.txt");
		
		// Creaci�n del BufferedWriter dentro del try with resources para evitar problemas al cerrarlo.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			
			// Creaci�n del fichero.
			file.createNewFile();
			bw.write("Esto es la primera l�nea del fichero."); // Escribir l�nea.
			bw.newLine(); // Pasar a una nueva l�nea.
			bw.write("Esta es la segunda l�nea.");
			bw.newLine();
			bw.write("Esta es la tercera l�nea.");
			
			
		} catch (IOException e) { // Capturar excepciones de entrada y salida.
			e.printStackTrace();
		}

	}

}
