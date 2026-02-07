import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimpleDeclaration {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Database1","root","Biswajeet@12345");
		
		System.out.println("READ OPERATION:");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM Customer1");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		}
		
		System.out.println("CREATE OPERATION:");
		
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Customer1(cid,cname,dob,loc) VALUES (?, ?, ?, ?)");
		
		pstmt.setInt(1, 101);
		pstmt.setString(2, "Rohit");
		pstmt.setString(3, "1984-09-21");
		pstmt.setString(4, "Mumbai");
		pstmt.executeUpdate();
		
		pstmt.setInt(1, 102);
		pstmt.setString(2, "Virat");
		pstmt.setString(3, "1982-10-11");
		pstmt.setString(4, "Gurgaon");
		pstmt.executeUpdate();
		
		pstmt.setInt(1, 103);
		pstmt.setString(2, "Dhoni");
		pstmt.setString(3, "1990-07-16");
		pstmt.setString(4, "Ranchi");
		pstmt.executeUpdate();
		
		pstmt.setInt(1, 104);
		pstmt.setString(2, "Rahul");
		pstmt.setString(3, "1995-05-10");
		pstmt.setString(4, "Bangalore");
		pstmt.executeUpdate();
		
        ResultSet rs1 = pstmt.executeQuery("SELECT * FROM Customer1");
		
		while(rs1.next()) {
			System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + " " + rs1.getString(3) + " " + rs1.getString(4));
		}
		
		
		System.out.println("UPDATE OPERATION:");
		
		PreparedStatement pstmt1 = conn.prepareStatement("UPDATE Customer1 SET cname = ? WHERE cid = ?");
		
		pstmt1.setString(1,"Ronak");
		pstmt1.setInt(2,104);
		pstmt1.executeUpdate();
		
        ResultSet rs2 = pstmt1.executeQuery("SELECT * FROM Customer1");
		
		while(rs2.next()) {
			System.out.println(rs2.getInt(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + " " + rs2.getString(4));
		}
		
	    System.out.println("DELETE OPERATION:");
		
		PreparedStatement pstmt2 = conn.prepareStatement("DELETE FROM Customer1 WHERE cid = ?");
		
		pstmt2.setInt(1,104);
		pstmt2.executeUpdate();
		
        ResultSet rs3 = pstmt2.executeQuery("SELECT * FROM Customer1");
		
		while(rs3.next()) {
			System.out.println(rs3.getInt(1) + " " + rs3.getString(2) + " " + rs3.getString(3) + " " + rs3.getString(4));
		}
		
		
		
		conn.close();

	}

}
