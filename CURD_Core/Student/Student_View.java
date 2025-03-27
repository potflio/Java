package Student;

import java.sql.*;


public class Student_View {
	public void view() {
		String url = "jdbc:mysql://localhost:3306/monika"; 
        String user = "root"; 
        String password = ""; 

        
        String query = "SELECT * FROM student"; 

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection conn = DriverManager.getConnection(url, user, password);

            
            
            PreparedStatement pstmt = conn.prepareStatement(query);
      

            
            ResultSet rs = pstmt.executeQuery(query);

            
            while (rs.next()) {
            	int sno = rs.getInt("sno");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String classInfo = rs.getString("class");

                System.out.println( "Name: " + name + ", age: " + age + ", Class:" + classInfo);
            }

            
            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
