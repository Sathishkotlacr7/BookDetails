package test;
import java.sql.*;
import javax.servlet.http.*;
public class VerifyRecordDAO 
{
	public BookDetailsBean bb=null;
  public BookDetailsBean verify(HttpServletRequest req)
  {
	  try
	  {
		   Connection con=DBConnection.getConn();
           PreparedStatement ps=con.prepareStatement
        		   ("Select*from BookDetails48 where BCode=?");
           ps.setString(1, req.getParameter("code"));
           ResultSet rs=ps.executeQuery();
           if(rs.next())
           {
        	   bb=new BookDetailsBean();
        	   bb.setbCode(rs.getString(1));
        	   bb.setbName(rs.getString(2));
        	   bb.setAname(rs.getString(3));
        	   bb.setbPrice(Float.parseFloat(rs.getString(4)));           
           }
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return bb;
  }
}
