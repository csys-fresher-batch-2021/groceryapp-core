package in.grocery.model;

import java.sql.SQLException;
import java.util.List;

import in.grocery.dao.CustomerItemsDAO;
import in.grocery.util.Logger;

public class GroupCustomerItemsTest {

	public static void main(String[] args) {

		try {
			List<GroupCustomerItems> showCustomerPurchase = CustomerItemsDAO.showCustomerPurchase();
			for (GroupCustomerItems groupCustomerItems : showCustomerPurchase) {
				Logger.debug(groupCustomerItems);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
