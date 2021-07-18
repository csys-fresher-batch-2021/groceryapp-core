package in.grocery.model;

import in.grocery.util.Logger;

public class GroceryTest {

	public static void main(String[] args) {

		Grocery grocery = new Grocery(121, "tomoto", "fruits", 20, 50);
		Grocery grocery1 = new Grocery();

		grocery1.setCategory("vegitables");

		Logger.debug(grocery1.getCategory());
		Logger.debug(grocery);

	}

}
