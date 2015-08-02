import javax.servlet.*;
import java.io.*;
public class MyFilter implements Filter
{
FilterConfig config;
public void init( FilterConfig config) throws ServletException
{
this.config=config;
System.out.println("\n---- MyFilter created----");
}
public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws ServletException,IOException
{
PrintWriter out=res.getWriter();
ServletContext ctx=config.getServletContext();
Integer count=(Integer)ctx.getAttribute("count");
if(count==null)
count=new Integer(0);
count=new Integer(count.intValue()+1);
ctx.setAttribute("count",count);
out.println("<BR> Filter output from MyFilter response <BR> ");
chain.doFilter(req,res);
out.println("<BR> Filter output from MyFilter response <BR> ");

}


public void destroy(){
System.out.println("\n---- MyFilter destroyed----");
}
}