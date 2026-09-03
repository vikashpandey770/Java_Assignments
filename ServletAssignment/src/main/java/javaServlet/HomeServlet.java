import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // false -> do NOT create a new session, just check if one already exists
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html><body style='font-family:Arial;text-align:center;margin-top:60px;'>");
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("<p>You are logged in.</p>");
            out.println("<a href='LogoutServlet'>Logout</a>");
            out.println("</body></html>");

        } else {
            // No active session -> send back to login page
            response.sendRedirect("login.jsp");
        }
    }
}
