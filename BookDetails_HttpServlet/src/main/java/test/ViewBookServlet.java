package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewBookServlet extends HttpServlet
{
	public RetrieveDAO ob=null;
	public ArrayList<BookDetailsBean> al=null;
 public void init()throws ServletException
 {
	 ob=new RetrieveDAO();
	 al=new ArrayList<BookDetailsBean>();
 }
 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 Cookie ck[]=req.getCookies();
	 if(ck==null)
	 {
		 pw.println("Session expired.....LogIn Again..<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("login.html");
		 rd.include(req, res);
	 }
	 else
	 {
		 String fName=ck[0].getValue();
		 ArrayList<BookDetailsBean> al=ob.view();
		 if(al.isEmpty())
		 {
			 pw.println("No Records Found...."+fName+"<br>");
		 }
		 else
		 {
			 pw.println("Mr."+fName+"Here Is Details....<br>");
			 Spliterator<BookDetailsBean> sp=al.spliterator();
             pw.println("<table border='5' align='center'  style='width:500px;'>");
		     pw.println("<caption>BookDetails Details</caption>");
             pw.println("<th>Book Code</th>");
             pw.println("<th>Book Name</th>");
             pw.println("<th>Book Author</th>");
             pw.println("<th>Book Price</th>");
    
		 sp.forEachRemaining((k)->
		 {
			 BookDetailsBean bb=(BookDetailsBean)k;
			  pw.println("<tr>");
			 pw.println("<td>"+bb.getbCode()+"</td>");
			 pw.println("<td>"+bb.getbName()+"</td>");
			 pw.println("<td>"+bb.getAname()+"</td>");
			 pw.println("<td>"+bb.getbPrice()+"</td>");
			 pw.println("</tr>");
		 });
           pw.println("</table>");
		 }
			 RequestDispatcher rd=req.getRequestDispatcher("choice.html");
			 rd.include(req, res);
		 
	 }
 }
 public void destroy()
 {
	 ob=null;
	 al=null;
 }
}
