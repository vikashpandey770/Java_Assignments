package Jdbcquestion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class Playlist {

    int id;
    String song_name;
    String artist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    // Database Connection
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


    // Insert record and commit transaction
    public static void insertPlaylist() {

        Scanner sc = new Scanner(System.in);

        Playlist p = new Playlist();

        System.out.println("Enter id:");
        p.setId(sc.nextInt());

        sc.nextLine();

        System.out.println("Enter song name:");
        p.setSong_name(sc.nextLine());

        System.out.println("Enter artist name:");
        p.setArtist(sc.nextLine());


        Connection conn = null;

        try {

            conn = createConnection();

            // Transaction start
            conn.setAutoCommit(false);

            String sql = "INSERT INTO playlist(id, song_name, artist) VALUES (?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, p.getId());
            pst.setString(2, p.getSong_name());
            pst.setString(3, p.getArtist());

            // Insert record
            pst.executeUpdate();

            // Commit transaction
            conn.commit();

            System.out.println("Song inserted successfully");
            System.out.println("Transaction committed successfully");


            pst.close();
            conn.close();

        } catch (SQLException e) {

            try {

                if (conn != null) {
                    conn.rollback();
                    System.out.println("Transaction rollback successfully");
                }

            } catch (SQLException ex) {

                ex.printStackTrace();
            }

            e.printStackTrace();
        }
    }
}


public class Session5Q1 {

    public static void main(String[] args) {

        Playlist p = new Playlist();

        p.insertPlaylist();

    }
}