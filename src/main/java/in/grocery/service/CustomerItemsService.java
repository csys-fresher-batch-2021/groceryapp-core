package in.grocery.service;

import java.sql.SQLException;
import java.util.List;

import in.grocery.dao.CustomerItemsDAO;
import in.grocery.model.CustomerItems;
import in.grocery.model.GroupCustomerItems;
import in.grocery.util.Logger;
import in.grocery.validator.IdPriceValidation;

public class CustomerItemsService {

	private CustomerItemsService() {

	}

	public static void addCustomerItems(int cusId, int proId, double price, double quantity) {

		/**
		 * Insert a data to customer_items Without inserting a gst_price and net_price
		 * Because it's a calculation of price and quantity
		 */

		boolean checkCusId = IdPriceValidation.checkId(cusId);
		boolean checkProId = IdPriceValidation.checkId(proId);
		boolean checkPrice = IdPriceValidation.checkPrice((int) price);

		if (checkCusId && checkProId && checkPrice) {
			try {
				CustomerItemsDAO.addCustomerItems(cusId, proId, price, quantity);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			Logger.debug("Invalid Data");
		}
	}

	public static List<CustomerItems> getCustomerItems() {

		/**
		 * This function returns a customer's ordered item list
		 */

		List<CustomerItems> showCustomerItems = null;

		try {
			showCustomerItems = CustomerItemsDAO.showCustomerItemsDetails();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return showCustomerItems;
	}

	public static List<GroupCustomerItems> getGroupCustomer() {

		/**
		 * This function returns a purchase history for every individual customer
		 */

		List<GroupCustomerItems> showCustomerItems = null;

		try {
			showCustomerItems = CustomerItemsDAO.showCustomerPurchase();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return showCustomerItems;
	}

	public static void removeProducts(int cusId, int proId) {

		boolean checkCusId = IdPriceValidation.checkId(cusId);
		boolean checkProId = IdPriceValidation.checkId(proId);

		if (checkCusId && checkProId) {
			CustomerItemsDAO.removeProductInCustomerCart(cusId, proId);
		} else {
			Logger.debug("Customer ID OR Product ID Invalid");
		}

	}

}
