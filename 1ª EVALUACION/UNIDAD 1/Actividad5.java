package act5;

import java.io.File;
import java.io.IOException;

public class Actividad5 {

	public static void main(String[] args) {
		
		
		String path = null;
		
		for (int i = 1; i <= 2; i++) {
			
			for (int j=1; j<=2; j++) {
				path = "C:" + File.separator + "DIR" + i + File.separator + "fichero" + j + ".txt";
				File f = new File(path);
				f.getParentFile().mkdirs(); 
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		File fd = new File ("C:" + File.separator + "DIR2" + File.separator + "fichero2.txt");
		//fd.delete();
		File fdd = new File ("C:" + File.separator + "DIR2" + File.separator + "fichero1.txt");
		
		File fddd = new File ("C:" + File.separator + "DIR2" + File.separator + "ficheroPrueba.txt");
		
		

	    
	    
	    
	    
	    

	}

}
