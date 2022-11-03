package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class ServletUpdate extends HttpServlet
{
	public VerifyRecordDAO vd=null;
	public BookDetailsBean bb=null; 
 public void init()throws ServletException
 {
	 vd=new VerifyRecordDAO();
	 bb=new BookDetailsBean();
 }
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 Cookie[] ck=req.getCookies();
	 if(ck==null)
	 {
		pw.println("Session Expired......LogIn Again...<br>");
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, res);
		
	 }
	 else
	 {
		String fName=ck[0].getValue();
	   bb=vd.verify(req);
	 if(bb==null)
	 {
		    pw.println(fName+"<br>");
		    pw.println("Invalid BookCode...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("choice.html");
			rd.include(req, res);
	 }
	 else
	 {
		 pw.println("<form action='updateBook' method='post'>");
		 pw.println("<input type='hidden' name='code' value='"+bb.getbCode()+"'>");
		 pw.println("Enter BookName:<input type='text' name='name' value='"+bb.getbName()+"'><br>");
		 pw.println("Enter Author Name:<input type='text' name='aname' value='"+bb.getAname()+"'><br>");
		 pw.println("Enter BookPrice:<input type='text' name='price' value='"+bb.getbPrice()+"'><br>");
		 pw.println("<input type='submit' value='UpdateValues'>");
		 pw.println("</form>");	
	 }
	 }
 }
 public void destroy()
 {
	 vd=null;
	 bb=null;
	 
 }
}
