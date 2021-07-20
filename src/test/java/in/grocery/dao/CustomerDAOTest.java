package in.grocery.dao;

import java.sql.SQLException;
import java.util.List;

import in.grocery.exception.ValidationException;
import in.grocery.model.Customers;
import in.grocery.util.Logger;
import in.grocery.validator.IdPriceValidation;
import in.grocery.validator.MobileNoValidation;
import in.grocery.validator.NameValidation;
import in.grocery.validator.PasswordValidation;

public class CustomerDAOTest {

	public static void main(String[] args) throws Exception {

		// checkCustomerDetails();
		// addCustomer();
		testShowCustomerDetails();
		// testUpdateInactiveCustomer();

	}

	public static void addCustomer() throws ClassNotFoundException, SQLException, ValidationException {

		Customers customer = new Customers();

		customer.setCusId(305);
		customer.setCusName("Suresh");
		customer.setCusMobileNo(8987452310l);
		customer.setCusAddress("chennai");
		customer.setCusPassword("Suresh@87");

		boolean checkId = IdPriceValidation.checkId(customer.getCusId());
		boolean checkName = NameValidation.checkName(customer.getCusName());
		boolean checkAddress = NameValidation.checkName(customer.getCusAddress());
		boolean checkMobileNo = MobileNoValidation.checkMobileNo(customer.getCusMobileNo());
		boolean checkPassword = PasswordValidation.checkPassword(customer.getCusPassword());

		if (checkId && checkName && checkAddress && checkMobileNo && checkPassword) {

			try {
				CustomerDAO.addCustomer(customer);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	public static void checkCustomerDetails() throws Exception, SQLException, ClassNotFoundException {

		Long MobileNo = 9824356128l;
		String Password = "grocer123";

		boolean checkMobileNo = MobileNoValidation.checkMobileNo(MobileNo);
		boolean checkPassword = PasswordValidation.checkPassword(Password);

		if (checkMobileNo && checkPassword) {

			boolean temp = CustomerDAO.isCustomer(MobileNo, Password);
			Logger.debug(temp);
		} else {
			Logger.debug("Invalid Mobile Number Or Password");
		}

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

		int cusId = 303;
		boolean checkId = IdPriceValidation.checkId(cusId);

		if (checkId) {

			try {
				CustomerDAO.updateInactiveCustomer(cusId);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} else {
			Logger.debug("Invalid Customer ID");
		}
	}
}
