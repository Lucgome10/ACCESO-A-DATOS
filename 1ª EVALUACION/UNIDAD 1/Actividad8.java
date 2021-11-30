package act8;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Actividad8 {
	
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:" + File.separator + 
				"DIR1" + File.separator + "actividad8.txt");
		
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		
		byte[] b = new byte[3];
		byte[] b2 = new byte[2];
		byte[] b5 = new byte[5];
		
		while(true) {
			
			try {

				if(raf.read(b)==-1) {
					System.out.println("*** lectura finalizada. ***");
					break;
				}
				raf.skipBytes(1);
				System.out.println("Nombre: " + new String(b));
				
				raf.read(b);				
				raf.skipBytes(1);
				System.out.println("Puesto: " + new String(b));
				
				raf.read(b5);
				raf.skipBytes(1);
				System.out.println("Salario: " + new String(b5));
				
				raf.read(b2);
				raf.skipBytes(1);
				System.out.println("Antigüedad: " + new String(b2) + "\n");
				
				raf.skipBytes(1);
						
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
			
		}
								
		raf.close();
		
	}

}
