package act1;

import java.sql.*;

public class Actividad1 {
	
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
		
		
		try (
				Connection c = DriverManager.getConnection(urlConnection, user, password);
				PreparedStatement psDelete = c.prepareStatement("DELETE FROM clientes WHERE APELLIDOS = ?;")) {
			
			psDelete.setString(1, "LAMIQUIZ");
			psDelete.executeUpdate();
			
			//psDelete.setString(1, "APELLIDOS=);
			
			
		} catch (SQLException e) {
			muestraErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		
		
	}

}
