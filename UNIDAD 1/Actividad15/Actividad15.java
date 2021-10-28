package act15;

import java.io.*;

/**
 * 
 * @author LUCAS GÓMEZ RODERO
 *
 */
public class Actividad15 {

	/*
	  Escribe un programa que permita almacenar en un fichero información de empleados de manera
	estructurada (1 empleado por línea). La información a guardar será nombre, puesto (analista,
	programador, tester, becario, jefe de equipo), antigüedad (número entero de años), teléfono de
	contacto (9 dígitos), si es o no indefinido (valor booleano).
	Para acostumbrarnos a trabajar con listas se hará una breve explicación en clase para generar los
	datos de forma aleatoria.
	 */
	
	
	// La constante EMPLEADOS nos permite elegir el número de empleados que deseamos incluir.
	private static final int EMPLEADOS = 100;
	
	public static void main(String[] args) {
		
		// Se realiza el ejercicio sin crear una clase específica para Empleado que guarde todos los atributos de empleado.
		// En lugar de la clase, se hace mediante listas, escogiendo valores aleatorios de ellas.

		File ficheroEmpleados = new File("src\\act15\\ficheroEmpleados.txt");
		
		
		String[] nombres = {"Lucía", "Ignacio", "Manuel", "Alba", "Federico", "Amanda"};
		String[] puestos = {"Analista", "Programador", "Tester", "Becario", "Jefe de Equipo"};
		String[] antiguedad = {"1", "2", "3", "4","5", "6", "7", "8"};
	
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroEmpleados))) {
			ficheroEmpleados.createNewFile();
			
			for (int i = 0; i < EMPLEADOS; i++) {
				String nombre = nombres[(int)(Math.random()*6+0)];
				String puesto = puestos[(int)(Math.random()*5+0)];
				String antig = antiguedad[(int)(Math.random()*8+0)];
				String telefono = generarTelefono();
				String indefinido = generarIndefinido();
				bw.write(nombre + ";" + puesto + ";" + antig + ";" + telefono + ";" + indefinido + "\n");
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Método auxiliar para generar numeros de teléfono españoles aleatorios.
	public static String generarTelefono () {
		int tel = (int)(Math.random()*(700000000-600000000+1)+600000000);
		var telefono = Integer.toString(tel);
		return telefono;
	}
	
	// Método auxiliar para devolver valores booleanos aleatorios.
	public static String generarIndefinido () {
		// Genera números aleatorios que pueden valer 1 o 2.
		int ind = (int) (Math.random()*2+1);
		String indefinido = (ind == 1) ? "Indefinido" : "Temporal";
		return indefinido;		
	}
	
	

}
