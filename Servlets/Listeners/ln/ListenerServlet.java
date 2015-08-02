import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name="ListenerServlet",urlPatterns={"myst"})
public class ListenerServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)
{try{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body>");
ServletContext ctx=getServletContext();
String name=(String)ctx.getAttribute("con");
out.println("name= "+name);
out.println("</html></body>");
}catch(Exception e){}

}
}