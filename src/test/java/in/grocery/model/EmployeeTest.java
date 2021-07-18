package in.grocery.model;

import in.grocery.util.Logger;

public class EmployeeTest {

	public static void main(String[] args) {

		Employee employee = new Employee(234, "rajesh", "chennai", 9876543221l, "Rajesh&4");
		Employee employee1 = new Employee();

		employee1.setEmpAddress("tiruttani");

		Logger.debug(employee1.getEmpAddress());
		Logger.debug(employee);

	}

}
