package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Session3Q4 {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/addsong",
                    "root",
                    ""
            );

            String username = "vikash";
            String password = "12345";

            String query = "INSERT INTO users (username, password) VALUES (?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            pstmt.executeUpdate();

            System.out.println("User inserted successfully");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}