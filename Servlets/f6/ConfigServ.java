import java.io.IOException;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
public class ConfigServ extends HttpServlet{
private ServletConfig con;
public void init(ServletConfig con)throws ServletException{
System.out.println("\n---- Config parameter: "+con.getInitParameter("Sai"));
super.init(con);
}
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
{

//con=getServletConfig();
String s=getInitParameter("Sai");
PrintWriter out=res.getWriter();
out.println("<HTML><BODY>"+s+"</HTML></BODY>");
}

}