package jio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnector {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/suriya"; // Change "testdb" to your database name
        String user = "root";  // MySQL username
        String password = "";  // MySQL password (keep blank if no password)

        try {
            // 1️⃣ Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL successfully!");

            // 3️⃣ Close Connection
            conn.close();
            System.out.println("✅ Connection closed!");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to MySQL!");
            e.printStackTrace();
        }
    }
}
