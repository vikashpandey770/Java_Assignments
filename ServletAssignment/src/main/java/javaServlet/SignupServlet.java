package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Keep username and email after forwarding
        request.setAttribute("username", username);
        request.setAttribute("email", email);

        // Empty field validation
        if (username == null || username.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {

            request.setAttribute(
                    "error",
                    "All fields are required."
            );

            request.getRequestDispatcher("signup.jsp")
                   .forward(request, response);

            return;
        }

        // Password validation
        if (password.length() < 6) {

            request.setAttribute(
                    "error",
                    "Password must be at least 6 characters."
            );

            request.getRequestDispatcher("signup.jsp")
                   .forward(request, response);

            return;
        }

        // Email validation
        if (!email.contains("@") || !email.endsWith(".com")) {

            request.setAttribute(
                    "emailError",
                    "Please enter a valid email address."
            );

            request.getRequestDispatcher("signup.jsp")
                   .forward(request, response);

            return;
        }

        // Successful signup
        request.getRequestDispatcher("success.jsp")
               .forward(request, response);
    }
}