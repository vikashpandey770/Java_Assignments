package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Session5Q4 {
public static void main(String[] args) {
	

	
    String url = "jdbc:mysql://localhost:3306/testdb";
    String username = "root";
    String password = "";

    Connection con = null;
    

    try {

        con = DriverManager.getConnection(url, username, password);

        // Transaction start
        con.setAutoCommit(false);

        String sql = "INSERT INTO producs (id, name, price) VALUES (?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        // Product 1
        ps.setInt(1, 101);
        ps.setString(2, "Laptop");
        ps.setDouble(3, 50000);
        ps.executeUpdate();

        // Product 2
        ps.setInt(1, 102);
        ps.setString(2, "Mouse");
        ps.setDouble(3, 1000);
        ps.executeUpdate();

        // Product 3
        ps.setInt(1, 103);
        ps.setString(2, "Keyboard");
        ps.setDouble(3, 2000);
        ps.executeUpdate();

        // Sab insert successful
        con.commit();

        System.out.println("All products inserted successfully.");
        ps.close();
    } catch (Exception e) {
        System.out.println("Insert failed: " + e.getMessage());
        try {
            if (con != null) {
                con.rollback();
                System.out.println("Transaction rolled back.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
}

