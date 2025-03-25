package jio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlDelete {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/suriya"; // Change "testdb" to your database name
        String user = "root";  // MySQL username
        String password = "";  // MySQL password

        // SQL Delete Query
        String deleteQuery = "DELETE FROM prakash WHERE sno = ?";

        try {
            // 1️⃣ Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL successfully!");

            // 3️⃣ Create PreparedStatement
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, 1); // Delete where id = 1

            // 4️⃣ Execute Delete
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ Data deleted successfully!");
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
