package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class SpotifyDBTest{
	
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
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class Session2Q2 {

	public static void main(String[] args) {
		
		SpotifyDBTest st=new SpotifyDBTest();
		st.createConnection();
	}
}
