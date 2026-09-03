package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple login validation
        if ("admin".equals(username) && "1234".equals(password)) {

            // Create session
            HttpSession session = request.getSession();

            // Store username in session
            session.setAttribute("username", username);

            // Go to dashboard
            response.sendRedirect("dashboard.jsp");

        } else {

            response.setContentType("text/html");

            response.getWriter().println("<h2>Invalid username or password</h2>");
            response.getWriter().println("<a href='login.html'>Try Again</a>");
        }
    }
}