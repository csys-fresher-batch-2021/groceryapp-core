package in.grocery.dao;

import java.sql.SQLException;
import java.util.List;

import in.grocery.model.CustomerItems;
import in.grocery.model.GroupCustomerItems;
import in.grocery.util.Logger;
import in.grocery.validator.IdPriceValidation;
import in.grocery.validator.QuantityValidation;

public class CustomerItemsDAOTest {

	public static void main(String[] args) {

		// insertCustomerItems();
		showAllCustomers();
		// showGroupCustomer();
		// removeProducts();
	}

	public static void insertCustomerItems() {

		int cusId = 305;
		int proId = 103;
		double price = 40;
		double quantity = 3;

		boolean checkCusId = IdPriceValidation.checkId(cusId);
		boolean checkProId = IdPriceValidation.checkId(proId);
		boolean checkPrice = IdPriceValidation.checkPrice((int) price);
		boolean checkQuantity = QuantityValidation.checkQuantity((int) quantity);

		if (checkCusId && checkProId && checkPrice && checkQuantity) {

			try {
				CustomerItemsDAO.addCustomerItems(cusId, proId, price, quantity);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			Logger.debug("Invalid Data");
		}

	}

	public static void showAllCustomers() {

		try {
			List<CustomerItems> showCustomerItemsDetails = CustomerItemsDAO.showCustomerItemsDetails();
			for (CustomerItems customerItems : showCustomerItemsDetails) {
				Logger.debug(customerItems);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void showGroupCustomer() {

		try {
			List<GroupCustomerItems> showCustomerPurchase = CustomerItemsDAO.showCustomerPurchase();

			for (GroupCustomerItems groupCustomerItems : showCustomerPurchase) {
				Logger.debug(groupCustomerItems);

			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void removeProducts() {

		int cusId = 305;
		int proId = 103;

		boolean checkCusId = IdPriceValidation.checkId(cusId);
		boolean checkProId = IdPriceValidation.checkId(proId);

		if (checkCusId && checkProId) {
			CustomerItemsDAO.removeProductInCustomerCart(cusId, proId);
		} else {
			Logger.debug("Customer ID OR Product ID Invalid");
		}

	}

}
