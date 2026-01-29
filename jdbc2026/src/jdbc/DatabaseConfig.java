package jdbc;
import java.sql.*;

public class DatabaseConfig {
	//Informations de connexion
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/cdajava2026";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Connection connexion = null;

	static {
		//On va utiliser un try catch pour tester la connexion et capturer les erreurs
		try {
			//Charger le driver
			Class.forName(DRIVER);
			
		}catch (Exception e){
			System.err.println("Erreur sur le chargement du Driver");
			e.printStackTrace();
		}
		
}
	public static Connection getConnection() throws SQLException {
		if(connexion == null || connexion.isClosed()){
			connexion = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		return connexion;
		
	
	}
	//Fermer la connexion
	public static void closeConnexion() {
		if(connexion != null) {
			try {
				connexion.close();
			}catch (Exception e){
				System.err.println("Erreur lors de la fermeture");
				e.printStackTrace();
			}
		}
	}
}


	