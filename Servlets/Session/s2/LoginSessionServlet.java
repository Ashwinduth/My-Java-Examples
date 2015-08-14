import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class LoginSessionServlet extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{

		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		if(name.equals("sai") && pass.equals("kiran"))
		{

			HttpSession se=req.getSession();
			se.setAttribute("name",name);
			se.setAttribute("pass",pass);
			out.println("user in valid "+se.isNew());
			out.println("</BR>");
			out.println("<a href='demo'>demo</a><BR>");
			out.println("<a href='log'>logout</a><BR>");
		}
		else
			out.println("user is invalid");
	}
}