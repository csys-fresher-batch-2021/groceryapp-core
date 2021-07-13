package in.rajesh.model;

import in.rajesh.util.*;
import java.sql.*;
import java.util.*;

public class Login {
	
	public boolean isCustomer(long mobileNo,String password) throws SQLException {
		Connection con = null;
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
		String sql = "SELECT (customer_id,customer_name,mobilenumber,password) FROM cus_login WHERE mobilenumber=? AND password=?";
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
	
	public static List<Long> getMobileNumber() throws SQLException,ClassNotFoundException{
		Connection con = null;
		PreparedStatement pst = null;
		List<Long> userMobileNo = new ArrayList<>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM cus_login";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				userMobileNo.add((rs.getLong("contact_num")));
			}
			ConnectionUtil.close(con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				ConnectionUtil.close(con);
			}
		}
		return userMobileNo;
	}
	public static void addCustomer (int customerId,String customerName,Long mobileNo,String password) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO user_details(customer_id,customer_name,mobilenumber,password) VALUES(?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, customerId);
			ps.setString(2, customerName);
			ps.setLong(3, mobileNo);
			ps.setString(4, password);
			ps.executeUpdate();
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
	}
}
