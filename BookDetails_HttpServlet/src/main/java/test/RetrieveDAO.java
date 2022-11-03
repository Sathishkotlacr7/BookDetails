package test;
import java.util.*;
import java.sql.*;
public class RetrieveDAO
{
 public ArrayList<BookDetailsBean> al=new ArrayList<BookDetailsBean>();
 public ArrayList<BookDetailsBean> view()
 {
	 try 
	 {
		 Connection con=DBConnection.getConn();
		 PreparedStatement ps=con.prepareStatement("Select * from BookDetails48");
		 ResultSet rs=ps.executeQuery();
		while(rs.next())
		 {
			BookDetailsBean bb=new BookDetailsBean();
			 bb.setbCode(rs.getString(1));
			 bb.setbName(rs.getString(2));
			 bb.setAname(rs.getString(3));
			 bb.setbPrice(rs.getFloat(4));
			 al.add(bb);
		 }
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return al;
 }
}
