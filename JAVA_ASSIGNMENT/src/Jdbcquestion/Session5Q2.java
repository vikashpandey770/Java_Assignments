package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Session5Q2 {

    // Create Connection
    public static Connection createConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/products",
                    "root",
                    ""
            );

            System.out.println("Connection successfully");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return conn;
    }


    // Add multiple movies using batch processing
    public static void addMultipleMovies(List<String> movies) {

        Connection conn = null;

        try {

            conn = createConnection();

            String sql = "INSERT INTO movies(movie_name) VALUES (?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            // Add movies into batch
            for (String movie : movies) {

                pst.setString(1, movie);

                pst.addBatch();
            }

            // Execute all queries together
            int[] result = pst.executeBatch();

            System.out.println(result.length + " movies inserted successfully");

            pst.close();
            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> movies = new ArrayList<>();

        System.out.println("Enter number of movies:");
        int n = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("Enter movie name " + (i + 1) + ":");

            String movie = sc.nextLine();

            movies.add(movie);
        }

        addMultipleMovies(movies);

    }
}