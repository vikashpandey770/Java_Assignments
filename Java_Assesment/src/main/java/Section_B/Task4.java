
package Section_B;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task4 {

    // Database details
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/food_delivery";

    private static final String DB_USER = "root";

    private static final String DB_PASSWORD = "root";


    // PLACE ORDER
    public static void placeOrder(String customerId,
                                  int restaurantId,
                                  double orderAmount) {

        String updateCustomer =
                "UPDATE customers " +
                "SET wallet_balance = wallet_balance - ? " +
                "WHERE customer_id = ?";

        String insertOrder =
                "INSERT INTO orders " +
                "(customer_id, restaurant_id, amount) " +
                "VALUES (?, ?, ?)";

        String updateRestaurant =
                "UPDATE restaurants " +
                "SET pending_orders = pending_orders + 1 " +
                "WHERE restaurant_id = ?";


        try (Connection conn = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD)) {

            // Start transaction
            conn.setAutoCommit(false);

            try {

                // ------------------------------------------------
                // 1. Deduct money from customer's wallet
                // ------------------------------------------------
                try (PreparedStatement ps =
                             conn.prepareStatement(updateCustomer)) {

                    ps.setDouble(1, orderAmount);
                    ps.setString(2, customerId);

                    int rows = ps.executeUpdate();

                    if (rows == 0) {
                        throw new SQLException(
                                "Customer not found: " + customerId
                        );
                    }
                }


                // ------------------------------------------------
                // 2. Insert order
                // ------------------------------------------------
                try (PreparedStatement ps =
                             conn.prepareStatement(insertOrder)) {

                    ps.setString(1, customerId);
                    ps.setInt(2, restaurantId);
                    ps.setDouble(3, orderAmount);

                    ps.executeUpdate();
                }


                // ------------------------------------------------
                // 3. Increase restaurant pending orders
                // ------------------------------------------------
                try (PreparedStatement ps =
                             conn.prepareStatement(updateRestaurant)) {

                    ps.setInt(1, restaurantId);

                    int rows = ps.executeUpdate();

                    /*
                     * IMPORTANT:
                     * Non-existent restaurantId does not
                     * automatically throw SQLException.
                     * executeUpdate() returns 0.
                     */
                    if (rows == 0) {
                        throw new SQLException(
                                "Restaurant not found: "
                                        + restaurantId
                        );
                    }
                }


                // All three operations successful
                conn.commit();

                System.out.println(
                        "Order placed successfully."
                );

            } catch (Exception e) {

                // Rollback ALL previous changes
                conn.rollback();

                System.out.println(
                        "Transaction rolled back."
                );

                // Re-throw as descriptive RuntimeException
                throw new RuntimeException(
                        "Order placement failed. " +
                        "All changes have been rolled back.",
                        e
                );
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Database connection/transaction error.",
                    e
            );
        }
    }


    // GET CUSTOMER WALLET BALANCE
    public static double getWalletBalance(String customerId) {

        String sql =
                "SELECT wallet_balance " +
                "FROM customers " +
                "WHERE customer_id = ?";

        try (Connection conn = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD);

             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ps.setString(1, customerId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getDouble("wallet_balance");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    // GET NUMBER OF ORDERS FOR CUSTOMER
    public static int getOrderCount(String customerId) {

        String sql =
                "SELECT COUNT(*) AS total " +
                "FROM orders " +
                "WHERE customer_id = ?";

        try (Connection conn = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD);

             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ps.setString(1, customerId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt("total");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    // MAIN METHOD
    public static void main(String[] args) {

        String customerId = "C101";

        /*
         * Existing customer ID but NON-EXISTENT restaurant ID.
         *
         * For example, if restaurant IDs are 1, 2, 3,
         * using 9999 will make the third UPDATE affect 0 rows.
         */
        int invalidRestaurantId = 9999;

        double orderAmount = 500.00;


        // -----------------------------------------------
        // Check data BEFORE transaction
        // -----------------------------------------------

        double walletBefore =
                getWalletBalance(customerId);

        int ordersBefore =
                getOrderCount(customerId);

        System.out.println("========== BEFORE ==========");

        System.out.println(
                "Wallet Balance: Rs." + walletBefore
        );

        System.out.println(
                "Order Count: " + ordersBefore
        );


        // -----------------------------------------------
        // Try to place order
        // -----------------------------------------------

        try {

            placeOrder(
                    customerId,
                    invalidRestaurantId,
                    orderAmount
            );

        } catch (RuntimeException e) {

            System.out.println(
                    "\nException caught in main:"
            );

            System.out.println(
                    e.getMessage()
            );
        }


        // -----------------------------------------------
        // Check data AFTER rollback
        // -----------------------------------------------

        double walletAfter =
                getWalletBalance(customerId);

        int ordersAfter =
                getOrderCount(customerId);

        System.out.println("\n========== AFTER ROLLBACK ==========");

        System.out.println(
                "Wallet Balance: Rs." + walletAfter
        );

        System.out.println(
                "Order Count: " + ordersAfter
        );


        // -----------------------------------------------
        // Confirm nothing changed
        // -----------------------------------------------

        if (walletBefore == walletAfter
                && ordersBefore == ordersAfter) {

            System.out.println(
                    "\nROLLBACK SUCCESSFUL!"
            );

            System.out.println(
                    "Customer wallet was restored."
            );

            System.out.println(
                    "Order was not saved."
            );

        } else {

            System.out.println(
                    "\nROLLBACK FAILED!"
            );
        }
    }
}