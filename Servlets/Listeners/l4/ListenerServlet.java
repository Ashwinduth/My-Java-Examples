import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ListenerServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)
{try{

req.setAttribute("attr1","sai");
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body> hiiii");
out.println("</html></body>");
req.removeAttribute("attr1");
}catch(Exception e){}

}
}