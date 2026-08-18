package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;

class TestDbConnectionn{
	
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
		System.out.println("conectin fail");
		System.out.println("errir:"+e.getMessage());
		
		e.printStackTrace();
		System.out.println("error");
	}
		return conn;		
	}
}
/*
 * Error occurred because the MySQL username/password is incorrect.
 * The password 'wrongpassword' does not match the root user's password.
 */
public class Session1Q3 {

	public static void main(String[] args) {
		TestDbConnectionn tc=new TestDbConnectionn();
		tc.createConnection();
		
	}
}
