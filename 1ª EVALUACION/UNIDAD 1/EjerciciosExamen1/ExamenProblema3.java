package ejercicio3;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Lucas Gómez Rodero, 2º DAM.
 *
 */
public class ExamenProblema3 {

	public static void sobreescribirFichero(File f) {
		try (FileWriter fw = new FileWriter(f, false);
				BufferedWriter bw = new BufferedWriter(fw)) {
			String cadena = "Esta es la primera líena que se añade al fichero de texto sobreescrito.";
			bw.write(cadena);			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void escribirFichero(File f) {
		try (FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw)) {
			f.createNewFile();
			bw.write("Esta es la primera línea que se añade al fichero de texto recién creado.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void anadirContenido(File f) {
		try (FileWriter fw = new FileWriter(f, true);
				BufferedWriter bw = new BufferedWriter(fw)) {
			String cadena = "\nTexto añadido al final del fichero";
			bw.write(cadena);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	public static Scanner scanner = new Scanner(System.in);
	private static final String ruta = "C:\\Users\\lucas\\Desktop\\PruebasProblema3\\texto5.txt";
			
			
	public static void main(String[] args) {
		 
		File file = new File (ruta);
		if (!file.exists()) {
			escribirFichero(file);
			System.out.println("Se acaba de crear el fichero, dado que no existía anteriormente.");
		} else {
			System.out.println("Escoge opción: 1.- Sobreescribir || 2.- Añadir Contenido || 3.- Finalizar Programa");
			int opcion = scanner.nextInt(); scanner.nextLine();
			switch (opcion) {
				case 1:
					sobreescribirFichero(file);
					System.out.println("Fichero sobreescrito con éxito.");
					break;
				case 2:
					anadirContenido(file);
					System.out.println("Contenido añadido al fichero con éxito.");
					break;
				case 3:
					System.out.println("Finalizar el programa.");
					break;
				default:
					System.out.println("No has introducido una opción correcta.");
					break;
			}
		}
		
		
	}

}
