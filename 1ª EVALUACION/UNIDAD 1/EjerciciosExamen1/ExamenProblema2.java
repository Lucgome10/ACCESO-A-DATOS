package ejercicio2;

import java.io.*;
import java.util.ArrayList;

/**
 * 
 * @author Lucas Gómez Rodero
 *
 */
public class ExamenProblema2 {

	public static void analizaFichero(String ruta) {
		File file = new File(ruta);
		int numLinea = 1;
		String linea;
		
		try (FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)) {
			while ((linea = br.readLine()) != null) {
				System.out.println("[Línea " + numLinea + "]: " + linea);
				numLinea++;
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void buscaCadenaEnFichero(String ruta, String cadena) {
		File file = new File(ruta);
		int numLinea = 1;
		ArrayList<Integer> listaCoincidencias = new ArrayList<>();
		String linea;
		
		try (FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)) {
			linea = br.readLine();
			while (linea != null) {
				if (linea.contains("holamundo" )) {
					listaCoincidencias.add(numLinea);
				}
				numLinea++;
				linea = br.readLine();
			}	
			if (listaCoincidencias.size()>0) {
				System.out.print("Se encontraron coincidencias en las siguientes líneas: ");
				for (Integer i : listaCoincidencias) {
					System.out.print(i + " ");
				}
			} else {
				System.out.println("No se encontraron coincidencias.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		String ruta1 = "C:\\Users\\lucas\\Desktop\\PruebasProblema2\\texto.txt";
		String ruta2 = "C:\\Users\\lucas\\Desktop\\PruebasProblema2\\texto2.txt";
		
		analizaFichero(ruta1);
		buscaCadenaEnFichero(ruta1, "holamundo");
		System.out.println("********************");
		analizaFichero(ruta2);
		buscaCadenaEnFichero(ruta2, "holamundo");
		
		
	}

}
