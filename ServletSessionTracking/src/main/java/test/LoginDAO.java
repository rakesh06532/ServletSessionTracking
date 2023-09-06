package test;
import java.sql.*;
import javax.servlet.http.*;

public class LoginDAO {
	public UserBean ub=null;
	public UserBean login(HttpServletRequest req) {
		UserBean ub=new UserBean();
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from userregister49 where uname=? and pword=?");
			ps.setString(1,req.getParameter("uname"));
			ps.setString(2,req.getParameter("pword"));
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ub.setUname(rs.getString(1));
				ub.setPword(rs.getString(2));
				ub.setFname(rs.getString(3));
				ub.setLname(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setMid(rs.getString(6));
				ub.setPhno(rs.getLong(7));
			}
		}catch(Exception e) {e.printStackTrace();}
		return ub;
	}

}
