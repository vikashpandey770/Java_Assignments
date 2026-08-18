package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;

class TestDbConnection{
	
	public static Connection createConnection() {
		
		Connection conn=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/music_db","root","root123");
		
		if(conn.isClosed()) {
			System.out.println("connection is established");
		}
		else {
			System.out.println("connection successfully");
		}}
	catch(Exception e) {
		e.printStackTrace();
		System.out.println("error");
	}
		return conn;
		
	}
}
public class Session1Q2 {

	public static void main(String[] args) {
		TestDbConnection tc=new TestDbConnection();
		tc.createConnection();
		
	}
}
