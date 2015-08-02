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
String value=config.getInitParameter("value");
out.println("value = "+value);
chain.doFilter(req,res);
}

public void destroy(){
System.out.println("\n---- Myfilter1 destroyed----");
}
}