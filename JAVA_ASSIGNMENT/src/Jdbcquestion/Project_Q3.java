package Jdbcquestion;

import java.sql.*;
import java.util.Scanner;

public class Project_Q3 {
    public void addExpense(int userId) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Enter category ID: ");
        int categoryId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";
        String sql = "INSERT INTO Expense "
                   + "(userid, amount, date, categoryid, description) "
                   + "VALUES (?, ?, ?, ?, ?)";
        try (
            Connection con = DriverManager.getConnection(
                    url, username, password);
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, userId);
            ps.setDouble(2, amount);
            ps.setString(3, date);
            ps.setInt(4, categoryId);
            ps.setString(5, description);
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Expense added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Unable to add expense.");
        }
    }
    public static void main(String[] args) {
        Project_Q3 controller = new Project_Q3();
        // Logged-in user's ID
        int loggedInUserId = 101;
        controller.addExpense(loggedInUserId);
    }
}