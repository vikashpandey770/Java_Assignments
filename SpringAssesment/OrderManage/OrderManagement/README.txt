TASK 3 - DAO + MVC ORDER MANAGEMENT

1. Create MySQL database/table:

CREATE DATABASE food_delivery;
USE food_delivery;

CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    restaurant_name VARCHAR(100) NOT NULL,
    total_amount DOUBLE NOT NULL,
    status VARCHAR(20) NOT NULL
);

2. DB settings are in:
src/main/java/com/foodorder/util/DBConnection.java
Default: root user, blank password, localhost:3306.

3. Import as Existing Maven Project in Eclipse/STS.
4. Use Tomcat 10/10.1+ because this project uses jakarta.servlet.*.
5. Run on server.
6. Open: http://localhost:8080/OrderManagement/
7. Place an order with PENDING/CONFIRMED/DELIVERED status.
8. After POST, controller redirects to confirmation.jsp.
9. Click View All Orders. GET /orders loads DAO data and forwards it as request attribute 'orders' to orders.jsp.

Layers:
Model -> Order.java
DAO -> OrderDAO.java
DAO Implementation -> OrderDAOImpl.java (JDBC PreparedStatement + exception handling)
Controller -> OrderController.java (Servlet)
View -> index.jsp, orders.jsp, confirmation.jsp
