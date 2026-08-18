package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class playlist {

    int playlist_id;
    String song;
    String artist;

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    // Create Connection
    public static Connection createConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/products",
                    "root",
                    ""
            );

            System.out.println("Connection successfully");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return conn;
    }


    // Display Playlist
    public static void showPlaylist() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter playlist id:");
        int id = sc.nextInt();

        try {

            Connection conn = createConnection();

            String sql = "SELECT song, artist FROM playlists WHERE playlist_id=?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();


            System.out.println("----------------------------------------");
            System.out.printf("%-20s %-20s%n", "Song", "Artist");
            System.out.println("----------------------------------------");


            while (rs.next()) {

                String song = rs.getString("song");
                String artist = rs.getString("artist");

                System.out.printf("%-20s %-20s%n", song, artist);
            }


            System.out.println("----------------------------------------");


            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}


public class Session4Q5 {

    public static void main(String[] args) {

        playlist p = new playlist();

        p.showPlaylist();

    }
}