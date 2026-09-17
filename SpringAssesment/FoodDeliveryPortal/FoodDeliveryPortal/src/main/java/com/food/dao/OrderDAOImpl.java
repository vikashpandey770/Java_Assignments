package com.food.dao;
import org.springframework.jdbc.core.JdbcTemplate; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Repository;
@Repository public class OrderDAOImpl implements OrderDAO { @Autowired private JdbcTemplate jdbcTemplate; public void placeOrder(int restaurantId,String itemName,int quantity,String customerName){ String sql="INSERT INTO orders (restaurant_id,item_name,quantity,customer_name,status) VALUES (?,?,?,?,?)"; jdbcTemplate.update(sql,restaurantId,itemName,quantity,customerName,"PENDING"); } }
