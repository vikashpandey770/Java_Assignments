package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Session4Q2 {

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


    public static void searchByCategory() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter category name:");
        String category = sc.nextLine();

        try {

            Connection conn = createConnection();

            String sql = "SELECT product, price FROM product WHERE category=?";

            PreparedStatement pst = conn.prepareStatement(sql);

            // category ko ? me set karna
            pst.setString(1, category);

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

        searchByCategory();

    }
}