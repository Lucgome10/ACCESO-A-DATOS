package act9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Actividad9 {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:" + File.separator + 
				"DIR1" + File.separator + "actividad9.txt");
		
		FileReader fr = new FileReader(file);
		int i;
		
		System.out.println("Escribe cada cuántos caracteres quieres leer:");
		int num = scanner.nextInt(); scanner.nextLine();
		
		char[] buffer = new char[num];
				
		while(true) {
			
			if (fr.read(buffer) == -1) {
				break;
			}
			
			String read = new String(buffer);
			
			System.out.print(buffer[0]);
			
			
		}
		
		
		/*
		while ((i = fr.read()) != -1  ) {
			System.out.println((char) i);
		}
		*/
		fr.close();
		
	}

}
