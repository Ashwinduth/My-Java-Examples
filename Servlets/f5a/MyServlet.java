import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
@WebServlet (name="MyServlet",urlPatterns={"myst"})
public class MyServlet implements Servlet
{
public void init(ServletConfig con)
 {
 
 }
public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.print("<html><body>");  
out.print("<b>hello simple servlet</b>");  
out.print("</body></html>");  
}
public void destroy(){}
public ServletConfig getServletConfig(){
return null;
}
public String getServletInfo()
{
return "MyServlet";
}
}
