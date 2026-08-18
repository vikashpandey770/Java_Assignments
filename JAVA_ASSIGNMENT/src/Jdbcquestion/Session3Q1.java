package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


class AddSongToPlaylist{
	
	int song_id;
	String title;
	String artist;
	
	
	
	public int getSong_id() {
		return song_id;
	}



	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getArtist() {
		return artist;
	}



	public void setArtist(String artist) {
		this.artist = artist;
	}



	public static Connection  createConnection() {
		Connection conn=null;
		
		try {
			// driver load hua
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loadded....");
		// connection kiye database se
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/addsong","root","");
			
			if(conn.isClosed()) {
				System.out.println("not connected to databse");
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
		return conn;	
	}
	
	
	// insert data ab krege
	
				public static void insert() {
					try {
						AddSongToPlaylist apl=new AddSongToPlaylist();
						Scanner sc=new Scanner(System.in);
						System.out.println("Enter a title: ");
						apl.setTitle(sc.next());
						
						System.out.println("Enter a artist: ");
						apl.setArtist(sc.next());
						
						try {
							Connection conn=createConnection();
							String s="insert into playlist_songs(title,artist)values(?,?)";
							
							PreparedStatement pst=conn.prepareStatement(s);
							pst.setString(1, apl.getTitle());
							pst.setString(2,apl.getArtist());
							
							pst.executeUpdate();
							conn.close();
							
							
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
	
	
	
}

public class Session3Q1 {

	public static void main(String[] args) {
		
		AddSongToPlaylist ap=new AddSongToPlaylist();
		ap.createConnection();
		ap.insert();
		
	}
}
