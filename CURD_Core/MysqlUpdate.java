package jio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlUpdate {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/suriya"; // Change "testdb" to your database name
        String user = "root";  // MySQL username
        String password = "";  // MySQL password

        // SQL Update Query
        String updateQuery = "UPDATE prakash SET age = ? WHERE sno = ?";

        try {
            // 1️⃣ Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL successfully!");

            // 3️⃣ Create PreparedStatement
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, "25"); // New email
            pstmt.setInt(2, 1); // Update where id = 1

            // 4️⃣ Execute Update
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ Data updated successfully!");
            } else {
                System.out.println("⚠ No record found with the given ID.");
            }

            // 5️⃣ Close Connection
            pstmt.close();
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
