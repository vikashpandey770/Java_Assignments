FOOD DELIVERY ORDER MANAGEMENT PORTAL
Java 17, Spring MVC 5.3.39, Hibernate 6.6.17, MySQL, Tomcat 10/10.1+

1. CREATE DATABASE food_delivery;
2. CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(50) UNIQUE, password VARCHAR(100));
3. INSERT INTO users(username,password) VALUES ('admin','1234');
4. CREATE TABLE orders (order_id INT PRIMARY KEY AUTO_INCREMENT, restaurant_id INT, item_name VARCHAR(100), quantity INT, customer_name VARCHAR(100), status VARCHAR(20));
5. Hibernate automatically creates/updates restaurants and menu_items tables.
6. Add restaurants/menu items using the Hibernate project from Task 2 or SQL.
7. Import as Existing Maven Project.
8. Run on Tomcat 10/10.1+.
9. Open /FoodDeliveryPortal/ then login admin / 1234.

Architecture: MVC Controllers -> DAO -> JDBC/Hibernate -> MySQL; JSP only renders data. Hibernate SessionFactory is Singleton in HibernateUtil. Controllers use @Autowired; no manual DAO new.
