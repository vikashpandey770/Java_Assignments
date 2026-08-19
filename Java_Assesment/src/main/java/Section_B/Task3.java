package Section_B;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Task3 {

    // Database details
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/food_delivery";

    private static final String DB_USER = "root";

    private static final String DB_PASSWORD = "root";


    // INSERT ORDER
    public static int insertOrder(String customerId,
                                   String restaurantName,
                                   double amount) {

        String sql = "INSERT INTO food_orders " +
                     "(customer_id, restaurant_name, amount) " +
                     "VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD);

             PreparedStatement ps = con.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS)) {

            // Set values
            ps.setString(1, customerId);
            ps.setString(2, restaurantName);
            ps.setDouble(3, amount);

            // Execute INSERT
            ps.executeUpdate();

            // Get auto-generated order ID
            try (ResultSet rs = ps.getGeneratedKeys()) {

                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    // GET ORDERS BY CUSTOMER
    public static ArrayList<String> getOrdersByCustomer(
            String customerId) {

        ArrayList<String> orders = new ArrayList<>();

        String sql = "SELECT order_id, restaurant_name, amount " +
                     "FROM food_orders " +
                     "WHERE customer_id = ?";

        try (Connection con = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD);

             PreparedStatement ps = con.prepareStatement(sql)) {

            // Set customer ID
            ps.setString(1, customerId);

            // Execute SELECT
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    int orderId = rs.getInt("order_id");

                    String restaurant =
                            rs.getString("restaurant_name");

                    double amount =
                            rs.getDouble("amount");

                    // Required format
                    String order = "ORDER#" + orderId
                            + " | " + restaurant
                            + " | Rs." + amount;

                    orders.add(order);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }


    // MAIN METHOD
    public static void main(String[] args) {

        // Insert order
        int orderId = insertOrder(
                "C101",
                "Dominos",
                599.50
        );

        System.out.println(
                "Generated Order ID: " + orderId
        );


        // Get orders of customer
        ArrayList<String> orders =
                getOrdersByCustomer("C101");

        System.out.println("\nCustomer Orders:");

        for (String order : orders) {
            System.out.println(order);
        }
    }
}