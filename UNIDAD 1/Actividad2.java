package act2;

import java.io.File;

public class Actividad2 {

	
	
	/*
		Construye un programa que a partir del directorio actual ofrezca al usuario toda la informaci�n
		posible sobre cada uno de los archivos y directorios que se encuentren dentro del propio directorio
		actual. Es importante que el programa informe al usuario del tipo de archivos que va encontrando (si
		son directorios o no).
	*/
	
	public static void main(String[] args) {
		
		// *** Presento el mismo c�digo que en la actividad 3, comentando las partes innecesarias. ***

		
		// Creaci�n del array con los archivos del directorio.
		File f = new File(".");	
        File[] archivos = f.listFiles();

        
        // Inicializando contadores a los que asignar� el total de archivos y directorios. 
        int numArchivos=0;
		int numDirectorios=0;
        
		
		// Trabajo con archivos:
        System.out.println("Listado de archivos:");
		for (int i = 0; i < archivos.length; i++) {
			if (archivos[i].isFile()) {
				System.out.println(" " + archivos[i].getName()); //Impresi�n del nombre de los archivos.
				numArchivos++;
			}
		}
		//System.out.println("En total hay " + numArchivos + " archivos en la carpeta.\n"); //Impresi�n del total de archivos.
		
		
		// Trabajo con directorios: contempla que los directorios puedan a su vez tener m�ximo un directorio m�s en su interior.
		System.out.println("Listado de directorios:");
		for (int i = 0; i < archivos.length; i++) {
			if (archivos[i].isDirectory()) {
				System.out.print(" " + archivos[i].getName());
				File[] containedFiles = archivos[i].listFiles();
				System.out.print(": contiene " + containedFiles.length + " archivos en su interior.\n");
			
				numDirectorios++;
			}
		}
		//System.out.println("En total hay " + numDirectorios + " directorios en la carpeta.\n"); //Impresi�n del total de directorios.
		
        //System.out.println("\ngetParent:" + f.getParent());
        //System.out.println("getPath:" + f.getPath());

	}

}
