package in.grocery.model;

import in.grocery.util.Logger;

public class GroceryTest {

	public static void main(String[] args) {
		
		Grocery grocery = new Grocery(121, "tomoto", "fruits", 20, 50);
		String data = grocery.toString();
		Logger.debug(data);
		
	}

}
