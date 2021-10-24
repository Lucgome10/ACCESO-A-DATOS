package actividad12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



//Dado que la clase FileReader no dispone de m�todos para leer l�neas completas, investiga sobre el
//uso de la clase BufferedReader, que s� que tiene un m�todo denominado readLine() y que sirve para
//leer l�neas de un fichero. Elabora un programa que, dado un n�mero N y un fichero (ambos datos se
//piden por consola al usuario), lea las primeras N l�neas del fichero. En caso de que el fichero tenga
//menos l�neas debe avisar al usuario. Tambi�n debe informar por pantalla del n�mero de l�nea que va
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
		
		System.out.println("Introduce el n�mero de l�neas que quieres leer:");
		int lineas = scanner.nextInt(); scanner.nextLine();
		File file = new File(ruta);
		
		try {
			// file.createNewFile();  // L�nea �til �nicamente en caso de que se utilice el fichero de ejemplo adjuntado a la actividad.
			BufferedReader br = new BufferedReader(new FileReader(file)); // Creaci�n del BufferedReader.
			for (int i = 0; i < lineas; i++) {
				lectura = br.readLine(); // Lectura de l�neas.
				if (lectura == null) { // El m�todo readLine() devuelve null si no encuentra una l�nea que leer.
					System.out.println("\n***No hay tantas l�neas en el fichero como deseas leer.***");
					break;
				} else {
					System.out.print("L�nea " + (i+1) + ": ");
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
