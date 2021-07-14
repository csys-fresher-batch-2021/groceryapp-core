package in.grocery.model;

import java.sql.SQLException;

import in.grocery.dao.CustomerItemsDAO;

public class CustomerItems {

	public static void main(String[] args) {

		try {
			CustomerItemsDAO.addCustomerItems(302, 204, 110, 3);
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
