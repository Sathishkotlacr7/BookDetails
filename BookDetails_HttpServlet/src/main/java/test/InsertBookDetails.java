package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/insert")
public class InsertBookDetails extends HttpServlet 
{
  public BookDetailsBean bb=null;
  public InsertDAO ob=null;
 public void init()throws ServletException
 {
	 bb=new BookDetailsBean();
	 ob=new InsertDAO();
 }
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	bb.setbCode(req.getParameter("code")); 
	bb.setbName(req.getParameter("name"));
	bb.setAname(req.getParameter("aname"));
	bb.setbPrice(Float.parseFloat(req.getParameter("price")));
	 Cookie ck[]=req.getCookies();
    if(ck==null)
    {
        pw.println("Session Expired Login again.......<br>");
        RequestDispatcher rd=req.getRequestDispatcher("login.html");
        rd.include(req, res);
    }
    else
    {
    	int k=ob.insert(bb);
    	String fName=ck[0].getValue();
    	if(k>0)
    	{
    		pw.println("Mr."+fName+"&nbsp;Record Inserted Successfully.....<br>");
    	}
    	else
    	{
    		pw.println("Mr."+fName+"Something Problem in Inserting....");
    	}
    	RequestDispatcher rd=req.getRequestDispatcher("choice.html");
    	rd.include(req, res);
    }
 }
 public void destroy()
 {
	 bb=null;
	 ob=null;
 }
}
