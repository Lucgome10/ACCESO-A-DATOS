package actividad12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



//Dado que la clase FileReader no dispone de métodos para leer líneas completas, investiga sobre el
//uso de la clase BufferedReader, que sí que tiene un método denominado readLine() y que sirve para
//leer líneas de un fichero. Elabora un programa que, dado un número N y un fichero (ambos datos se
//piden por consola al usuario), lea las primeras N líneas del fichero. En caso de que el fichero tenga
//menos líneas debe avisar al usuario. También debe informar por pantalla del número de línea que va
//leyendo.

public class Actividad12 {

	static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		System.out.println("Introduce el fichero del que quieres leer:");
		String ruta;
		ruta = scanner.nextLine();
		
		/* Se facilita la siguiente ruta por defecto para facilitar las pruebas del programa.
		 * ruta = "src\\actividad12\\entrada.txt"; 
		 */
		String lectura = null;
		int numLineas = 0;
		
		System.out.println("Introduce el número de líneas que quieres leer:");
		int lineas = scanner.nextInt(); scanner.nextLine();
		File file = new File(ruta);
		
		try {
			// file.createNewFile();  // Línea útil únicamente en caso de que se utilice el fichero de ejemplo adjuntado a la actividad.
			BufferedReader br = new BufferedReader(new FileReader(file)); // Creación del BufferedReader.
			for (int i = 0; i < lineas; i++) {
				lectura = br.readLine(); // Lectura de líneas.
				if (lectura == null) { // El método readLine() devuelve null si no encuentra una línea que leer.
					System.out.println("\n***No hay tantas líneas en el fichero como deseas leer.***");
					break;
				} else {
					System.out.print("Línea " + (i+1) + ": ");
					System.out.println(lectura);
				}
				lectura = null;
			} 
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}		
		
	}

}
