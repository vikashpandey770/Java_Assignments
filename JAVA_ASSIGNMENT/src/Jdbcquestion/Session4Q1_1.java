package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class Product {

    int id;
    String product;
    int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Create Connection
    public static Connection createConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded....");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/products",
                    "root",
                    ""
            );

            if (conn.isClosed()) {
                System.out.println("Not connected to database");
            } else {
                System.out.println("Connection successfully");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


    // Insert data
    public static void insert() {

        Product pt = new Product();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product name: ");
        pt.setProduct(sc.next());

        System.out.println("Enter price: ");
        pt.setPrice(sc.nextInt());

        try {

            Connection conn = createConnection();

            String sql = "insert into product(product, price) values(?, ?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, pt.getProduct());
            pst.setInt(2, pt.getPrice());

            pst.executeUpdate();

            System.out.println("Data inserted successfully");

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Update data
    public void update() {

        Connection conn = createConnection();

        Product pt = new Product();

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Enter id for update: ");
            int id = sc.nextInt();

            // First check product
            String sql = "select * from product where id=?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                System.out.println("Old product name: "
                        + rs.getString("product"));

                System.out.println("Old price: "
                        + rs.getInt("price"));

            } else {

                System.out.println("Product not found");
                conn.close();
                return;
            }

            rs.close();
            pst.close();


            // New information
            System.out.println("---- Enter new Information ----");

            System.out.println("Enter new product name: ");
            pt.setProduct(sc.next());

            System.out.println("Enter new price: ");
            pt.setPrice(sc.nextInt());


            // Update query
            String sq = "update product set product=?, price=? where id=?";

            pst = conn.prepareStatement(sq);

            pst.setString(1, pt.getProduct());
            pst.setInt(2, pt.getPrice());
            pst.setInt(3, id);

            pst.executeUpdate();

            System.out.println("Update successfully");

            pst.close();
            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    
    
    // show
    public static void selectProducts() {

        Connection conn = createConnection();

        try {

            String sql = "SELECT product, price FROM product";

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();


            System.out.println("--------------------------------");
            System.out.printf("%-15s %-10s%n", "Product", "Price");
            System.out.println("--------------------------------");

            while (rs.next()) {

                String product = rs.getString("product");
                int price = rs.getInt("price");

                System.out.printf("%-15s %-10d%n", product, price);
            }

            System.out.println("--------------------------------");


            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    
    
    
}


public class Session4Q1_1 {

    public static void main(String[] args) {

        Product pd = new Product();

        pd.createConnection();

//        pd.insert();

  //      pd.update();
        pd.selectProducts();
    }
    }
}