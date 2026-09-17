package com.foodorder.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.foodorder.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertOrder(Order o) {
        String sql = "INSERT INTO orders(customer_name, restaurant_name, total_amount, status) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, o.getCustomerName(), o.getRestaurantName(), o.getTotalAmount(), o.getStatus());
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT order_id, customer_name, restaurant_name, total_amount, status FROM orders ORDER BY order_id DESC";
        RowMapper<Order> mapper = (rs, rowNum) -> {
            Order o = new Order();
            o.setOrderId(rs.getInt("order_id"));
            o.setCustomerName(rs.getString("customer_name"));
            o.setRestaurantName(rs.getString("restaurant_name"));
            o.setTotalAmount(rs.getDouble("total_amount"));
            o.setStatus(rs.getString("status"));
            return o;
        };
        return jdbcTemplate.query(sql, mapper);
    }
}
