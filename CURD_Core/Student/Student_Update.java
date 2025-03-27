package Student;

import java.sql.*;


import java.util.Scanner;

public class Student_Update {
	public void change() {
	String url = "jdbc:mysql://localhost:3306/monika"; // Change "testdb" to your database name
    String user = "root";  // MySQL username
    String password = "";  // MySQL password

    // SQL Update Query
    String updateQuery = "UPDATE student SET name = ? ,age = ? ,class = ? WHERE sno = ?";

    try {
        // 1️⃣ Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2️⃣ Establish Connection
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("✅ Connected to MySQL successfully!");
        
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the Serial Number:");
        int sno = scan.nextInt();
        
        System.out.println("Enter student name: ");
        String name = scan.next();
        System.out.println("Enter student age: ");
        int age = scan.nextInt();
        System.out.println("Enter student class: ");
        String studentClass = scan.next();
        
        // 3️⃣ Create PreparedStatement
        PreparedStatement pstmt = conn.prepareStatement(updateQuery);
        pstmt.setString(1, name); 
        pstmt.setInt(2, age);
        pstmt.setString(3, studentClass);
        pstmt.setInt(4, sno); 

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
    } catch (SQLException e) {
        System.out.println("Failed to connect to MySQL!");
    }
}
}
