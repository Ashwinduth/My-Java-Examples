import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ListenerServlet1 extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)
{try{
req.setAttribute("attr2","kiran");

res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body> hello");
out.println("</html></body>");
req.removeAttribute("attr2");
}catch(Exception e){}

}
}