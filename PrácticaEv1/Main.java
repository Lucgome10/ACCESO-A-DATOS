package practicaEv1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// Variables estáticas. Las hago estáticas para tener mejor accesibilidad.
	public static Scanner scanner = new Scanner(System.in);
	public static String rutaDestinoStatic;
	public static ObjetoDestino objDestino;
	
	
	// Actualización 11/11/2021: falta comparar contenidos para evitar ficheros duplicados.
	
	public static void main(String[] args) {

		//System.out.println("Por favor, introduzca la ruta donde desee copiar los archivos:");
		//final String rutaDestino = scanner.nextLine();		
		final String rutaDestino = "C:\\DESTINO"; //---> Quitar esta variable y que el usuario introduzca ruta por teclado.

		try {
			rutaDestinoStatic = rutaDestino; // Revisar si esta variable estática realmente es necesaria.
			objDestino = new ObjetoDestino(rutaDestino); //Creación de objeto con directorios y acceso por getters de dirDestino.
			FileWriter fw = new FileWriter(objDestino.getRegistro());
			File dirOrigen = new File("C:\\DIRECTORIO"); // El cliente nos facilita el directorio de origen. No se pide por teclado.			
			recorrerContenidos(dirOrigen, objDestino, fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void recorrerContenidos(File dirOrigen, ObjetoDestino objDestino, FileWriter fw) {
		
		try {
			File[] files = dirOrigen.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					recorrerContenidos(file, objDestino, fw);
					
				} else {
					String rutaFicheroOrigen = file.getCanonicalPath();
					realizarCopia(rutaFicheroOrigen, objDestino, fw);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	//Método para realizar copia de los archivos, comprobando el tipo y la extensión.
	//Utiliza como método auxiliar copiarFichero()
	public static void realizarCopia(String rutaFicheroOrigen, ObjetoDestino objDestino, FileWriter fw) throws IOException {
		
		File ficheroOrigen = new File(rutaFicheroOrigen);
		String nombreFicheroOrigen = ficheroOrigen.getName();
		String rutaDestinoCopia = null;
	
		if (nombreFicheroOrigen.toLowerCase().contains("cliente") 
				&& (rutaFicheroOrigen.endsWith(".txt") || rutaFicheroOrigen.endsWith(".xml") || rutaFicheroOrigen.endsWith(".dat"))) {	
			rutaDestinoCopia = objDestino.getClientes().getAbsolutePath();
			copiarFichero(rutaFicheroOrigen, rutaDestinoCopia);
			registrarCopiaFichero(rutaFicheroOrigen, rutaDestinoCopia, fw);

		} else if (nombreFicheroOrigen.toLowerCase().contains("empleado") 
				&& (rutaFicheroOrigen.endsWith(".txt") || rutaFicheroOrigen.endsWith(".xml") || rutaFicheroOrigen.endsWith(".dat"))) {	
			rutaDestinoCopia = objDestino.getEmpleados().getAbsolutePath();
			copiarFichero(rutaFicheroOrigen, rutaDestinoCopia);
			registrarCopiaFichero(rutaFicheroOrigen, rutaDestinoCopia, fw);

		} else if (nombreFicheroOrigen.toLowerCase().contains("producto") 
				&& (rutaFicheroOrigen.endsWith(".txt") || rutaFicheroOrigen.endsWith(".xml") || rutaFicheroOrigen.endsWith(".dat"))) {				
			rutaDestinoCopia = objDestino.getProductos().getAbsolutePath();
			copiarFichero(rutaFicheroOrigen, rutaDestinoCopia);
			registrarCopiaFichero(rutaFicheroOrigen, rutaDestinoCopia, fw);

		} else if (nombreFicheroOrigen.toLowerCase().contains("proveedor") 
				&& (rutaFicheroOrigen.endsWith(".txt") || rutaFicheroOrigen.endsWith(".xml") || rutaFicheroOrigen.endsWith(".dat"))) {				
			rutaDestinoCopia = objDestino.getProveedores().getAbsolutePath();
			copiarFichero(rutaFicheroOrigen, rutaDestinoCopia);
			registrarCopiaFichero(rutaFicheroOrigen, rutaDestinoCopia, fw);

		} else if (nombreFicheroOrigen.toLowerCase().contains("sucursal") 
				&& (rutaFicheroOrigen.endsWith(".txt") || rutaFicheroOrigen.endsWith(".xml") || rutaFicheroOrigen.endsWith(".dat"))) {				
			rutaDestinoCopia = objDestino.getSucursales().getAbsolutePath();
			copiarFichero(rutaFicheroOrigen, rutaDestinoCopia);
			registrarCopiaFichero(rutaFicheroOrigen, rutaDestinoCopia, fw);

		}
		
	}
	
	//Método auxiliar que permite copiar un fichero recibiendo una ruta de origen y otra de destino.
	//Hay que crear un nuevo archivo, no mandar como argumento la carpeta.
	public static void copiarFichero(String rutaOrigen, String rutaDestinoCopia) {
		// Cambio: ahora rutaDestino es la ruta de la carpeta ejm: Clientes. Habría que añadirle el nombre del fichero a copiar.
		File origen = new File(rutaOrigen);
		File destino = new File(rutaDestinoCopia + "\\" + origen.getName());
		File temp = null;
		int c = 1;
		
		// Bloque de renombrado de ficheros en caso de que ya existan. Meter todo en un método.
		while (destino.exists()) {
			temp = new File(renombrarFichero(destino, rutaDestinoCopia, c));
			System.out.println("Nombre de temp: " + temp.getName());
			destino.renameTo(temp);
			c++;
		}
		try {
			OutputStream out = new FileOutputStream(destino);
			InputStream in = new FileInputStream(origen);
			byte[] buf = new byte[1024];
			int i;
			while ((i = in.read(buf)) > 0) {
				out.write(buf, 0, i);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	// Método auxiliar para renombrar ficheros en caso de que ya existan. Devuelve String con ruta de fichero renombrada.
	public static String renombrarFichero (File archivoDestino, String carpetaDestino, int counter) {
		System.out.println("Comprobado que destino existe");
		String nombre = archivoDestino.getName();
		String nombreSinFormato = nombre.substring(0, nombre.lastIndexOf("."));
		String formato = nombre.substring(nombre.lastIndexOf("."), nombre.length());
		String pathCambiado = carpetaDestino + "\\" + nombreSinFormato + "(" + counter + ")" + formato;
		return pathCambiado;
	}
	

	public static void registrarCopiaFichero(String rutaFicheroOrigen, String rutaFicheroDestino, FileWriter fw) throws IOException {
		fw.write("***" + rutaFicheroOrigen + " copiado en " + rutaFicheroDestino + "\n");
	}

	
}
