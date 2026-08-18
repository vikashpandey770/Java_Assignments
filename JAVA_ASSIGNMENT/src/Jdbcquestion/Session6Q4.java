package Jdbcquestion;

import java.sql.*;

public class Session6Q4
{

    public static void main(String[] args) {
        try {
            // Database connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            // Get DatabaseMetaData
            DatabaseMetaData dbMetaData = con.getMetaData();
            // Get all tables
            ResultSet rs = dbMetaData.getTables(
                    null,
                    null,
                    "%",
                    new String[]{"TABLE"}
            );

            System.out.println("Tables in Current Database:");
            System.out.println("----------------------------");

            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                System.out.println(tableName);
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Unable to retrieve table information.");
        }
    }
}