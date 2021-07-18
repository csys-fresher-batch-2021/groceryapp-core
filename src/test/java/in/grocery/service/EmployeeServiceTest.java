package in.grocery.service;

import java.util.List;

import in.grocery.exception.ValidationException;
import in.grocery.model.Employee;
import in.grocery.util.Logger;

public class EmployeeServiceTest {

	public static void main(String[] args) {

		// insertEmployee();
		// isEmployee();
		// getEmployeeList();
		// changeEmployeePassword();
		removeEmployee();

	}

	public static void isEmployee() {
		try {
			EmployeeService.checkEmployee(9874563054l, "Hello123#8");

		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}

	public static void getEmployeeList() {

		List<Employee> showEmployeeDetails = EmployeeService.getEmployee();

		for (Employee employee : showEmployeeDetails) {
			Logger.debug(employee);
		}
	}

	public static void insertEmployee() {

		try {
			EmployeeService.addEmployee();

		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}

	public static void changeEmployeePassword() {

		try {
			EmployeeService.changeEmployeePassword(9274563210l, "Lavanya@.12");
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}

	public static void removeEmployee() {

		EmployeeService.removeEmployee(120);

	}
}
