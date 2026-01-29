package jdbc;
import java.sql.*;

public class ConnexionDB {
	//Informations de connexion
	private static final String URL = "jdbc:mysql://localhost:3306/cdadoranco2026";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static void main(String [] args) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
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
			String sql = "SELECT * FROM produits";
			resultSet = statement.executeQuery(sql);
			//Parcourir et afficher le résultat
			//Java utilise le next pour donner un enregistrement de la bdd 
			//On utilise une boucle pour tout afficher
			resultSet.next();
			int id = resultSet.getInt("id");
			String nom = resultSet.getString("nom");
			String description = resultSet.getString("description");
			double prix = resultSet.getDouble("prix");
			System.out.println("Id : "+id);
			System.out.println("Nom : "+nom);
			System.out.println("Description : "+description);
			System.out.println("Prix : "+prix+"\n");
			
			
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			//On peut clôturer la connexion à la fin.
			try {
				if(resultSet != null) {
					resultSet.close();
					statement.close();
					connexion.close();
				}	
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
	
