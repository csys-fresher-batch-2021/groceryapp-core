package in.grocery.dao;

import java.sql.SQLException;

import in.grocery.model.Employee;
import in.grocery.util.Logger;

public class EmployeeDAOTest {
	
	public static void main(String[] args) {

		changeEmployeePassword();
		// isValidEmployee();
		// isInValidEmployee();

	}

	public static void changeEmployeePassword() {
		try {
			EmployeeDAO.updateEmployeePassword(9274563210l, "Lavanya@.");
		} catch (SQLException | ClassNotFoundException e) {
			Logger.debug("Exception:  " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void isValidEmployee() {
		try {
			Employee.checkMobileNoPassword(9874563210l, "rajesh1234");
			Logger.debug("Valid Employee Details");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			Logger.debug("Exception : " + errorMessage);
			e.printStackTrace();
		}
	}

	public static void isInValidEmployee() {
		try {
			Employee.checkMobileNoPassword(98745630l, "rajesh1234");
			Logger.debug("Valid Employee Details");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			Logger.debug("Exception : " + errorMessage);
			e.printStackTrace();
		}
	}

}
