package Jdbcquestion;

import java.sql.*;
import java.util.Scanner;

public class Session6Q5 {

    public static void main(String[] args) {

       
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Movie ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Movie Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Movie Genre: ");
        String genre = sc.nextLine();
        String sql = "INSERT INTO movies (id, title, genre) VALUES (?, ?, ?)";
        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, genre);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Movie inserted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Unable to insert movie. Please check the database connection and data.");
        }

        sc.close();
    }
}