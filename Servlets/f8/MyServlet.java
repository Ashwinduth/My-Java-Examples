import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;


import java.io.*;

public class MyServlet extends HttpServlet
{

public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{

System.out.println("-----MyServlet called-----");
System.out.println("----before sendredirect()-----");
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.print("<html><body>Welcome</body></html>"); 

res.sendRedirect("myserv");
System.out.println("----after sendredirect()-----");
//res.sendRedirect("http://localhost:7002/f3/myst?name1=sai");//to other servlets
//res.sendRedirect("www.gsaikiran.com");//to other webpage
}

}
