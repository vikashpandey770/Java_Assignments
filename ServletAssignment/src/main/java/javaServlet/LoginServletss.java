import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Dummy check — replace with real DB/user validation as needed.
        if (username != null && !username.trim().isEmpty()
                && password != null && !password.trim().isEmpty()) {

            // Create (or get existing) session and store the username
            HttpSession session = request.getSession(); // true by default -> creates if not exists
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(30 * 60); // optional: 30 min timeout

            // Redirect to home after successful login
            response.sendRedirect("HomeServlet");

        } else {
            request.setAttribute("error", "Invalid username or password.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
