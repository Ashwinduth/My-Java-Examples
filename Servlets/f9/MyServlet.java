import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;


import java.io.*;

public class MyServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.print("<html><body>Before Dispatch");
req.setAttribute("name","myServlet");
RequestDispatcher rd=req.getRequestDispatcher("/myserv");
rd.forward(req,res);
//rd.include(req,res);
out.print("</body></html>"); 
}
}
