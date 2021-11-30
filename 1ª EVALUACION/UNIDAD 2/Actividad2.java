package act2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Actividad2 {

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
				PreparedStatement ps = c.prepareStatement("SELECT * FROM clientes WHERE cp IS NOT NULL;");
				ResultSet rs = ps.executeQuery()){
			
			int i = 1;
			while(rs.next()) {
				System.out.println("\nCliente nº " + i);
				System.out.println("DNI: " + rs.getString("DNI"));
				System.out.println("Apellidos: " + rs.getString("APELLIDOS"));
				System.out.println("CP: " + rs.getString("CP"));
			}
			
			
		} catch (SQLException e) {
			muestraErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
