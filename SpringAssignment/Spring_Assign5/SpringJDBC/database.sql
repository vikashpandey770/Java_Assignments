CREATE DATABASE restaurantdb;
USE restaurantdb;
CREATE TABLE restaurants (id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(100),cuisine VARCHAR(100),rating DOUBLE);
INSERT INTO restaurants(name,cuisine,rating) VALUES ('Tops Restaurant','Indian',4.5),('Food Palace','Chinese',4.2),('Pizza Hub','Italian',3.8),('Royal Restaurant','Indian',4.7),('Spice Garden','Punjabi',4.3);
SELECT * FROM restaurants;
