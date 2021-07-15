package in.grocery.dao;

import java.sql.SQLException;
import java.util.List;

import in.grocery.dao.CustomerDAO;
import in.grocery.service.IsValiddata;

public class CustomerLoginTest {

	public static void main(String[] args) throws Exception {

		// checkCustomerDetails();
		// addCustomer();
		testShowCustomerDetails();

	}

	public static void addCustomer() throws ClassNotFoundException, SQLException {
		long mobileNo = 6987452310l;
		String password = "Elumalai12.#";
		String name = "elumalai";
		String address = "chennai";
		if (IsValiddata.isValid(mobileNo, password, name)) {
			CustomerDAO.addCustomer(305, name, address, mobileNo, password);
		}
	}

	public static void checkCustomerDetails() throws Exception, SQLException, ClassNotFoundException {
		boolean temp = CustomerDAO.isCustomer(9824356128l, "grocer123");
		System.out.println(temp);

		List<Long> cusMobileNo = CustomerDAO.getCustomerMobileNumber();
		System.out.println(cusMobileNo);
	}

	public static void testShowCustomerDetails() throws ClassNotFoundException, SQLException {

		CustomerDAO.showCustomerDetails();

	}

}
