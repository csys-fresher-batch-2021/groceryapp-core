package in.grocery.validator;

import in.grocery.util.Logger;

public class IdPriceValidationTest {
	
	public static void main(String[] args) {
		
		isInValidId();
		isValidId();
		isValidPrice();
		isInValidPrice();
		
	}

	public static void isValidId() {
		boolean checkId = IdPriceValidation.checkId(134);
		Logger.debug(checkId);
	}
	
	public static void isInValidId() {
		boolean checkId = IdPriceValidation.checkId(34);
		Logger.debug(checkId);
	}
	
	public static void isValidPrice() {
		boolean checkId = IdPriceValidation.checkId(134);
		Logger.debug(checkId);
	}
	
	public static void isInValidPrice() {
		boolean checkId = IdPriceValidation.checkId(-34);
		Logger.debug(checkId);
	}

}
