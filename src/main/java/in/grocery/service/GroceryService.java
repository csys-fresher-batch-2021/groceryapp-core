package in.grocery.service;

import java.sql.SQLException;
import java.util.List;

import in.grocery.dao.GroceryDAO;
import in.grocery.model.Grocery;
import in.grocery.util.Logger;
import in.grocery.validator.IdPriceValidation;
import in.grocery.validator.NameValidation;

public class GroceryService {

	private GroceryService() {

	}

	public static List<Grocery> getGroceryList() {

		List<Grocery> showGroceryDetails = null;

		try {
			showGroceryDetails = GroceryDAO.showGroceryDetails();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return showGroceryDetails;
	}

	public static void addGrocery() {

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

		if (checkId && checkName && checkCategory && checkPrice) {

			try {
				GroceryDAO.addGrocery(insertGrocery);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			Logger.debug("Invalid Data");
		}
	}

	public static void updateGroceryPrice(int proId, double proPrice) {

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

	public static void updateGroceryQuantity(int proId, double quantity) {

		boolean checkId = IdPriceValidation.checkId(proId);

		if (checkId) {

			try {
				GroceryDAO.updateGroceryQuantity(proId, quantity);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			Logger.debug("Invalid Product ID");
		}

	}

	public static void removeGrocery(int proId) {

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
