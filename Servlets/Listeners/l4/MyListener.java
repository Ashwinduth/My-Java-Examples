import javax.servlet.*;

public class MyListener implements ServletRequestAttributeListener
{
public void attributeAdded(ServletRequestAttributeEvent e)
{
System.out.println("\n---- attribute added----\n");
System.out.println(e.getName()+"  added with value: "+e.getValue());
}
public void attributeRemoved(ServletRequestAttributeEvent e){
System.out.println("\n---- attribute removed----");
System.out.println(e.getName()+"  removed");
}
public void attributeReplaced(ServletRequestAttributeEvent e){
System.out.println("\n---- attribute replaced----");
}
}