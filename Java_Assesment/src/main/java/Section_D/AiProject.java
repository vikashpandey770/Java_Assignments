package Section_D;


import java.sql.*;
import java.util.*;

public class AiProject {

    static final String URL = "jdbc:mysql://localhost:3306/food_delivery";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        String sql = "SELECT restaurant_name, COUNT(*) AS orders, " +
                     "SUM(amount) AS revenue " +
                     "FROM food_orders GROUP BY restaurant_name";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean found = false;

            System.out.println("Restaurant Report");
            System.out.println("-------------------------------------------");

            while (rs.next()) {
                found = true;

                System.out.printf("%-20s Orders: %-5d Revenue: Rs.%.2f%n",
                        rs.getString("restaurant_name"),
                        rs.getInt("orders"),
                        rs.getDouble("revenue"));
            }

            if (!found) {
                System.out.println("No orders found.");
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}