package act3;

import java.io.File;

public class Actividad3 {

	/*
	    Haciendo uso del código de la actividad anterior, modifica el programa para que además muestre
		información al usuario sobre el número total de ficheros y directorios que se encuentran dentro del
		directorio actual.
	*/
	public static void main(String[] args) {
		
		// Creación de array con los archivos del directorio.
		File f = new File(".");	
        	File[] archivos = f.listFiles();

        
        // Inicializando contadores a los que asignaré el total de archivos y directorios. 
        	int numArchivos=0;
		int numDirectorios=0;
        
		
		// Trabajo con archivos:
        	System.out.println("Listado de archivos:");
		for (int i = 0; i < archivos.length; i++) {
			if (archivos[i].isFile()) {
				System.out.println(" " + archivos[i].getName()); //Impresión del nombre de los archivos.
				numArchivos++;
			}
		}
		System.out.println("En total hay " + numArchivos + " archivos en la carpeta.\n"); //Impresión del total de archivos.
		
		
		// Trabajo con directorios: contempla que los directorios puedan a su vez tener máximo un directorio más en su interior.
		System.out.println("Listado de directorios:");
		for (int i = 0; i < archivos.length; i++) {
			if (archivos[i].isDirectory()) {
				System.out.print(" " + archivos[i].getName());
				File[] containedFiles = archivos[i].listFiles();
				System.out.print(": contiene " + containedFiles.length + " archivos en su interior.\n");
			
				numDirectorios++;
			}
		}
		System.out.println("En total hay " + numDirectorios + " directorios en la carpeta.\n"); //Impresión del total de directorios.
		
        	System.out.println("\ngetParent:" + f.getParent());
        	System.out.println("getPath:" + f.getPath());

	}

}
