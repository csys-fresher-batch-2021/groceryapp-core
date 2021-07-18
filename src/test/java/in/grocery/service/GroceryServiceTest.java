package in.grocery.service;

import java.util.List;

import in.grocery.model.Grocery;
import in.grocery.util.Logger;

public class GroceryServiceTest {

	public static void main(String[] args) {

		getGroceryList();
		// insertGrocery();
		// removeGrocery();
		// updatePrice();
		// updateQuantity();

	}

	public static void getGroceryList() {

		List<Grocery> showGroceryDetails = GroceryService.getGroceryList();

		for (Grocery grocery : showGroceryDetails) {
			Logger.debug(grocery);
		}
	}

	public static void insertGrocery() {

		GroceryService.addGrocery();
	}

	public static void updatePrice() {

		GroceryService.updateGroceryPrice(201, 90);
	}

	public static void updateQuantity() {

		GroceryService.updateGroceryQuantity(201, 40);
	}

	public static void removeGrocery() {

		GroceryService.removeGrocery(120);

	}

}
