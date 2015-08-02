import javax.servlet.*;
import javax.servlet.annotation.*;
@WebListener
public class MyListener implements ServletContextListener
{
public void contextInitialized(ServletContextEvent e)
{
ServletContext ctx=e.getServletContext();
ctx.setAttribute("con","sai");
System.out.println("\n---- context created----");
}
public void contextDestroyed(ServletContextEvent e){
System.out.println("\n---- context destroyed----");
}
}