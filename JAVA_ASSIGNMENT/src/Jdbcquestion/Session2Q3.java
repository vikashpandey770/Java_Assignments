package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class SpotifyDBTesT{
	
	public static void createConnection() {
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("ok driver load...");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify_clone","root","spotify_clone");
			if(conn.isClosed()) {
				System.out.println("not connect");
			}
			else {
				System.out.println("connection success");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
System.out.println("class not found exception..................");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("database connection failed ..............");
			System.out.println("error :"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}



public class Session2Q3 {

	public static void main(String[] args) {
		SpotifyDBTesT st=new SpotifyDBTesT();
		st.createConnection();
		
	}
}
