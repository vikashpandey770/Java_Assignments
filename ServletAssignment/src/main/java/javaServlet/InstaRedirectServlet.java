package javaServlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/InstaRedirectServlet")
public class InstaRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set HTTP status code 302	
        response.setStatus(302);

        // Log redirection in server console
        System.out.println("Redirecting to TrendingServlet");

        // Redirect to TrendingServlet
        response.sendRedirect("TrendingServlet");
    }
}