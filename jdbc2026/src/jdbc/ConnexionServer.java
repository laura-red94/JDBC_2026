package jdbc;
import java.sql.*;

public class ConnexionServer {
	//Informations de connexion
	private static String URL = "jdbc:mysql://localhost:3306";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static void main(String [] args) {
		Connection connexion = null;
		Statement statement = null;
		
		//On va utiliser un try catch pour tester la connexion et capturer les erreurs
		try {
			//Charger le driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Etablir la connexion
			connexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connexion réussie");			
			//Pour faire des requètes, on va d'abord créer un statement
			statement = connexion.createStatement();
			//On va écrire puis executer notre requète
			String sql = "CREATE DATABASE IF NOT EXISTS CDAJAVA2026";
			statement.executeUpdate(sql);
			System.out.println("Création de la BD réussie");
			String url = "jdbc:mysql://localhost:3306/cdajava2026";
			connexion = DriverManager.getConnection(url, USER, PASSWORD);
			statement = connexion.createStatement();
			sql = " CREATE TABLE IF NOT EXISTS Users (Id INT PRIMARY KEY AUTO_INCREMENT, nom VARCHAR(100), email VARCHAR(200), age INT(3))";
			statement.executeUpdate(sql);
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
	