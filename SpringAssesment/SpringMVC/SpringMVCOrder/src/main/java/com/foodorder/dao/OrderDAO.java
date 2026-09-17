package com.foodorder.dao;

import java.util.List;
import com.foodorder.model.Order;

public interface OrderDAO {
    int insertOrder(Order o);
    List<Order> getAllOrders();
}
