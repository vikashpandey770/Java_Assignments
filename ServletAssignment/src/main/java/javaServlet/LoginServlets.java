package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/LoginServlets")
public class LoginServlets extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        if ("vikash".equals(username) && "1234".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            if ("yes".equals(rememberMe)) {
                session.setMaxInactiveInterval(30 * 60);

            } else {
                session.setMaxInactiveInterval(10 * 60);
            }
            response.sendRedirect("dashboard.jsp");

        } else {
            response.sendRedirect("login.html?error=invalid");
        }
    }
}