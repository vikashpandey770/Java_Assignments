package Jdbcquestion;


import java.sql.*;
import java.util.Scanner;

public class Project_Q4 {

    public void monthlyReport(int userId, String month) {

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = "SELECT categoryid, SUM(amount) AS total "
                   + "FROM Expense "
                   + "WHERE userid = ? "
                   + "AND DATE_FORMAT(date, '%Y-%m') = ? "
                   + "GROUP BY categoryid";

        try (
            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, userId);
            ps.setString(2, month);

            ResultSet rs = ps.executeQuery();

            System.out.println("--------------------------------");
            System.out.println("       MONTHLY EXPENSE REPORT");
            System.out.println("--------------------------------");
            System.out.printf("%-15s %-15s%n", "Category ID", "Total Spent");
            System.out.println("--------------------------------");

            while (rs.next()) {

                int categoryId = rs.getInt("categoryid");
                double total = rs.getDouble("total");

                System.out.printf(
                    "%-15d %-15.2f%n",
                    categoryId,
                    total
                );
            }

            System.out.println("--------------------------------");

        } catch (SQLException e) {
            System.out.println("Unable to generate monthly report.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter month (YYYY-MM): ");
        String month = sc.nextLine();

        Project_Q4 report = new Project_Q4();

        report.monthlyReport(userId, month);

        sc.close();
    }
}