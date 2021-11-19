package actividad14;

import java.io.*;

public class Actividad14 {

	public static void main(String[] args) {
		
		File file1 = new File("src\\actividad14\\file1.txt");
		File file2 = new File("src\\actividad14\\file2.txt");
		
		
		File file = new File("/mnt/sdcard/abc.txt");
		LineNumberReader lineNumberReader1;
		LineNumberReader lineNumberReader2;
		int lines1 = 0;
		int lines2 = 0;
		try {
			lineNumberReader1 = new LineNumberReader(new FileReader(file1));
			lineNumberReader1.skip(Long.MAX_VALUE);
			lines1 = lineNumberReader1.getLineNumber() + 1;
			lineNumberReader1.close();
			
			lineNumberReader2 = new LineNumberReader(new FileReader(file2));
			lineNumberReader2.skip(Long.MAX_VALUE);
			lines2 = lineNumberReader2.getLineNumber() + 1;
			lineNumberReader2.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		System.out.println("file1 tiene " + lines1 + " líneas");
		System.out.println("file2 tiene " + lines2 + " líneas");

		
		BufferedReader br1;
		BufferedReader br2;
		
		String line1;
		String line2;
		
		int numLinea = 0;
		
		try {
			br1 = new BufferedReader(new FileReader(file1));
			br2 = new BufferedReader(new FileReader(file2));
			do {
				numLinea++;
				line1 = br1.readLine();
				line2 = br2.readLine();
				
				if (!line1.equals(line2)) {
					System.out.println("Diferencia encontrada en la línea " + numLinea + ": " + "\n\tFile1: " + line1 + "\n\tFile2: " + line2);
				}
			} while (line1!=null && line2!=null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
	
	}

}
