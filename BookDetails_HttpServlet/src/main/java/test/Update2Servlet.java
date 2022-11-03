package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/updateBook")
public class Update2Servlet extends HttpServlet
{
	public UpdateDAO ud=null;
	
 public void init()throws ServletException
 {
	 ud=new UpdateDAO();
 }
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 int k=ud.update(req);
	if(k>0)
	 {
		 pw.println("Record Inserted Successfully..<br>");
	 }
	 else
	 {
		 pw.println("Record Not Inserted.........<br>");
	 }
	 RequestDispatcher rd=req.getRequestDispatcher("choice.html");
	 rd.include(req, res);
	 
}
			 
 public void destroy()
 {
	 ud=null;
 }
}
