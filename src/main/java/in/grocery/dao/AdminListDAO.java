package in.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.grocery.util.ConnectionUtil;

public class AdminListDAO {

	public static boolean isAdmin(long mobileNo, String password) throws Exception {
		Connection con = null;
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT admin_mobile_no,admin_password FROM admin_login WHERE admin_mobile_no = ? AND admin_password = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, mobileNo);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			} else if (!rs.next()) {
				throw new Exception("Invalid Mobile number or Password Try Again");
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
