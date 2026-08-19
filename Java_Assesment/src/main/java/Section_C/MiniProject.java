package Section_C;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MiniProject {
    // =====================================================
    // DATABASE DETAILS
    // =====================================================
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/food_delivery";

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    // =====================================================
    // CUSTOMER
    // =====================================================
    private static final String CUSTOMER_ID = "C101";
    // =====================================================
    // ARRAYLIST MENU AND CART
    // =====================================================
    private static ArrayList<MenuItem> menu =
            new ArrayList<>();
    private static ArrayList<MenuItem> cart =
            new ArrayList<>();


    // =====================================================
    // MENU ITEM CLASS
    // =====================================================

    static class MenuItem {

        private int itemId;
        private String name;
        private double price;
        private boolean available;
        private String restaurantName;


        // Constructor
        public MenuItem(int itemId,
                        String name,
                        double price,
                        boolean available,
                        String restaurantName) {

            this.itemId = itemId;
            this.name = name;
            this.price = price;
            this.available = available;
            this.restaurantName = restaurantName;
        }


        // Getters
        public int getItemId() {
            return itemId;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public boolean isAvailable() {
            return available;
        }

        public String getRestaurantName() {
            return restaurantName;
        }


        // Setters
        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public void setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
        }
    }


    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        // Load menu from database
        loadMenu();


        // If menu is empty
        if (menu.isEmpty()) {

            System.out.println(
                    "No menu items found in database."
            );

            scanner.close();
            return;
        }


        System.out.println(
                "=========================================="
        );

        System.out.println(
                "       FOOD DELIVERY CONSOLE APP"
        );

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "Customer ID: " + CUSTOMER_ID
        );


        // =================================================
        // MENU LOOP
        // =================================================

        while (true) {

            System.out.println(
                    "\n========== MAIN MENU =========="
            );

            System.out.println(
                    "1. Browse Menu"
            );

            System.out.println(
                    "2. Place Order"
            );

            System.out.println(
                    "3. View My Order History"
            );

            System.out.println(
                    "4. Exit"
            );

            System.out.print(
                    "Enter your choice: "
            );


            String input = scanner.nextLine();

            int choice;


            // Non-numeric input handling
            try {

                choice = Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a number."
                );

                continue;
            }


            // =================================================
            // SWITCH
            // =================================================

            switch (choice) {

                case 1:

                    browseMenu();

                    break;


                case 2:

                    placeOrder(scanner);

                    break;


                case 3:

                    viewOrderHistory();

                    break;


                case 4:

                    System.out.println(
                            "\nThank you for using Food Delivery App!"
                    );

                    scanner.close();

                    return;


                default:

                    System.out.println(
                            "Invalid choice! Please select 1-4."
                    );
            }
        }
    }


    // =====================================================
    // LOAD MENU FROM MYSQL
    // =====================================================

    private static void loadMenu() {

        String sql =
                "SELECT item_id, name, price, " +
                "is_available, restaurant_name " +
                "FROM menu_items";


        try (Connection conn =
                     DriverManager.getConnection(
                             DB_URL,
                             DB_USER,
                             DB_PASSWORD);

             PreparedStatement ps =
                     conn.prepareStatement(sql);

             ResultSet rs =
                     ps.executeQuery()) {


            while (rs.next()) {

                int itemId =
                        rs.getInt("item_id");

                String name =
                        rs.getString("name");

                double price =
                        rs.getDouble("price");

                boolean available =
                        rs.getBoolean("is_available");

                String restaurant =
                        rs.getString("restaurant_name");


                MenuItem item =
                        new MenuItem(
                                itemId,
                                name,
                                price,
                                available,
                                restaurant
                        );


                menu.add(item);
            }


        } catch (SQLException e) {

            System.out.println(
                    "Error loading menu: "
                            + e.getMessage()
            );
        }
    }


    // =====================================================
    // BROWSE MENU
    // =====================================================

    private static void browseMenu() {

        System.out.println(
                "\n================ MENU ================"
        );


        System.out.printf(
                "%-8s %-25s %-12s %-15s %-15s%n",
                "ID",
                "Name",
                "Price",
                "Status",
                "Restaurant"
        );


        System.out.println(
                "-----------------------------------------------------------------------"
        );


        if (menu.isEmpty()) {

            System.out.println(
                    "Menu is empty."
            );

            return;
        }


        for (MenuItem item : menu) {

            String status =
                    item.isAvailable()
                            ? "Available"
                            : "Not Available";


            System.out.printf(
                    "%-8d %-25s Rs.%-9.2f %-15s %-15s%n",
                    item.getItemId(),
                    item.getName(),
                    item.getPrice(),
                    status,
                    item.getRestaurantName()
            );
        }
    }


    // =====================================================
    // PLACE ORDER
    // =====================================================

    private static void placeOrder(
            Scanner scanner) {


        // Clear previous cart
        cart.clear();


        // Show menu
        browseMenu();


        System.out.print(
                "\nEnter Item ID: "
        );


        String input =
                scanner.nextLine();


        int itemId;


        // Numeric validation
        try {

            itemId =
                    Integer.parseInt(input);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid Item ID! Please enter a number."
            );

            return;
        }


        // Find item
        MenuItem selectedItem =
                findItem(itemId);


        if (selectedItem == null) {

            System.out.println(
                    "Item not found."
            );

            return;
        }


        // Availability check
        if (!selectedItem.isAvailable()) {

            System.out.println(
                    "Sorry! This item is not available."
            );

            return;
        }


        // Add to ArrayList cart
        cart.add(selectedItem);


        System.out.println(
                "\nItem added to cart: "
                        + selectedItem.getName()
        );


        // Display cart
        displayCart();


        // Calculate amount
        double total =
                calculateTotal();


        // Negative amount check
        if (total < 0) {

            System.out.println(
                    "Invalid negative amount."
            );

            cart.clear();

            return;
        }


        if (total == 0) {

            System.out.println(
                    "Order amount cannot be zero."
            );

            cart.clear();

            return;
        }


        System.out.println(
                "\nTotal Amount: Rs."
                        + String.format(
                                "%.2f",
                                total
                        )
        );


        System.out.print(
                "Confirm order? (Y/N): "
        );


        String confirmation =
                scanner.nextLine();


        if (!confirmation.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Order cancelled."
            );

            cart.clear();

            return;
        }


        // Restaurant name
        String restaurantName =
                selectedItem.getRestaurantName();


        // =================================================
        // TRANSACTION
        // =================================================

        boolean success =
                placeOrderTransaction(
                        CUSTOMER_ID,
                        restaurantName,
                        total
                );


        if (success) {

            System.out.println(
                    "\nOrder placed successfully!"
            );

            System.out.println(
                    "Restaurant: "
                            + restaurantName
            );

            System.out.println(
                    "Amount: Rs."
                            + String.format(
                                    "%.2f",
                                    total
                            )
            );

        } else {

            System.out.println(
                    "\nOrder failed."
            );

            System.out.println(
                    "No changes were made to your wallet or order."
            );
        }


        cart.clear();
    }


    // =====================================================
    // FIND ITEM
    // =====================================================

    private static MenuItem findItem(int itemId) {

        for (MenuItem item : menu) {

            if (item.getItemId() == itemId) {

                return item;
            }
        }


        return null;
    }


    // =====================================================
    // DISPLAY CART
    // =====================================================

    private static void displayCart() {

        System.out.println(
                "\n========== YOUR CART =========="
        );


        if (cart.isEmpty()) {

            System.out.println(
                    "Cart is empty."
            );

            return;
        }


        for (MenuItem item : cart) {

            System.out.println(
                    item.getName()
                            + " | Rs."
                            + String.format(
                                    "%.2f",
                                    item.getPrice()
                            )
            );
        }
    }


    // =====================================================
    // CALCULATE CART TOTAL
    // =====================================================

    private static double calculateTotal() {

        double total = 0;


        for (MenuItem item : cart) {

            total += item.getPrice();
        }


        return total;
    }


    // =====================================================
    // JDBC TRANSACTION
    // =====================================================

    private static boolean placeOrderTransaction(
            String customerId,
            String restaurantName,
            double amount) {


        String walletSql =
                "UPDATE customers " +
                "SET wallet_balance = " +
                "wallet_balance - ? " +
                "WHERE customer_id = ? " +
                "AND wallet_balance >= ?";


        String orderSql =
                "INSERT INTO orders " +
                "(customer_id, restaurant_name, amount) " +
                "VALUES (?, ?, ?)";


        try (Connection conn =
                     DriverManager.getConnection(
                             DB_URL,
                             DB_USER,
                             DB_PASSWORD)) {


            // Start transaction
            conn.setAutoCommit(false);


            try {


                // =========================================
                // STEP 1: DEDUCT WALLET
                // =========================================

                try (PreparedStatement ps =
                             conn.prepareStatement(
                                     walletSql)) {


                    ps.setDouble(1, amount);

                    ps.setString(2, customerId);

                    ps.setDouble(3, amount);


                    int rows =
                            ps.executeUpdate();


                    if (rows == 0) {

                        throw new SQLException(
                                "Insufficient balance "
                                        + "or customer not found."
                        );
                    }
                }


                // =========================================
                // STEP 2: INSERT ORDER
                // =========================================

                try (PreparedStatement ps =
                             conn.prepareStatement(
                                     orderSql)) {


                    ps.setString(1, customerId);

                    ps.setString(2, restaurantName);

                    ps.setDouble(3, amount);


                    int rows =
                            ps.executeUpdate();


                    if (rows == 0) {

                        throw new SQLException(
                                "Order insertion failed."
                        );
                    }
                }


                // =========================================
                // COMMIT
                // =========================================

                conn.commit();


                return true;


            } catch (Exception e) {


                // =========================================
                // ROLLBACK
                // =========================================

                conn.rollback();


                System.out.println(
                        "Transaction rolled back."
                );

                System.out.println(
                        "Reason: " + e.getMessage()
                );


                return false;
            }


        } catch (SQLException e) {

            System.out.println(
                    "Database error: "
                            + e.getMessage()
            );

            return false;
        }
    }


    // =====================================================
    // VIEW ORDER HISTORY
    // =====================================================

    private static void viewOrderHistory() {


        String sql =
                "SELECT order_id, restaurant_name, " +
                "amount, order_date " +
                "FROM orders " +
                "WHERE customer_id = ? " +
                "ORDER BY order_date DESC";


        System.out.println(
                "\n================ ORDER HISTORY ================"
        );


        try (Connection conn =
                     DriverManager.getConnection(
                             DB_URL,
                             DB_USER,
                             DB_PASSWORD);

             PreparedStatement ps =
                     conn.prepareStatement(sql)) {


            // Parameterised query
            ps.setString(1, CUSTOMER_ID);


            try (ResultSet rs =
                         ps.executeQuery()) {


                boolean found = false;


                System.out.printf(
                        "%-10s %-20s %-15s %-25s%n",
                        "Order ID",
                        "Restaurant",
                        "Amount",
                        "Date"
                );


                System.out.println(
                        "------------------------------------------------------------------"
                );


                while (rs.next()) {

                    found = true;


                    int orderId =
                            rs.getInt("order_id");


                    String restaurant =
                            rs.getString(
                                    "restaurant_name"
                            );


                    double amount =
                            rs.getDouble("amount");


                    String date =
                            rs.getTimestamp(
                                    "order_date"
                            ).toString();


                    System.out.printf(
                            "%-10d %-20s Rs.%-12.2f %-25s%n",
                            orderId,
                            restaurant,
                            amount,
                            date
                    );
                }


                // Empty result handling
                if (!found) {

                    System.out.println(
                            "No order history found."
                    );
                }
            }


        } catch (SQLException e) {

            System.out.println(
                    "Unable to fetch order history."
            );

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}