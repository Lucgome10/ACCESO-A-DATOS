package act22;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author Lucas Gómez Rodero, 2ºDAM.
 *
 */
public class Actividad22 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		try {
			Document documentoDOM = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src\\act22\\asignaturas.xml");
			mostrarInfoNodo(documentoDOM, 0);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}
	
	
	public static void mostrarInfoNodo (Node nodo, int counter) {
		
		String tab = repeat(counter, "\t");
		counter++;
		
		switch (nodo.getNodeType()) {
			case Node.DOCUMENT_NODE:
				Document documento = (Document) nodo;
				System.out.print("Versión: " + documento.getXmlVersion());
				System.out.println(" Codificación: " + documento.getXmlEncoding());
				NodeList listaNodosHijo = nodo.getChildNodes();
				for (int i = 0; i < listaNodosHijo.getLength(); i++) {
					mostrarInfoNodo(listaNodosHijo.item(i), counter);
				}
				break;
				
			case Node.ELEMENT_NODE:
				System.out.println(tab + "<" + nodo.getNodeName() + ">");
				NodeList listaNodosHijo2 = nodo.getChildNodes();
				for (int i = 0; i < listaNodosHijo2.getLength(); i++) {
					mostrarInfoNodo(listaNodosHijo2.item(i), counter);
				}
				System.out.println(tab + "</" + nodo.getNodeName() + ">");
				break;
				
			case Node.TEXT_NODE:
				String texto = nodo.getNodeValue();
				if (texto.trim().length() != 0) {
					System.out.println( tab + nodo.getNodeValue());
				}				
				break;
				
			default:
				System.out.println("Otro tipo de nodo no contemplado: " + nodo.getNodeType());
				break;			
		}
		
	}
	
	public static String repeat (int count, String string) {
	    return new String(new char[count]).replace("\0", string);
	}
}
