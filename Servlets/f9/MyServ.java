import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;


import java.io.*;

public class MyServ extends HttpServlet
{

public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
String r=(String)req.getAttribute("name");
out.print("<html><body><h2>Welcome to page redirected from: "+r+"</h2></body></html>"); 
}

}
