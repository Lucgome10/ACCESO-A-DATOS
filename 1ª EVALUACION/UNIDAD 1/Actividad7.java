package act7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Actividad7 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		/* 1.- Ruta del fichero nombres. */
		File file = new File("C:" + File.separator + 
				"DIR1" + File.separator + "nombres.txt");
		
		/* 2.- Leer e imprimir los caracteres entre las posiciones 10 y 15. */
		BufferedReader reader = new BufferedReader(new FileReader(file));
		reader.skip(9);
        char[] chars = new char[5];
		reader.read(chars);
        System.out.println(new String(chars));
        
        
        /* 3.- Añadir cadena "HolaMundo" a partir de la posición 20. */
        
        // Añadido al final del fichero.
        //FileWriter fw = new FileWriter(file, true); //the true will append the new data
        //fw.write("\n******** HolaMundo ********");//appends the string to the file
        //fw.close();
        
        // Añadido en posición concreta, sin problemas en el resultado porque aparece NULL.
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(3);
        raf.writeBytes("AAAAAAAAAAAAA"); 
        raf.writeInt(345345);
        raf.writeChars("ASDFASDFASFASFASF");

	}

}
