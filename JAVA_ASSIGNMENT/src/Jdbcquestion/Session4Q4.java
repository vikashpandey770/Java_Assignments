package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Session4Q4 {

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


    public static void sortProducts() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose sorting option:");
        System.out.println("1. Sort by Price");
        System.out.println("2. Sort by Product Name");

        System.out.println("Enter your choice:");
        int choice = sc.nextInt();
        String sql;
        if (choice == 1) {
            sql = "SELECT product, price FROM product ORDER BY price ASC";
        } else if (choice == 2) {
            sql = "SELECT product, price FROM product ORDER BY product ASC";
        } else {
            System.out.println("Invalid choice");
            return;
        }

        try {
            Connection conn = createConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            System.out.println("--------------------------------");
            System.out.printf("%-15s %-10s%n", "Product", "Price");
            System.out.println("--------------------------------");

            while (rs.next()) {
                String product = rs.getString("product");
                int price = rs.getInt("price");
                System.out.printf("%-15s %-10d%n", product, price);
            }
            System.out.println("--------------------------------");
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sortProducts();

    }
}