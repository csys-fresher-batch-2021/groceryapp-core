package in.grocery.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import in.grocery.model.Grocery;
import in.grocery.util.Logger;

public class GroceryDAOTest {

	public static void main(String[] args) {

		// insertGrocery();
		showGrocery();
		// upodatePrice();
		// updateQuantity();

	}

	public static void showGrocery() {
		try {
			ArrayList<Grocery> showGroceryDetails = GroceryDAO.showGroceryDetails();

			for (Grocery grocery : showGroceryDetails) {
				Logger.debug(grocery);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void insertGrocery() {
		try {
			GroceryDAO.addGrocery(210, "tomoto", "fruit", 20, 60);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void upodatePrice() {
		try {
			GroceryDAO.updateGroceryPrice(210, 30);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void updateQuantity() {
		try {
			GroceryDAO.updateGroceryQuantity(210, 50);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
