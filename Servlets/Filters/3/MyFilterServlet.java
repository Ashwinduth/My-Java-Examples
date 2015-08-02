import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;


public class MyFilterServlet extends HttpServlet
{
public void init()
{
System.out.println("\n---- MyFilterServlet created----");
}
public void service(HttpServletRequest req,HttpServletResponse res)
{try{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
String value=getServletConfig().getInitParameter("value");
out.println("<BR> in servlet , value = "+value);
}catch(Exception e){}

}
public void destroy(){
System.out.println("\n---- MyFilter destroyed----");
}
}