package act6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Actividad6 {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Escribe el nombre del fichero que deseas eliminar:");
		String name = "C:" + File.separator + "DIR1" + File.separator;
		name += scanner.nextLine();

		File file = new File(name);
		
		/*
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		file.delete();
		
	}

}
