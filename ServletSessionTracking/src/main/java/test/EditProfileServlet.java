package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	 throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			pw.println("Session expired...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
			rd.include(req, res);
		}
		else {
			UserBean ub=(UserBean)hs.getAttribute("ubean");
			pw.println("User page of : "+ ub.getFname());
			pw.println("<form action='update' method='post'><br>");
			pw.println("Address: <input type='text' name='addr' "
					+ "value='"+ub.getAddr()+"'><br>");
			pw.println("MailId: <input type='text' name='mid'"
					+"value='"+ub.getMid()+"'><br>");
			pw.println("PhoneNo: <input type='text' name='phno'"
					+"value='"+ub.getPhno()+"'><br>");
			pw.println("<input type='Submit' value='UpdateProfile'>");
			pw.println("</form>");
		}
		
	}

}
