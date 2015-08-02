import javax.servlet.*;

public class MyListener implements ServletContextAttributeListener
{
public void attributeAdded(ServletContextAttributeEvent e)
{
System.out.println("\n---- attribute added----\n");
System.out.println(e.getName()+"  added with value: "+e.getValue());
}
public void attributeRemoved(ServletContextAttributeEvent e){
System.out.println("\n---- attribute removed----");
System.out.println(e.getName()+"  removed");
}
public void attributeReplaced(ServletContextAttributeEvent e){
System.out.println("\n---- attribute replaced----");
}
}