import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/AddRestaurantServlet")
public class AddRestaurantServlet extends HttpServlet {

    // --- DB configuration: change to match your local MySQL setup ---
    private static final String DB_URL  = "jdbc:mysql://localhost:3306/zomato_clone?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "your_password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String cuisine = request.getParameter("cuisine");
        String message;

        String insertSQL = "INSERT INTO restaurants (name, cuisine) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

            stmt.setString(1, name);
            stmt.setString(2, cuisine);
            int rows = stmt.executeUpdate();

            message = (rows > 0)
                    ? "Restaurant '" + name + "' added successfully!"
                    : "Something went wrong. Please try again.";

        } catch (SQLException e) {
            e.printStackTrace();
            message = "Database error: " + e.getMessage();
        }

        // Forward back to the JSP with a result message
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddRestaurant.jsp");
        dispatcher.forward(request, response);
    }
}
