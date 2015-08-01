import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;


import java.io.*;

public class MyServ extends HttpServlet
{
//overriding service method,but passing req and res to service method of httpServlet
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.print("<html><body><h2>Welcome to redirected page</h2></body></html>"); 
}

}
