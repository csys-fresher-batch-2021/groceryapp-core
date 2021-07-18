package in.grocery.dao;

import java.sql.SQLException;
import java.util.List;

import in.grocery.model.Employee;
import in.grocery.util.Logger;

public class EmployeeDAOTest {

	public static void main(String[] args) {

		deleteEmployee();
		// addEmployee();
		// getEmployeeList();
		// changeEmployeePassword();
		// isValidEmployee();
		// isInValidEmployee();

	}

	public static void isValidEmployee() {

		try {
			EmployeeDAO.isEmployee(9874563054l, "Hello123#8");

		} catch (Exception e) {
			String errorMessage = e.getMessage();
			Logger.debug("Exception : " + errorMessage);
			e.printStackTrace();
		}
	}

	public static void isInValidEmployee() {

		try {
			EmployeeDAO.isEmployee(987456354l, "Hello1238");

		} catch (Exception e) {
			String errorMessage = e.getMessage();
			Logger.debug("Exception : " + errorMessage);
			e.printStackTrace();
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

	public static void addEmployee() {

		Employee insertEmp = new Employee();

		insertEmp.setEmpId(100);
		insertEmp.setEmpName("Rajesh");
		insertEmp.setEmpAddress("Tiruttani");
		insertEmp.setEmpMobileNo(7548851413l);
		insertEmp.setEmpPassword("Hello123*");

		try {
			EmployeeDAO.addEmployee(insertEmp);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void changeEmployeePassword() {

		try {
			EmployeeDAO.updateEmployeePassword(9274563210l, "Lavanya@.");

		} catch (SQLException | ClassNotFoundException e) {
			Logger.debug("Exception:  " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void deleteEmployee() {

		try {
			EmployeeDAO.removeEmployee(100);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
