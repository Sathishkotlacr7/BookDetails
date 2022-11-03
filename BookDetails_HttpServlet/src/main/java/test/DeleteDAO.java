package test;
import java.sql.*;
public class DeleteDAO 
{
 public int k=0;
 public int delete()
 {
	 try
	 {
		 Connection con=DBConnection.getConn();
		 PreparedStatement ps=con.prepareStatement
				 ("delete from BookDetails48");
		 k=ps.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return k;
 }
}
