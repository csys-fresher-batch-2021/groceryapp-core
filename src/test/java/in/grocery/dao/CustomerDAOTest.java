package in.grocery.dao;

import java.sql.SQLException;
import java.util.List;

import in.grocery.model.Customers;
import in.grocery.util.Logger;

public class CustomerDAOTest {

	public static void main(String[] args) throws Exception {

		// checkCustomerDetails();
		// addCustomer();
		testShowCustomerDetails();
		// testUpdateInactiveCustomer();

	}

	public static void addCustomer() throws ClassNotFoundException, SQLException {

		Customers customer = new Customers();

		customer.setCusId(305);
		customer.setCusName("Suresh");
		customer.setCusMobileNo(8987452310l);
		customer.setCusAddress("chennai");
		customer.setCusPassword("Suresh@87");

		CustomerDAO.addCustomer(customer);

	}

	public static void checkCustomerDetails() throws Exception, SQLException, ClassNotFoundException {
		boolean temp = CustomerDAO.isCustomer(9824356128l, "grocer123");
		Logger.debug(temp);

		List<Long> cusMobileNo = CustomerDAO.getCustomerMobileNumber();
		Logger.debug(cusMobileNo);
	}

	public static void testShowCustomerDetails() {

		List<Customers> showCustomerDetails = null;
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
