package Student;

import java.sql.*;
import java.util.Scanner;

public class Student_Insert {
    public void Insert() {
        String url = "jdbc:mysql://localhost:3306/monika";
        String user = "root";
        String password = "";

        String insertQuery = "INSERT INTO student (name, age, class) VALUES (?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL successfully!");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            System.out.print("Enter student class: ");
            String studentClass = scanner.nextLine();

            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, studentClass);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Data inserted successfully!");
            }

            pstmt.close();
            conn.close();
            
            System.out.println("✅ Connection closed!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to MySQL!"+e);
            e.printStackTrace();
        }
    }
}
