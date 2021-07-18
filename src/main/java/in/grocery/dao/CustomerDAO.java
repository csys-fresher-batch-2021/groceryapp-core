package in.grocery.dao;

import java.sql.*;
import java.util.*;

import in.grocery.exception.DBException;
import in.grocery.model.Customers;
import in.grocery.util.*;

public class CustomerDAO {

	private CustomerDAO() {

	}

	public static boolean isCustomer(long mobileNo, String password) throws DBException {
		Connection con = null;
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select cus_password,cus_mobile_no from grocery_customers where cus_mobile_no=? and cus_password=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, mobileNo);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			} else {
				throw new DBException("Invalid Mobile number or Password Try Again");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
		return flag;
	}

	public static List<Long> getCustomerMobileNumber() throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pst = null;
		List<Long> userMobileNo = new ArrayList<>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT cus_mobile_no FROM grocery_customers";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				userMobileNo.add((rs.getLong("cus_mobile_no")));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, con);
		}
		return userMobileNo;
	}

	public static void addCustomer(Customers customer) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into grocery_customers(cus_id,cus_name,cus_address,cus_mobile_no,cus_password) VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, customer.getCusId());
			ps.setString(2, customer.getCusName());
			ps.setString(3, customer.getCusAddress());
			ps.setLong(4, customer.getCusMobileNo());
			ps.setString(5, customer.getCusPassword());

			int count = ps.executeUpdate();
			if (count > 0) {
				Logger.debug(count + " row inserted");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
	}

	public static List<Customers> showCustomerDetails() throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<Customers> customersList = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "select cus_id,cus_name,cus_address,cus_mobile_no,cus_password,cus_status from grocery_customers";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			customersList = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				Long mobileNo = rs.getLong(4);
				String password = rs.getString(5);
				String status = rs.getString(6);

				Customers customer = new Customers(id, name, address, mobileNo, password, status);
				customersList.add(customer);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, ps, con);
		}
		return customersList;
	}

	public static void updateInactiveCustomer(int customerId) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update grocery_customers set cus_status='INACTIVE' where cus_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, customerId);

			int count = ps.executeUpdate();

			if (count > 0) {
				Logger.debug(count + " row updated");
			} else {
				Logger.debug("Invalid Customer ID");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
	}

	public static void updateCustomerPassword(Long mobileNo, String cusPassword)
			throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update grocery_customers set cus_password=? where cus_mobile_no=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, cusPassword);
			ps.setLong(2, mobileNo);

			int count = ps.executeUpdate();

			if (count > 0) {
				Logger.debug(count + " row updated");
			} else {
				Logger.debug("Invalid Customer ID");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
	}
}
