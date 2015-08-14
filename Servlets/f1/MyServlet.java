import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;


import java.io.*;

public class MyServlet implements Servlet
{
public void init(ServletConfig con)
 {
 System.out.println("\n\n-----Init called----");
 }
public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
{
System.out.println("\n\n-----Service called----\n");
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.print("<html><body>");  
out.print("<b>hello simple servlet</b>");  
out.print("</body></html>");  
}
public void destroy(){
System.out.println("-----destroy called----");
}
public ServletConfig getServletConfig(){
return null;
}
public String getServletInfo()
{
return null;
}
}
