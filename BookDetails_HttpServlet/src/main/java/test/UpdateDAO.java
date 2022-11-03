package test;
import java.sql.*;
import javax.servlet.http.*;
public class UpdateDAO
{
 public int k=0;
 public int update(HttpServletRequest req)
 {
	 try
	 {
		 Connection con=DBConnection.getConn();
		 PreparedStatement ps=con.prepareStatement
				 ("update BookDetails48 set BName=?,Bauthor=?,Bprice=? where BCode=?");
		 ps.setString(1, req.getParameter("name"));
		 ps.setString(2, req.getParameter("aname"));
		 ps.setFloat(3,Float.parseFloat(req.getParameter("price")));
		 ps.setString(4, req.getParameter("code"));
		  k=ps.executeUpdate();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 return k;
 }
}
