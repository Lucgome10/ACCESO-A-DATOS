package actividad13;

import java.io.*;
import java.util.Scanner;


//Elabora un programa en java que permita copiar el contenido de un fichero de texto en otro (el nuevo
//fichero será creado por el programa). Si el fichero de destino ya existe deberá mostrarse un aviso al
//usuario para que decida si quiere eliminarlo y crear uno nuevo o desea cancelar la ejecución del
//programa.

public class Actividad13 {
	
	static Scanner scanner = new Scanner(System.in); // escáner para leer la entrada del usuario desde consola.
	
	public static void main(String[] args) {
		
		File origen = new File("src\\actividad13\\origen.txt"); // Archivo de origen. El enunciado no especifica si tiene que introducirlo el usuario.
		int opcion = 0;
		
		System.out.println("Por favor, introduzca la ruta del fichero de destino:");
		File destino = new File(scanner.nextLine());

		if (destino.exists()) { // Si el fichero ya existe avisa al usuario y le pregunta qué hacer.
			System.out.println("Amigo, el fichero de destino ya existe. (1.- Eliminar anterior y crear nuevo || 2.- Cancelar copia)");
			opcion = scanner.nextInt(); scanner.nextLine();
		} else { 
			opcion = 1; // Si el fichero no existe se sigue el mismo curso que si existiera y el usuario desea crear uno nuevo.
			try {
				destino.createNewFile(); // Creación de fichero de destino.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (opcion == 1) {
			try {
				System.out.println("Generando copia para usted.");
				
				FileInputStream in = new FileInputStream(origen); // FileInputStream desde fichero de origen.
				OutputStream out = new FileOutputStream(destino); // OutputStream hacia fichero de destino.

				byte[] buf = new byte[1024]; // Lectura en bufer de 1024.
				int i;
				while ((i = in.read(buf)) > 0) {
					out.write(buf, 0, i);
					in.close();
					out.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else if (opcion == 2) { // Si el usuario desea cancelar, se cancela directamente.
			System.out.println("Cancelando operación.");
		} else if(opcion!=0) { // Si el usuario no introduce opción válida, finaliza el programa.
			System.out.println("Amigo, no has introducido una opción válida, finalizando el programa.");
		}


		
	}

}
