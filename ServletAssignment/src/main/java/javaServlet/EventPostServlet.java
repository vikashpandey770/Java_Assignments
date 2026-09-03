package javaServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/EventPostServlet")
public class EventPostServlet extends HttpServlet {

    private static final String URL =
            "jdbc:mysql://localhost:3306/userdb";

    private static final String DB_USER = "root";

    private static final String DB_PASSWORD =
            "your_mysql_password";

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        // Get current session
        HttpSession session = request.getSession(false);

        // Check login
        if (session == null ||
            session.getAttribute("username") == null) {

            response.sendRedirect("Login.jsp");
            return;
        }

        // Get logged-in username
        String username =
                (String) session.getAttribute("username");

        // Get form data
        String title = request.getParameter("title");
        String eventDate = request.getParameter("event_date");
        String description = request.getParameter("description");

        String sql = "INSERT INTO events " +
                     "(username, title, event_date, description) " +
                     "VALUES (?, ?, ?, ?)";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    URL,
                    DB_USER,
                    DB_PASSWORD
            );

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, title);
            ps.setString(3, eventDate);
            ps.setString(4, description);

            int result = ps.executeUpdate();

            if (result > 0) {

                response.getWriter().println(
                    "<h2>Event posted successfully!</h2>"
                );

                response.getWriter().println(
                    "<a href='Home.jsp'>Go to Home</a>"
                );

            } else {

                response.getWriter().println(
                    "<h2>Failed to post event.</h2>"
                );
            }

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                "<h2>Database Error</h2>"
            );

            response.getWriter().println(
                e.getMessage()
            );
        }
    }
}
