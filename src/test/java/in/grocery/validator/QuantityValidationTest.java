package in.grocery.validator;

import in.grocery.util.Logger;

public class QuantityValidationTest {

	public static void main(String[] args) {

		// isValidQuantity();
		isInValidQuantity();

	}

	public static void isValidQuantity() {

		boolean checkQuantity = QuantityValidation.checkQuantity(3);
		Logger.debug(checkQuantity);

	}

	public static void isInValidQuantity() {

		boolean checkQuantity = QuantityValidation.checkQuantity(-5);
		Logger.debug(checkQuantity);

	}

}
