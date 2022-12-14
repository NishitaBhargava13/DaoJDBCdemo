package dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection con;
	
	public static Connection dbCon() {
		try {
			
			//driver loading
			 Class.forName("com.mysql.cj.jdbc.Driver"); //for mySQL server 8,here driver class is present in cj folder
//			 Class.forName("com.mysql.jdbc.Driver");//for mySQL server 5
			 
			 
			 
			//connection  estab...
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb" , "root", "root");
			 System.out.println("Con establ....");
			 
		}catch(Exception e) {
			System.out.println("Error: "+e);
		}
		
		return con;
	}
	 
}
