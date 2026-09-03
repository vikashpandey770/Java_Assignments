package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get selected item from URL
        String item = request.getParameter("item");

        if (item != null && !item.isEmpty()) {

            // Create cookie
            Cookie cartCookie = new Cookie("cartItem", item);

            // Cookie will remain for 10 minutes
            cartCookie.setMaxAge(10 * 60);

            // Make cookie available throughout the website
            cartCookie.setPath("/");

            // Add cookie to response
            response.addCookie(cartCookie);

            response.setContentType("text/html");

            response.getWriter().println("<h2>Item added to cart: " + item + "</h2>");
            response.getWriter().println("<p>Cart will be remembered for 10 minutes.</p>");

        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h2>No item selected.</h2>");
        }
    }
}