package com.foodorder.controller;

import java.io.IOException;
import com.foodorder.dao.OrderDAO;
import com.foodorder.dao.impl.OrderDAOImpl;
import com.foodorder.model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orders")
public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("orders", orderDAO.getAllOrders());
        request.getRequestDispatcher("/orders.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String customerName = request.getParameter("customerName");
        String restaurantName = request.getParameter("restaurantName");
        double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
        String status = request.getParameter("status");

        Order order = new Order(customerName, restaurantName, totalAmount, status);
        orderDAO.placeOrder(order);
        response.sendRedirect(request.getContextPath() + "/confirmation.jsp");
    }
}
