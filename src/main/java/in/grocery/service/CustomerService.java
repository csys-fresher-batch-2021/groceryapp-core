package in.grocery.service;

import java.sql.SQLException;
import java.util.List;

import in.grocery.dao.CustomerDAO;
import in.grocery.exception.ValidationException;
import in.grocery.model.Customers;
import in.grocery.util.Logger;
import in.grocery.validator.IdPriceValidation;
import in.grocery.validator.MobileNoValidation;
import in.grocery.validator.NameValidation;
import in.grocery.validator.PasswordValidation;

public class CustomerService {

	private CustomerService() {

	}

	public static boolean checkCustomer(Long cusMobileNo, String cusPassword) throws ValidationException {

		boolean checkMobileNo = MobileNoValidation.checkMobileNo(cusMobileNo);
		boolean checkPassword = PasswordValidation.checkPassword(cusPassword);
		boolean flag = false;

		if (checkMobileNo && checkPassword) {

			try {
				flag = CustomerDAO.isCustomer(cusMobileNo, cusPassword);

			} catch (Exception e) {
				String errorMessage = e.getMessage();
				Logger.debug("Exception : " + errorMessage);
				e.printStackTrace();
			}

		} else {
			Logger.debug("Mobile Number Or Password Incorrect");
		}

		return flag;
	}

	public static List<Customers> getCustomer() {

		List<Customers> showCustomerDetails = null;

		try {
			showCustomerDetails = CustomerDAO.showCustomerDetails();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return showCustomerDetails;
	}

	public static void addCustomer() throws ValidationException {

		Customers customer = new Customers();

		customer.setCusId(304);
		customer.setCusName("Suresh");
		customer.setCusAddress("chennai");
		customer.setCusMobileNo(8987452310l);
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

	public static void updateInActiceCustomer(int cusId) {

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

	public static void changeCustomerPassword(Long cusMobileNo, String cusPassword) throws ValidationException {

		boolean checkMobileNo = MobileNoValidation.checkMobileNo(cusMobileNo);
		boolean checkPassword = PasswordValidation.checkPassword(cusPassword);

		if (!checkPassword) {
			Logger.debug("More Strong your Password");
		}

		if (checkMobileNo && checkPassword) {

			try {
				CustomerDAO.updateCustomerPassword(cusMobileNo, cusPassword);

			} catch (SQLException | ClassNotFoundException e) {
				Logger.debug("Exception:  " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			Logger.debug("Incorrect Mobile Number");
		}
	}

}
