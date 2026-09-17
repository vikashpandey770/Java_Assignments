package com.foodorder.dao;

import java.util.List;
import com.foodorder.model.Order;

public interface OrderDAO {
    void placeOrder(Order o);
    Order getOrderById(int id);
    List<Order> getAllOrders();
    void updateStatus(int id, String status);
}
