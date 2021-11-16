package act5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Actividad5 {

	public static void muestraErrorSQL(SQLException e) {
		System.out.println("SQL ERROR mensaje: " + e.getMessage());
		System.out.println("SQL Estado: " + e.getMessage());
		System.out.println("SQL código específico: " + e.getErrorCode());
	}
	
	public static void main(String[] args) {
		
		String baseDatos = "ventas";
		String host = "localhost";
		String port = "3306";
		String info = "?zeroDateTimeBehavior=convertToNull&useSSL=false";
		String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + baseDatos + info;
		String user = "root";
		String password = "rootLucas";
		
		try(
				Connection c = DriverManager.getConnection(urlConnection, user, password);
				PreparedStatement ps = c.prepareStatement("SELECT * FROM clientes", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);				
				ResultSet rs = ps.executeQuery()	
				) {
			
			rs.last();
			System.out.println("La tabla contiene " + rs.getRow() + " filas.");
			
			
		} catch (SQLException e) {
			muestraErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
