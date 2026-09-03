package javaServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaBeans.Event;

@WebServlet("/EventListServlet")
public class EventListServlet extends HttpServlet {

    private static final String URL =
            "jdbc:mysql://localhost:3306/userdb";

    private static final String DB_USER = "root";

    private static final String DB_PASSWORD =
            "your_mysql_password";

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        List<Event> events = new ArrayList<>();

        String sql = "SELECT * FROM events ORDER BY event_date";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    URL,
                    DB_USER,
                    DB_PASSWORD
            );

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Event event = new Event();

                event.setId(rs.getInt("id"));
                event.setUsername(rs.getString("username"));
                event.setTitle(rs.getString("title"));
                event.setEventDate(rs.getString("event_date"));
                event.setDescription(rs.getString("description"));

                events.add(event);
            }

            rs.close();
            ps.close();
            con.close();

            // Send event list to JSP
            request.setAttribute("events", events);

            // Forward request to JSP
            request.getRequestDispatcher("EventsList.jsp")
                   .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                "<h3>Database Error: "
                + e.getMessage()
                + "</h3>"
            );
        }
    }
}
