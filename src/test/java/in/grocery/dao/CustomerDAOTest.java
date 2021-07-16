package in.grocery.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.grocery.model.Customers;
import in.grocery.service.IsValiddata;
import in.grocery.util.Logger;

public class CustomerDAOTest {

	public static void main(String[] args) throws Exception {

		// checkCustomerDetails();
		// addCustomer();
		testShowCustomerDetails();
		// testUpdateInactiveCustomer();

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
		Logger.debug(temp);

		List<Long> cusMobileNo = CustomerDAO.getCustomerMobileNumber();
		Logger.debug(cusMobileNo);
	}

	public static void testShowCustomerDetails() {

		ArrayList<Customers> showCustomerDetails;
		try {
			showCustomerDetails = CustomerDAO.showCustomerDetails();
			for (Customers customers : showCustomerDetails) {
				Logger.debug(customers);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void testUpdateInactiveCustomer() {
		try {
			CustomerDAO.updateInactiveCustomer(303);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
