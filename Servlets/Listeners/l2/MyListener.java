import javax.servlet.*;

public class MyListener implements ServletRequestListener
{
public void requestInitialized(ServletRequestEvent e)
{

System.out.println("\n---- Request created----\n");
System.out.println(e.getServletRequest());
}
public void requestDestroyed(ServletRequestEvent e){
System.out.println("\n---- Request destroyed----");
}
}