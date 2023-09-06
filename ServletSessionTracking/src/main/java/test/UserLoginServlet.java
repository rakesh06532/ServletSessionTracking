package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/login")

public class UserLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	  throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		UserBean ub=new LoginDAO().login(req);
		if(ub==null) {
			pw.println("Invalid Login Details...<br>");
		}
		else {
			HttpSession hs=req.getSession();//new session created
			hs.setAttribute("ubean",ub);
			pw.println("Welcome User : "+ub.getFname()+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
		}
	}

}
