package com.foodorder.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.foodorder.dao.OrderDAO;
import com.foodorder.model.Order;
import com.foodorder.util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public void placeOrder(Order o) {
        String sql = "INSERT INTO orders (customer_name, restaurant_name, total_amount, status) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, o.getCustomerName());
            ps.setString(2, o.getRestaurantName());
            ps.setDouble(3, o.getTotalAmount());
            ps.setString(4, o.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrderById(int id) {
        String sql = "SELECT order_id, customer_name, restaurant_name, total_amount, status FROM orders WHERE order_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Order(rs.getInt("order_id"), rs.getString("customer_name"),
                            rs.getString("restaurant_name"), rs.getDouble("total_amount"), rs.getString("status"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT order_id, customer_name, restaurant_name, total_amount, status FROM orders ORDER BY order_id DESC";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                orders.add(new Order(rs.getInt("order_id"), rs.getString("customer_name"),
                        rs.getString("restaurant_name"), rs.getDouble("total_amount"), rs.getString("status")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void updateStatus(int id, String status) {
        String sql = "UPDATE orders SET status = ? WHERE order_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
