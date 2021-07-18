package in.grocery.dao;

import java.sql.SQLException;
import java.util.List;

import in.grocery.model.CustomerItems;
import in.grocery.model.GroupCustomerItems;
import in.grocery.util.Logger;

public class CustomerItemsDAOTest {
	
	public static void main(String[] args) {
		
		//showAllCustomers();
		//showGroupCustomer();
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

}
