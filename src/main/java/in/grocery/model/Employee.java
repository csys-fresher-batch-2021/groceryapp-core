package in.grocery.model;

import in.grocery.validator.*;
import in.grocery.dao.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Employee {

	int empId;
	String empName;
	String empAddress;
	Long empMobileNo;
	String empPassword;

	public Employee(int empId, String empName, String empAddress, Long empMobileNo, String empPassword) {

		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empMobileNo = empMobileNo;
		this.empPassword = empPassword;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empMobileNo="
				+ empMobileNo + ", empPassword=" + empPassword + "]";
	}

	public static boolean checkMobileNoPassword(long mobileNumber, String password) throws Exception {

		boolean isValidMobileNumber = MobileNoValidation.checkMobileNo(mobileNumber);
		boolean isValidPassword = PasswordValidation.checkPassword(password);
		boolean flag = false;

		if (isValidMobileNumber && isValidPassword) {
			try {
				flag = EmployeeDAO.isEmployee(mobileNumber, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public static void main(String[] args) {

		try {
			EmployeeDAO.updateEmployeePassword(9274563210l, "Lavanya@.");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception:  " + e.getMessage());
			e.printStackTrace();
		}

	}

}
