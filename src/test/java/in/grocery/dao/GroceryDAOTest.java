package in.grocery.dao;

import java.sql.SQLException;
import java.util.List;

import in.grocery.model.Grocery;
import in.grocery.util.Logger;
import in.grocery.validator.IdPriceValidation;
import in.grocery.validator.NameValidation;
import in.grocery.validator.QuantityValidation;

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

		boolean checkId = IdPriceValidation.checkId(insertGrocery.getProId());
		boolean checkName = NameValidation.checkName(insertGrocery.getProName());
		boolean checkCategory = NameValidation.checkName(insertGrocery.getCategory());
		boolean checkPrice = IdPriceValidation.checkPrice((int) insertGrocery.getPrice());
		boolean checkQuantity = QuantityValidation.checkQuantity((int) insertGrocery.getQuantity());

		if (checkId && checkName && checkCategory && checkPrice && checkQuantity) {

			try {
				GroceryDAO.addGrocery(insertGrocery);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			Logger.debug("Invalid Data");
		}
	}

	public static void upodatePrice() {

		int proId = 216;
		double proPrice = 50;

		boolean checkId = IdPriceValidation.checkId(proId);
		boolean checkPrice = IdPriceValidation.checkPrice((int) proPrice);

		if (checkId && checkPrice) {

			try {
				GroceryDAO.updateGroceryPrice(proId, proPrice);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			Logger.debug("Invalid Product ID Or Price");
		}

	}

	public static void updateQuantity() {

		int proId = 215;
		double quantity = 70;

		boolean checkId = IdPriceValidation.checkId(proId);
		boolean checkQuantity = QuantityValidation.checkQuantity((int) quantity);

		if (checkId && checkQuantity) {

			try {
				GroceryDAO.updateGroceryQuantity(proId, quantity);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			Logger.debug("Invalid Product ID");
		}
	}

	public static void removeGrocery() {

		int proId = 201;

		boolean checkId = IdPriceValidation.checkId(proId);

		if (checkId) {

			try {
				GroceryDAO.removeGrocery(proId);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			Logger.debug("In Valid Product ID");
		}
	}

}
