import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;


public class MyFilterServlet1 extends HttpServlet
{
public void init()
{
System.out.println("\n---- MyFilterServlet2 created----");
}
public void service(HttpServletRequest req,HttpServletResponse res)
{try{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
//out.println("<html><body>");
ServletContext ctx=getServletContext();
Integer count=(Integer)ctx.getAttribute("count");
out.println("<BR> count = "+count.intValue());
//out.println("</html></body>");
}catch(Exception e){}

}
public void destroy(){
System.out.println("\n---- MyFilter destroyed----");
}
}