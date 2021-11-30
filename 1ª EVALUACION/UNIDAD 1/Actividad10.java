package act10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Actividad10 {
	
	private static final String SEEK = "acordarme";
	

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:" + File.separator + 
				"DIR1" + File.separator + "actividad10.txt");	
		
		BufferedReader bf = new BufferedReader(new FileReader(file));
		
		String str="";
		int index;
		
		
		
		while (true) {
			str = bf.readLine();
			
			if ( str == null) {
				break;
			}
			
			if (str.contains(SEEK)) {
				index = str.indexOf(SEEK);
				System.out.println(str.substring(0, index));
				break;
				
			} else {
				System.out.println(str);
				
			}
			
		}
			
		
		
			
		
		
		bf.close();

		
	}

}
