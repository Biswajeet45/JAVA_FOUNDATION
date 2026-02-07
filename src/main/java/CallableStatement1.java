import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CallableStatement1 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Database1","root","Biswajeet@12345");
		
		System.out.println("READ OPERATION:");
		
		CallableStatement cs = conn.prepareCall("{CALL GetAllCustomers(?,?,?,?)}");
		
		ResultSet rs = cs.executeQuery("SELECT * FROM Customer2");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		}
		
		System.out.println("CREATE OPERATION:");
		
		CallableStatement cs1 = conn.prepareCall("{CALL InsertCustomer(?,?,?,?)}");
		
		cs1.setInt(1, 101);
		cs1.setString(2, "Ravi");
		cs1.setString(3, "1984-09-21");
		cs1.setString(4, "Mumbai");
		cs1.executeUpdate();
		
		cs1.setInt(1, 102);
		cs1.setString(2, "Virat");
		cs1.setString(3, "1982-10-11");
		cs1.setString(4, "Gurgaon");
		cs1.executeUpdate();
		
		cs1.setInt(1, 103);
		cs1.setString(2, "Dhoni");
		cs1.setString(3, "1990-07-16");
		cs1.setString(4, "Ranchi");
		cs1.executeUpdate();
		
		cs1.setInt(1, 104);
		cs1.setString(2, "Rahul");
		cs1.setString(3, "1995-05-10");
		cs1.setString(4, "Bangalore");
		cs1.executeUpdate();
		
        ResultSet rs1 = cs1.executeQuery("SELECT * FROM Customer2");
		
		while(rs1.next()) {
			System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + " " + rs1.getString(3) + " " + rs1.getString(4));
		}
		
		
		System.out.println("UPDATE OPERATION:");
		
		CallableStatement cs2 = conn.prepareCall("{CALL UpdateCustomer(?,?)}");
		
		cs2.setInt(1, 101);
        cs2.setString(2, "Ronak"); 
		cs2.executeUpdate();
		
        ResultSet rs2 = cs2.executeQuery("SELECT * FROM Customer2");
		
		while(rs2.next()) {
			System.out.println(rs2.getInt(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + " " + rs2.getString(4));
		}
		
	    System.out.println("DELETE OPERATION:");
		
	    CallableStatement cs3 = conn.prepareCall("{CALL DeleteCustomers(?)}");
		
	    cs3.setInt(1,104);
	    cs3.executeUpdate();
		
        ResultSet rs3 = cs3.executeQuery("SELECT * FROM Customer2");
		
		while(rs3.next()) {
			System.out.println(rs3.getInt(1) + " " + rs3.getString(2) + " " + rs3.getString(3) + " " + rs3.getString(4));
		}
		
		
		
		conn.close();

	}

}
