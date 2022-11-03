package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet
{
	public DeleteDAO ob=null;
 public void init()throws ServletException
 {
	 ob=new DeleteDAO();
 }
 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 Cookie[] ck=req.getCookies();
	 if(ck==null)
	 {
		 pw.println("Session Expired LogIn Again....<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("login.html");
		 rd.include(req, res);
	 }
	 else
	 {
		 int k=ob.delete();
		 String fName=ck[0].getName();
		 if(k>0)
		 {
			 pw.println("Mr.."+fName);
			 pw.println("Records Deleted SuccessFully.....<br>");
		 }
		 RequestDispatcher rd=req.getRequestDispatcher("choice.html");
		 rd.include(req, res);
	 }
 }
 public void destroy()
 {
	 ob=null;
 }
}
