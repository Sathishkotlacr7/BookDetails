package test;
import java.sql.*;
public class InsertDAO
{
 public int k=0;
 public int insert(BookDetailsBean bb)
 {
	 try
	 {
		 Connection con=DBConnection.getConn();
		 PreparedStatement ps=con.prepareStatement
				 ("insert into bookdetails48 values(?,?,?,?)");
	    ps.setString(1, bb.getbCode());
	    ps.setString(2, bb.getbName());
	    ps.setString(3, bb.getAname());
	    ps.setFloat(4, bb.getbPrice());
	    k=ps.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return k;
 }
}
