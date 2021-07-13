package in.rajesh.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.rajesh.util.ConnectionUtil;

public class AdminListDAO {
	
	public static boolean isAdmin(long mobileNo,String password) throws SQLException {
		Connection con = null;
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
		String sql = "SELECT (mobilenumber,password) FROM admin_login WHERE mobilenumber=? AND password=?";
		ps = con.prepareStatement(sql);
		ps.setLong(1, mobileNo);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			flag = true;
		}
		ConnectionUtil.close(con);
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	} finally {
		if (ps != null) {
			ps.close();
		}
		if (con != null) {
			ConnectionUtil.close(con);
		}
	}
	return flag;
	}

}
