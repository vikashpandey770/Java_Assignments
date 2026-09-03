
package javaServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String productId = request.getParameter("productId");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Check productId
        if (productId == null || productId.trim().isEmpty()) {

            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            out.println("<h2>Product not found</h2>");

        } else {

            try {

                int id = Integer.parseInt(productId);

                // Valid product IDs: 1, 2, 3
                if (id >= 1 && id <= 3) {

                    response.setStatus(HttpServletResponse.SC_OK);

                    out.println("<h2>Product details for " + productId + "</h2>");

                } else {

                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);

                    out.println("<h2>Product not found</h2>");
                }

            } catch (NumberFormatException e) {

                response.setStatus(HttpServletResponse.SC_NOT_FOUND);

                out.println("<h2>Product not found</h2>");
            }
        }
    }

}