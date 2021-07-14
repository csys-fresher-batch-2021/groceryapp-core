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
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String address=rs.getString(3);
				Long mobileNo=rs.getLong(4);
				String password=rs.getString(5);
				
				Employee employee = new Employee(id,name,address,mobileNo,password);
				//System.out.println(customer);
				employeeList.add(employee);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, ps, con);
		}
		return employeeList;
	}

}
