package in.grocery.validator;

import in.grocery.util.Logger;

public class PasswordValidationTest {

	public static void main(String[] args) {

		// isPassword();
		isNotPassword();

	}

	static void isPassword() {
		if (PasswordValidation.checkPassword("HelloWorld#8")) {
			Logger.debug("Valid Password");
		} else {
			Logger.debug("Make More Strong Your Password");
		}
	}

	static void isNotPassword() {
		if (PasswordValidation.checkPassword("Welcome987")) {
			Logger.debug("Valid Password");
		} else {
			Logger.debug("Make More Strong Your Password (Invalid)");
		}
	}
}
