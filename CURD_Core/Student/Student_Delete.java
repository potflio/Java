package Student;

import java.sql.*;

import java.util.Scanner;

public class Student_Delete {
	
	public void del() {
	String url = "jdbc:mysql://localhost:3306/monika"; // Change "testdb" to your database name
    String user = "root";  // MySQL username
    String password = "";  // MySQL password

    // SQL Delete Query
    String deleteQuery = "DELETE FROM student WHERE sno = ?";

    try {
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("✅ Connected to MySQL successfully!");

        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the Serial Number You Want to Delete:");
        int sno = scan.nextInt();
        
        PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
        pstmt.setInt(1, sno); 

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
