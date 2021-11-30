package act4Recur;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import practicaEv1.ObjetoDestino;


public class Actividad4 {
	
	// Genero una constante con la ruta para mejorar la limpieza del código, aunque no hay necesidad de hacerlo de esta forma.
	public static final String RUTA = "C:\\\\DIRECTORIO\\\\.";

	
	
	// Mi programa permite dibujar el árbol de directorios sin importar los niveles de profundidad que contenga.
	public static void main(String[] args) {
	
		// Ruta del directorio.
		File f = new File(RUTA);
		System.out.println("|");
		
		accederInterior(f, 0);

	}
	
	// Función recursiva para acceder a todos los archivos y los va imprimiendo en pantalla con las tabulaciones correspondientes.
	public static void accederInterior(File file, int level) {
		
		String tab = repeat (level, "\t");
		level+=1;
		
		try {
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isDirectory()) {
					System.out.println(tab + "|+ " + f.getName());
					accederInterior(f, level);
				} else {
					System.out.println(tab + "|- " + f.getName());
				}
			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
	}
	

	// Método que devuelve una String con tantas tabulaciones como se le hayan pasado en el primer parámetro.
	public static String repeat (int count, String string) {
	    return new String(new char[count]).replace("\0", string);
	}

	
	
	
	
	
}
