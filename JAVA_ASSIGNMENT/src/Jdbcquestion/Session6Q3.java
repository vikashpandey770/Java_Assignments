package Jdbcquestion;

import java.sql.*;

public class Session6Q3 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM products";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Get metadata
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("Product Table Columns:");
            System.out.println("----------------------");
            for (int i = 1; i <= columnCount; i++) {

                String columnName = metaData.getColumnName(i);
                String dataType = metaData.getColumnTypeName(i);

                System.out.println(
                    "Column Name: " + columnName +
                    " | Data Type: " + dataType
                );
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Database error occurred.");
        }
    }
}
