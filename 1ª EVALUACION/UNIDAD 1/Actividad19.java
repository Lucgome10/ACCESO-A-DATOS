package act19;

import java.io.*;

/**
 * 
 * @author Lucas Gómez Rodero
 *
 */
public class Actividad19 {

	
	/*
	 	Escribe un programa en Java que, haciendo uso de la clase BufferedWriter, escriba en un fichero el
	 siguiente contenido:
			“Esto es la primera línea del fichero.
			Esta es la segunda línea.
			Esta es la tercera línea.”
	 */
	
	public static void main(String[] args) {
		
		// Ruta relativa del fichero.
		File file = new File("src\\act19\\archivo.txt");
		
		// Creación del BufferedWriter dentro del try with resources para evitar problemas al cerrarlo.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			
			// Creación del fichero.
			file.createNewFile();
			bw.write("Esto es la primera línea del fichero."); // Escribir línea.
			bw.newLine(); // Pasar a una nueva línea.
			bw.write("Esta es la segunda línea.");
			bw.newLine();
			bw.write("Esta es la tercera línea.");
			
			
		} catch (IOException e) { // Capturar excepciones de entrada y salida.
			e.printStackTrace();
		}

	}

}
