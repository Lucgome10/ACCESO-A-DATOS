package act11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Escribe un programa en Java que permita escribir en un fichero cadenas pedidas 
//por consola el usuario hasta que introduzca una cadena determinada (por ejemplo “FIN”).
public class Actividad11 {
		
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("hola amigo, escribe aquí:");
		File file = new File("C:\\DIR1\\actividad11.txt");
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			if (line.contains("FIN")) {
				line.subSequence(0, 0)
				break;
			}
			bw.write(line);

		}
		
		bw.close();
		
		
		
	}	
		
}		
