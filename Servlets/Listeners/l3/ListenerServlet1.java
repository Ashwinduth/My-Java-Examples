import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ListenerServlet1 extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)
{try{
ServletContext ctx=getServletContext();
ctx.setAttribute("attr2","kiran");
ctx.removeAttribute("attr1");
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body> adding attr2 removing attr1");
out.println("</html></body>");

}catch(Exception e){}

}
}