package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	  throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			pw.println("Session Expired...<br>");
		} else {
			hs.invalidate();
			pw.println("User Logged Out Successfully...<br>");
		}
		RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
		rd.include(req, res);
	}

}
