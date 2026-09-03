package javaServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // GET request
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd =
                request.getRequestDispatcher("addProduct.jsp");

        rd.forward(request, response);
    }

    // POST request
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        // Form se data lena
        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");

        int price = Integer.parseInt(request.getParameter("price"));

        String category = request.getParameter("category");


        // Product object create
        product p = new product();

        p.setId(id);
        p.setName(name);
        p.setPrice(price);
        p.setCategory(category);


        // Session lena
        HttpSession session = request.getSession();


        // Session se product list lena
        List<product> products =
                (List<product>) session.getAttribute("products");


        // Agar list pehle se nahi hai
        if (products == null) {

            products = new ArrayList<>();

        }


        // New product list me add karna
        products.add(p);


        // Updated list session me store karna
        session.setAttribute("products", products);


        // showProduct.jsp par forward
        RequestDispatcher rd =
                request.getRequestDispatcher("showProduct.jsp");

        rd.forward(request, response);
    }
}