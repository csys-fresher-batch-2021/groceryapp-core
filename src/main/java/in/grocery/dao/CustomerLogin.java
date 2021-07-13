package in.grocery.dao;

import java.sql.*;
import java.util.*;

import in.grocery.util.*;

public class CustomerLogin {

	public static boolean isCustomer(long mobileNo, String password) throws Exception {
		Connection con = null;
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT customer_id,customer_name,password,mobile_no FROM cus_login WHERE mobile_no=? AND password=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, mobileNo);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			}
			else if(! rs.next()){
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

	public static List<Long> getMobileNumber() throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pst = null;
		List<Long> userMobileNo = new ArrayList<>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM cus_login";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				userMobileNo.add((rs.getLong("mobile_no")));
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

	public static void addCustomer(int customerId, String customerName, Long mobileNo, String password)
			throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO cus_login(customer_id,customer_name,mobile_no,password) VALUES(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, customerId);
			ps.setString(2, customerName);
			ps.setLong(3, mobileNo);
			ps.setString(4, password);
			int count = ps.executeUpdate();
			if(count > 0) {
				System.out.println(count+" row inserted");
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
	}
}
