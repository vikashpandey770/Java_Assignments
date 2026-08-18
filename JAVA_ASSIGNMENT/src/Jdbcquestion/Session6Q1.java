package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Session6Q1 {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "";

            String sql = "SELECT name FROM playlists";

            // Try-with-resources
            try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()
            ) {

                System.out.println("Playlist Names:");

                while (rs.next()) {

                    String name = rs.getString("name");

                    System.out.println(name);
                }
            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}