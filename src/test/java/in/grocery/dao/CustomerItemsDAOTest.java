package in.grocery.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import in.grocery.model.CustomerItems;
import in.grocery.util.Logger;

public class CustomerItemsDAOTest {
	
	public static void main(String[] args) {
		
		try {
			ArrayList<CustomerItems> showCustomerItemsDetails = CustomerItemsDAO.showCustomerItemsDetails();
			for (CustomerItems customerItems : showCustomerItemsDetails) {
				Logger.debug(customerItems);
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		
	}

}
