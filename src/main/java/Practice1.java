import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Practice1 {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO","root","Biswajeet@12345");
		
		Statement stmt = conn.createStatement();
		
		
		System.out.println("DISPLAYS EMPLOYEE DETAILS: ");
		ResultSet rs = stmt.executeQuery("SELECT * FROM emp"); //READ
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
		
		
		System.out.println("Newly Inserted records: ");
		
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO emp VALUES(?, ?)"); //CREATE
		
		int c = 0;
		
		pstmt.setInt(1, 120);
		pstmt.setString(2, "Rahul");
		c += pstmt.executeUpdate();
		
		pstmt.setInt(1, 123);
		pstmt.setString(2, "Ronak");
		c += pstmt.executeUpdate();
		
		System.out.println(c + " Inserted Records");
		
		ResultSet rs1 = pstmt.executeQuery("SELECT * FROM emp");
		while(rs1.next()) {
			System.out.println(rs1.getInt(1) + " " + rs1.getString(2));
		}
		
		
        System.out.println("Updated records: ");
		
		PreparedStatement pstmt1 = conn.prepareStatement("UPDATE emp SET emp_name = ? WHERE emp_id = ?"); //UPDATE
		
		int c1 = 0;
		
		
		pstmt1.setString(1, "Vijay");
	    pstmt1.setInt(2, 120);        
		c1 += pstmt1.executeUpdate();
		
		System.out.println(c1 + " Updated Records");
		
		ResultSet rs2 = pstmt1.executeQuery("SELECT * FROM emp");
		while(rs2.next()) {
			System.out.println(rs2.getInt(1) + " " + rs2.getString(2));
		}
		
		
        System.out.println("Deleted records: ");
		
		PreparedStatement pstmt2 = conn.prepareStatement("DELETE FROM emp WHERE emp_id = ? "); //DELETE
		
		int c2 = 0;
		
		
	    pstmt2.setInt(1, 103);        
		c2 += pstmt2.executeUpdate();
		
		System.out.println(c2 + " Deleted Records");
		
		ResultSet rs3 = pstmt2.executeQuery("SELECT * FROM emp");
		while(rs3.next()) {
			System.out.println(rs3.getInt(1) + " " + rs3.getString(2));
		}
		
		
		
		
		
		conn.close();
	}

}
