import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class Session6Q2 {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            String sql = "SELECT * FROM users";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("-------------------");
            }
            con.close();
        } catch (SQLException e) {

            // User-friendly error message
            System.out.println("Unable to connect to the database.");
            System.out.println("Please check your database server and connection details.");

        }
    }
}