package Jdbcquestion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Session4Q3 {

    // Database connection
    public static Connection createConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = java.sql.DriverManager.getConnection(
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


    // Pagination
    public static void pagination() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter page number:");
        int page = sc.nextInt();

        // 5 products per page
        int limit = 5;

        // Calculate offset
        int offset = (page - 1) * limit;

        try {

            Connection conn = createConnection();

            String sql = "SELECT product, price FROM product LIMIT ? OFFSET ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, limit);
            pst.setInt(2, offset);

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

        pagination();

    }
}