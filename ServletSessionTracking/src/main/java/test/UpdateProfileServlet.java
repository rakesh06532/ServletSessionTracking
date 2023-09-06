package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
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
			ub.setAddr(req.getParameter("addr"));
			ub.setMid(req.getParameter("mid"));
			ub.setPhno(Long.parseLong(req.getParameter("phno")));
			int k=new UpdateDAO().update(ub);
			pw.println("User page of : "+ub.getFname()+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
			if(k>0) {
			   pw.println("<br>User updated Successfully...<br>");
			}
		}
	}

}
