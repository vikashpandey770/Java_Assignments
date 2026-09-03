package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaBeans.productdata;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class productdatalistservlet extends HttpServlet {

    private static final String URL =
            "jdbc:mysql://localhost:3306/shopdb";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        List<productdata> products = new ArrayList<>();

        String sql = "SELECT id, name, price FROM products";

        try {

            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection
            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            // Prepare query
            PreparedStatement ps = con.prepareStatement(sql);

            // Execute query
            ResultSet rs = ps.executeQuery();

            // Convert database records into Product objects
            while (rs.next()) {

                int id = rs.getInt("id");

                String name = rs.getString("name");

                double price = rs.getDouble("price");

                productdata productdata =
                        new productdata(id, name, price);

                products.add(productdata);
            }

            // Close resources
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        // Send Product list to JSP
        request.setAttribute("products", products);

        // Forward request to products.jsp
        request.getRequestDispatcher("products.jsp")
               .forward(request, response);
    }
}