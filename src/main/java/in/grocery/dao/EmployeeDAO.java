package in.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.grocery.model.Customers;
import in.grocery.model.Employee;
import in.grocery.util.ConnectionUtil;

public class EmployeeDAO {

	public static boolean isEmployee(long mobileNo, String password) throws Exception {
		Connection con = null;
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT emp_mobile_no,emp_password FROM stock_employee WHERE emp_mobile_no = ? AND emp_password = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, mobileNo);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			} else {
				throw new Exception("Invalid Mobile number or Password Try Again");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
		return flag;
	}

	public static ArrayList<Employee> showEmployeeDetails() throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<Employee> employeeList = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "select emp_id,emp_name,emp_address,emp_mobile_no,emp_password from stock_employee";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			employeeList = new ArrayList<Employee>();
			while (rs.next()) {
				int id = rs.getInt("emp_id");
				String name = rs.getString("emp_name");
				String address = rs.getString("emp_address");
				Long mobileNo = rs.getLong("emp_mobile_no");
				String password = rs.getString("emp_password");

				Employee employee = new Employee(id, name, address, mobileNo, password);
				// System.out.println(customer);
				employeeList.add(employee);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, ps, con);
		}
		return employeeList;
	}

	public static void addEmployee(int empId, String empName, String empAddress, Long empMobileNO, String empPassword)
			throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into stock_employee(emp_id,emp_name,emp_address,emp_mobile_no,emp_password) values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, empId);
			ps.setString(2, empName);
			ps.setString(3, empAddress);
			ps.setLong(4, empMobileNO);
			ps.setString(5, empPassword);

			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println(count + " row inserted");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
	}

	public static void updateEmployeePassword(Long mobileNo, String empPassword)
			throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update stock_employee set emp_password=? where emp_mobile_no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, empPassword);
			ps.setLong(2, mobileNo);

			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println(count + " row updated");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
	}

	public static void removeEmployee(int empId) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "delete stock_employee where emp_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, empId);

			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println(count + " row deleted");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
	}

}
