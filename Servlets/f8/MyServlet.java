import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;


import java.io.*;

public class MyServlet extends HttpServlet
{
//overriding service method,but passing req and res to service method of httpServlet
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.print("<html><body>Welcome</body></html>"); 
res.sendRedirect("myserv");
//res.sendRedirect("http://localhost:7002/f3/myst?name1=sai");//to other servlets
//res.sendRedirect("www.gsaikiran.com");//to other webpage
}

}
