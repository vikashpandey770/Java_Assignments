package javaUtil;

/*
 * MVC ROLE: UTILITY
 * Provides a reusable database connection.
 */

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/userdb";

    private static final String USER = "root";

    private static final String PASSWORD =
            "your_mysql_password";

    public static Connection getConnection()
            throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found", e);
        }

        return (Connection) DriverManager.getConnection(
                URL, USER, PASSWORD);
    }
}
