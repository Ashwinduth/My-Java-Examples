import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
@WebServlet (name="MyServlet",urlPatterns={"/myst"})
public class MyServlet2 extends HttpServlet
{

public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
{
ServletContext ctx=getServletContext();
String nam=getInitParameter("Sai");
String name=ctx.getInitParameter("param");
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.print("<html><body>");  
out.print("<b>MyServlet2 context param="+name+" config para= "+nam+"</b>");  
out.print("</body></html>"); 
}
}
