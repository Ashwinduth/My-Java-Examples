import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ListenerServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)
{try{
ServletContext ctx=getServletContext();
ctx.setAttribute("attr1","sai");
ctx.removeAttribute("attr2");
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body> adding attr1 removing attr2");
out.println("</html></body>");

}catch(Exception e){}

}
}