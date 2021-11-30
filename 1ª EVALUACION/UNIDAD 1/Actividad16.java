package act16;

import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author LUCAS G�MEZ RODERO
 *
 */
public class Actividad16 {
	
	/*
	 	Escribe un programa en Java que permita recuperar los datos del fichero que crea el programa de la
	actividad 15. En este caso el usuario deber� poder recuperar los empleados filtrados por cada uno de
	los siguientes campos:
	a. Puesto: el usuario deber� poder elegir el tipo de puesto de los empleados que se mostrar�n.
	b. Antig�edad: el usuario deber� poder elegir empleados con una antig�edad menor, mayor o
		igual a un determinado n�mero de a�os.
	c. Indefinido: el usuario tiene que poder elegir filtrar si mostrar empleados indefinidos o no.
	 */
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		File ficheroEmpleados = new File("src\\act15\\ficheroEmpleados.txt");
		
		System.out.println("Escribe el tipo de empleado: Analista || Programador || Tester || Becario || Jefe de Equipo");
		String puesto = scanner.nextLine();
		System.out.println("Escribe la antig�edad m�nima:");
		int antig = scanner.nextInt();  scanner.nextLine();
		System.out.println("Escribe el tipo de contrato: Indefinido || Temporal");
		String contrato = scanner.nextLine();		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(ficheroEmpleados))) {
			
			String empleadoString = "";
			
			do {
				empleadoString = br.readLine();
				String [] empleadoArray = empleadoString.split(";"); 
				if (empleadoArray[1].equalsIgnoreCase(puesto) && Integer.parseInt(empleadoArray[2])>=antig && empleadoArray[4].equalsIgnoreCase(contrato)) {
					System.out.println("El empleado " + empleadoArray[0] + " cumple sus criterios de b�squeda.");
				}

			} while (!(empleadoString == null));
						
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
		    System.out.println("No quedan empleados por buscar.");
		}

		
	}

}



























 