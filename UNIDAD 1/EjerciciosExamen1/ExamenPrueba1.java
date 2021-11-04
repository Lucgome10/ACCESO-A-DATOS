package ejercicio1;

import java.io.*;

/**
 * 
 * @author Lucas Gómez Rodero. 2º DAM.
 *
 */
public class ExamenPrueba1 {

	public static void analizarContenidos(String ruta) {
		File file = new File(ruta);
		if (!file.exists() ) {
			System.out.println("El fichero no existe, finalizando el programa.");
		} 
		if (file.isDirectory()) {
			analizarDirectorio(file);
			File[] directorios = file.listFiles();
			for (int i = 0; i < directorios.length; i++) {
				if (directorios[i].isDirectory()) {
					analizarContenidos(directorios[i].getAbsolutePath());
				}
				if (directorios[i].isFile()) {
					analizarFichero(directorios[i]);
				}
			}
		} else if (file.isFile()) {
			analizarFichero(file);
		}
	}
	
	public static void analizarDirectorio(File f) {
		File[] elementos = f.listFiles();
		try {
			if (elementos[0] == null) {
				System.out.println("El directorio " + f.getName() + " está vacío.");
			} else {
				System.out.println(f.getAbsolutePath() + " es un directorio que contiene " + elementos.length + " elementos.");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("El directorio " + f.getName() + " está vacío.");
		}

	}
	
	public static void analizarFichero(File f) {
		if (f.length() >= 300) {
			System.out.println(f.getAbsolutePath() + " es un fichero, pero no daremos información detallada sobre él.");
		} else {
			System.out.println(f.getAbsolutePath() + " es un fichero, su información es la siguiente:");
			
			System.out.println("\tNombre: " + f.getName());
			System.out.println("\tRuta: " + f.getAbsolutePath());
			System.out.println("\tTamaño: " + f.length());			
		}
	}
	
	
	public static void main(String[] args) {
		String ruta = "C:\\Users\\lucas\\Desktop\\PruebasProblema1";
		
		analizarContenidos(ruta);
		
	}

}
