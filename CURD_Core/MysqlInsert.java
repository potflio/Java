package jio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlInsert {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/suriya"; // Replace 'testdb' with your database name
        String user = "root";  // MySQL username
        String password = "";  // MySQL password (leave empty if no password)

        // SQL Insert Query
        String insertQuery = "INSERT INTO prakash (name, age , class) VALUES (?, ? ,?)";

        try {
            // 1️⃣ Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL successfully!");

            // 3️⃣ Create PreparedStatement
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, "Suriya");
            pstmt.setString(2, "21");
            pstmt.setString(3, "CSE");

            // 4️⃣ Execute Update
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Data inserted successfully!");
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
