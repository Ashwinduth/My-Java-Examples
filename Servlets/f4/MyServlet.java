import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;


import java.io.*;

public class MyServlet extends HttpServlet
{
//overriding service method,but passing req and res to service method of httpServlet
public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.print("<html><body>Welcome"); 
super.service(req,res);
}
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
String name=req.getParameter("name1");
PrintWriter out=res.getWriter();
out.print("<p>Get parameter="+name+" </p>");  
out.print("</body></html>");
}
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
String name=req.getParameter("name1");
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.print("<html><body>");  
out.print("<p>Post parameter="+name+" </p>");  
out.print("</body></html>");
}
}
