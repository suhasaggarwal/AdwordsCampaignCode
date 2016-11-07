package adwords.campaign.creation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector
{
    
    
   public Connection getPooledConnection(String url)
   {
	   try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   Connection conn = null;
	   try {
		conn = DriverManager.getConnection(url,"root","Qwerty12@");
	    
	   
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return conn;
    }   

}
 

