package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	  throws IOException,ServletException {
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
			pw.println("User page of : "+ub.getFname()+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
			pw.println("<br>"+ub.getFname()+ "&nbsp&nbsp"+ub.getLname()+"&nbsp&nbsp"
					+ub.getMid()+"&nbsp&nbsp"+ub.getAddr()+"&nbsp&nbsp"+ub.getPhno());
		}
	}

}
