package in.grocery.dao;

import java.sql.SQLException;
import java.util.List;

import in.grocery.model.Grocery;
import in.grocery.util.Logger;

public class GroceryDAOTest {

	public static void main(String[] args) {

		// insertGrocery();
		showGrocery();
		// upodatePrice();
		// updateQuantity();
		// removeGrocery();

	}

	public static void showGrocery() {
		try {
			List<Grocery> showGroceryDetails = GroceryDAO.showGroceryDetails();

			for (Grocery grocery : showGroceryDetails) {
				Logger.debug(grocery);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void insertGrocery() {

		Grocery insertGrocery = new Grocery();

		insertGrocery.setProId(214);
		insertGrocery.setProName("Potato");
		insertGrocery.setCategory("Vegetables");
		insertGrocery.setPrice(40);
		insertGrocery.setQuantity(3);

		try {
			GroceryDAO.addGrocery(insertGrocery);

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

	public static void removeGrocery() {

		try {
			GroceryDAO.removeGrocery(210);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
