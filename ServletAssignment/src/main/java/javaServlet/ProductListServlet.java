package javaServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/product")
public class ProductListServlet extends HttpServlet {

    private static final String URL =
            "jdbc:mysql://localhost:3306/testdb";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String sql = "SELECT id, name, price FROM products";

        try {

            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create database connection
            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // Execute SELECT query
            ResultSet rs = ps.executeQuery();

            // HTML Output
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Product List</title>");

            out.println("<style>");

            out.println("body {");
            out.println("    font-family: Arial;");
            out.println("    background-color: #f2f2f2;");
            out.println("}");

            out.println("h2 {");
            out.println("    text-align: center;");
            out.println("}");

            out.println("table {");
            out.println("    margin: auto;");
            out.println("    border-collapse: collapse;");
            out.println("    background-color: white;");
            out.println("}");

            out.println("th, td {");
            out.println("    border: 1px solid black;");
            out.println("    padding: 10px 20px;");
            out.println("}");

            out.println("th {");
            out.println("    background-color: #333;");
            out.println("    color: white;");
            out.println("}");

            out.println("</style>");

            out.println("</head>");
            out.println("<body>");

            out.println("<h2>Product List</h2>");

            out.println("<table>");

            // Table headings
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Price</th>");
            out.println("</tr>");

            // Get all products
            while (rs.next()) {

                int id = rs.getInt("id");

                String name = rs.getString("name");

                double price = rs.getDouble("price");

                out.println("<tr>");

                out.println("<td>" + id + "</td>");

                out.println("<td>" + name + "</td>");

                out.println("<td>₹" + price + "</td>");

                out.println("</tr>");
            }

            out.println("</table>");

            out.println("</body>");
            out.println("</html>");

            // Close resources
            rs.close();
            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {

            out.println("<h3>MySQL JDBC Driver not found!</h3>");

            e.printStackTrace();

        } catch (SQLException e) {

            out.println("<h3>Database connection error!</h3>");

            out.println("<p>" + e.getMessage() + "</p>");

            e.printStackTrace();
        }
    }
    
    
    /* 
     * session 11 quesion no 4 ka answer
     * 
     String name = request.getParameter("name");

String sql;

if (name != null && !name.trim().isEmpty()) {
    sql = "SELECT id, name, price FROM products " +
          "WHERE LOWER(name) LIKE LOWER(?)";
} else {
    sql = "SELECT id, name, price FROM products";
}

PreparedStatement ps = con.prepareStatement(sql);

if (name != null && !name.trim().isEmpty()) {
    ps.setString(1, "%" + name + "%");
}

ResultSet rs = ps.executeQuery();

while (rs.next()) {
    products.add(new Product(
        rs.getInt("id"),
        rs.getString("name"),
        rs.getDouble("price")
    ));
}

request.setAttribute("products", products);

request.getRequestDispatcher("products.jsp")
       .forward(request, response);
     */
}