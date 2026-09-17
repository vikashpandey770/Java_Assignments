SPRING MVC ORDER PLACEMENT - TASK 4

1. Create database/table:
CREATE DATABASE food_delivery;
USE food_delivery;
CREATE TABLE orders (
 order_id INT PRIMARY KEY AUTO_INCREMENT,
 customer_name VARCHAR(100) NOT NULL,
 restaurant_name VARCHAR(100) NOT NULL,
 total_amount DOUBLE NOT NULL,
 status VARCHAR(20) NOT NULL
);

2. Project uses Java 17, Spring MVC 5.3.39, Spring JDBC and javax.servlet, suitable for Tomcat 9.
3. Import as Existing Maven Project in Eclipse/STS.
4. Make sure MySQL is running and update applicationContext.xml if username/password differs.
5. Run on Tomcat 9.
6. Open: http://localhost:8080/SpringMVCOrder/
7. Submit form -> POST /orders/place -> database insert -> redirect -> GET /orders/list -> JSP table.
