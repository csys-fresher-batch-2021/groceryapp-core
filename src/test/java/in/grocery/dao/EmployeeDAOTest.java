package in.grocery.dao;

import java.sql.SQLException;
import java.util.List;

import in.grocery.exception.ValidationException;
import in.grocery.model.Employee;
import in.grocery.util.Logger;
import in.grocery.validator.IdPriceValidation;
import in.grocery.validator.MobileNoValidation;
import in.grocery.validator.NameValidation;
import in.grocery.validator.PasswordValidation;

public class EmployeeDAOTest {

	public static void main(String[] args) {

		// deleteEmployee();
		// addEmployee();
		getEmployeeList();
		// changeEmployeePassword();
		// isValidEmployee();
		// isInValidEmployee();

	}

	public static void isValidEmployee() throws ValidationException {

		Long empMobileNo = 9874563054l;
		String empPassword = "Hello123#8";

		boolean checkMobileNo = MobileNoValidation.checkMobileNo(empMobileNo);
		boolean checkPassword = PasswordValidation.checkPassword(empPassword);

		if (checkMobileNo && checkPassword) {

			try {
				EmployeeDAO.isEmployee(empMobileNo, empPassword);

			} catch (Exception e) {
				String errorMessage = e.getMessage();
				Logger.debug("Exception : " + errorMessage);
				e.printStackTrace();
			}

		} else {
			Logger.debug("Mobile Number Or Password Incorrect");
		}

	}

	public static void isInValidEmployee() throws ValidationException {

		Long empMobileNo = 9874563054l;
		String empPassword = "Hello123#8";

		boolean checkMobileNo = MobileNoValidation.checkMobileNo(empMobileNo);
		boolean checkPassword = PasswordValidation.checkPassword(empPassword);

		if (checkMobileNo && checkPassword) {

			try {
				EmployeeDAO.isEmployee(empMobileNo, empPassword);

			} catch (Exception e) {
				String errorMessage = e.getMessage();
				Logger.debug("Exception : " + errorMessage);
				e.printStackTrace();
			}

		} else {
			Logger.debug("Mobile Number Or Password Incorrect");
		}

	}

	public static void getEmployeeList() {

		try {
			List<Employee> showEmployeeDetails = EmployeeDAO.showEmployeeDetails();

			for (Employee employee : showEmployeeDetails) {
				Logger.debug(employee);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void addEmployee() throws ValidationException {

		Employee insertEmp = new Employee();

		insertEmp.setEmpId(100);
		insertEmp.setEmpName("Rajesh");
		insertEmp.setEmpAddress("Tiruttani");
		insertEmp.setEmpMobileNo(7548851413l);
		insertEmp.setEmpPassword("Hello123#");

		boolean checkId = IdPriceValidation.checkId(insertEmp.getEmpId());
		boolean checkName = NameValidation.checkName(insertEmp.getEmpName());
		boolean checkAddress = NameValidation.checkName(insertEmp.getEmpAddress());
		boolean checkMobileNo = MobileNoValidation.checkMobileNo(insertEmp.getEmpMobileNo());
		boolean checkPassword = PasswordValidation.checkPassword(insertEmp.getEmpPassword());

		if (checkId && checkName && checkAddress && checkMobileNo && checkPassword) {

			try {
				EmployeeDAO.addEmployee(insertEmp);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			Logger.debug("Invalid Data");
		}
	}

	public static void changeEmployeePassword() throws ValidationException {

		Long empMobileNo = 9874563054l;
		String empPassword = "Hellohi123#8";

		boolean checkMobileNo = MobileNoValidation.checkMobileNo(empMobileNo);
		boolean checkPassword = PasswordValidation.checkPassword(empPassword);

		if (!checkPassword) {
			Logger.debug("More Strong your Password");
		}

		if (checkMobileNo && checkPassword) {

			try {
				EmployeeDAO.updateEmployeePassword(empMobileNo, empPassword);

			} catch (SQLException | ClassNotFoundException e) {
				Logger.debug("Exception:  " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			Logger.debug("Incorrect Mobile Number");
		}
	}

	public static void deleteEmployee() {

		int empId = 301;

		boolean checkId = IdPriceValidation.checkId(empId);

		if (checkId) {

			try {
				EmployeeDAO.removeEmployee(empId);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			Logger.debug("In Valid Employee ID");
		}
	}

}
