package act21;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * 
 * @author Lucas G�mez Rodero
 *
 */
public class Actividad21 {
	
	
	/*
	 Dispones de un fichero XML como el que se muestra debajo del enunciado de la actividad. Construye
	un programa en java que, haciendo uso de un parser DOM, permita obtener la informaci�n que
	contiene y presentarla sin el formato XML.
	 */
	public static void main(String[] args) {
		
		/*
		 * Lista de Clases utilizadas:
		 *  - Document
		 *  - DocumentBuilderFactory
		 *  - NodeList: se genera con el m�todo .getElementsByTagName().
		 *  - Node: se genera con el m�todo .item(i) de NodeList.
		 *  - Element: se genera al parsear un Node, tras haber comprobado que efectivamente el Node es un Element con la constante Node.ELEMENT_NODE (puede ser otras cosas como un atributo).
		 *  
		 * Lista de M�todos utilizados:
		 *  + DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("ruta del fichero"); //Aprend�rselo de memoria para generar el Document.
		 *  + documento.getDocuementElement().normalize(); // NO tengo claro si es necesario.
		 *  + Obtener un NodeList: documento.getElementsByTagName("nombre"); // Usado desde documento. y desde nodo.
		 *  + Obtener un Node desde una NodeList iterando: nodeList.item(i). // Como si fuese un ArrayList.
		 *  + Parsear Node a Element: Element elemento = (Element) nodo. // Tras haber comprobado que realmente sea un Element.
		 *  +     
		 */
		
		
		try {
			Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src\\act21\\asignaturas.xml");
			documento.getDocumentElement().normalize();
			
			// 1.- Obtener la ra�z del documento y mostrarla en pantalla.
			System.out.println(documento.getDocumentElement().getNodeName());
			
			// 2.- Obtener el NodeList de los elementos que nos interesan (asignaturas).
			NodeList asignaturas = documento.getElementsByTagName("asignatura");
			
			// El NodeList nos permite ver su tama�o con el m�todo .getLength() e iterar entre sus elementos con el m�todo .item(i).
			// Por lo tanto, generamos un bucle for que nos permita reflejar todos los datos que figuran en ese elemento.
			for (int i = 0; i < asignaturas.getLength(); i++) {
				Node asig = asignaturas.item(i); // Generamos un Node, que ser� uno de los inclu�dos en el NodeList.
				// Ahora comprobamos si el Node es un elemento, o qu� es concretamente. Se usa el m�todo .getNodeType().
				if (asig.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) asig; // En caso de ser un elemento, parseamos el Node a Element, para poder acceder a su informaci�n con el m�todo .getElementsByTagName().
					if (elemento.hasAttributes()) {
						NamedNodeMap atributos = elemento.getAttributes();
						for (int j = 0; j < atributos.getLength(); j++) {
							System.out.println("\n" + atributos.item(j).getNodeName().toUpperCase() + ": " + atributos.item(j).getNodeValue());
						}
					}
					System.out.println("Horas: " + elemento.getElementsByTagName("horas").item(0).getTextContent());
					System.out.println("Profesor: " + elemento.getElementsByTagName("profesor").item(0).getTextContent());

				}
				
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		// No es necesaria la variable, puede generarse en el aire para evitar generar tanto c�digo.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			
			/* Alternativa para generar el documento sin necesidad de tanta variable.
			Document document2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src\\act21\\asignaturas.xml");
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("src\\act21\\alumnos.xml"));
			document.getDocumentElement().normalize();
			
			System.out.println("Ra�z del documento: " + document.getDocumentElement().getNodeName());
			NodeList alumnos = document.getElementsByTagName("alumno");//
			System.out.println("N�mero de nodos alumno: " + alumnos.getLength());
			
			for (int i = 0; i < alumnos.getLength(); i++) {
				Node alu = alumnos.item(i); 
				if (alu.getNodeType() == Node.ELEMENT_NODE ) {
					Element elemento = (Element) alu;
					System.out.println("* ID: " + 
							elemento.getElementsByTagName("id").item(0).getTextContent());
					System.out.println("* Nombre: " + 
							elemento.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println("* Apellido: " + 
							elemento.getElementsByTagName("apellido").item(0).getTextContent());
					System.out.println("* Curso: = " + 
							elemento.getElementsByTagName("curso").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
}
