import javax.servlet.*;
import java.io.*;
public class MyFilter1 implements Filter
{
FilterConfig config;
public void init( FilterConfig config) throws ServletException
{
this.config=config;
System.out.println("\n---- MyFilter1 created----");
}
public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws ServletException,IOException
{
PrintWriter out=res.getWriter();
out.println("<BR>Filter output from MyFilter1 response <BR>");
chain.doFilter(req,res);
out.println("<BR>Filter output from MyFilter1 response <BR>");

}


public void destroy(){
System.out.println("\n---- Myfilter1 destroyed----");
}
}