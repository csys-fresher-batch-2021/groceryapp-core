package in.grocery.validator;

import in.grocery.util.Logger;

public class NameValidationTest {

	static void isValidString() {

		String name = "rajesh";

		if (NameValidation.checkName(name)) {
			Logger.debug("Valid String Data");
		} else {
			Logger.debug("Invalid String Data");
		}
	}

	static void isInValidString() {

		String name = "";

		if (NameValidation.checkName(name)) {
			Logger.debug("Valid String Data");
		} else {
			Logger.debug("Invalid String Data");
		}
	}

	public static void main(String[] args) {
		// isValidString();
		isInValidString();
	}

}
