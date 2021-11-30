package ejercicio3;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Lucas G�mez Rodero, 2� DAM.
 *
 */
public class ExamenProblema3 {

	public static void sobreescribirFichero(File f) {
		try (FileWriter fw = new FileWriter(f, false);
				BufferedWriter bw = new BufferedWriter(fw)) {
			String cadena = "Esta es la primera l�ena que se a�ade al fichero de texto sobreescrito.";
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
			bw.write("Esta es la primera l�nea que se a�ade al fichero de texto reci�n creado.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void anadirContenido(File f) {
		try (FileWriter fw = new FileWriter(f, true);
				BufferedWriter bw = new BufferedWriter(fw)) {
			String cadena = "\nTexto a�adido al final del fichero";
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
			System.out.println("Se acaba de crear el fichero, dado que no exist�a anteriormente.");
		} else {
			System.out.println("Escoge opci�n: 1.- Sobreescribir || 2.- A�adir Contenido || 3.- Finalizar Programa");
			int opcion = scanner.nextInt(); scanner.nextLine();
			switch (opcion) {
				case 1:
					sobreescribirFichero(file);
					System.out.println("Fichero sobreescrito con �xito.");
					break;
				case 2:
					anadirContenido(file);
					System.out.println("Contenido a�adido al fichero con �xito.");
					break;
				case 3:
					System.out.println("Finalizar el programa.");
					break;
				default:
					System.out.println("No has introducido una opci�n correcta.");
					break;
			}
		}
		
		
	}

}
