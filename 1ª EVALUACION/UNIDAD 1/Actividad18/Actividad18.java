package act18;

import java.io.*;

/**
 * 
 * @author Lucas Gómez Rodero
 *
 */
public class Actividad18 {
	
	/*
	 Escribe un programa en Java que permita escribir y leer objetos de tipo Coche (con atributos modelo,
	año, color y cilindrada) en ficheros binarios. Las rutas deben introducirse por teclado y si los ficheros
	ya existen sólo se podrán leer datos de ellos, no escribir.
	 */
	
	static final int COCHES = 20;

	// Por motivos de practicidad, mi programa escribe y lee siempre sobre el mismo fichero, sin solicitar por entrada estándar la ruta al usuario.
	// Para hacerlo de la forma en que indica el enunciado, únicamente habría que  comprobar si el archivo existe con el método exists().
	public static void main(String[] args) {
		
		// Arrays con atributos de la clase Coche, para poder generar objetos coche automáticamente de manera aleatoria.
		String[] modelos = {"Duster", "Logan", "Sandero" , "Lodgy", "Clio", "Megane"};
		String[] anyos = {"2021", "2020", "2019","2018","2017", "2016"};
		String[] colores = {"rojo", "negro", "gris","azul", "naranja", "blanco"};
		String[] cilindradas = {"2.0", "1.7", "1.5","1.3","1.1", "1.0"};
		
		//Ruta relativa del fichero.
		String rutaPrueba = "src\\act18\\coches.dat";
		File filePrueba = new File (rutaPrueba);
		
		//Generación de ObjectOutputStream dentro del try ediante try with resources, para evitar problemas al cerrarlo.
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePrueba))) {
			filePrueba.createNewFile();
			for (int i = 0; i < COCHES; i++) {
				Coche coche = new Coche(modelos[(int) (Math.random()*6+0)], anyos[(int) (Math.random()*6+0)], colores[(int) (Math.random()*6+0)], cilindradas[(int) (Math.random()*6+0)]);
				oos.writeObject(coche); // Método que escribe un objeto en el archivo.
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Por practicidad, aquí también se genera el ObjectInputStream detro del try with resources.
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePrueba))) {
			while (true) {
				Coche coche = (Coche) ois.readObject(); // Método que lee los objetos.
				System.out.println(coche.toString());
			}
			
		} catch (EOFException eofe) { // Importante este bloque catch, puesto que será el encargado de ver cuándo ha terminado de leer el fichero.
			System.out.println("\nSe ha llegado al final del fichero.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
}


class Coche implements Serializable{
	private String modelo;
	private String anyo;
	private String color;
	private String cilindrada;
	
	public Coche(String modelo, String anyo, String color, String cilindrada) {
		super();
		this.modelo = modelo;
		this.anyo = anyo;
		this.color = color;
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Coche [modelo=" + modelo + ", anyo=" + anyo + ", color=" + color + ", cilindrada=" + cilindrada + "]";
	}
	
}
