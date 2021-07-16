package in.grocery.validator;

import in.grocery.util.Logger;

public class MobileNoValidationTest {

	public static void main(String[] args) {

		// isValidMobileNo(9876543251L);
		// isInValidMobileNo(98765451L);
	}

	public static void isValidMobileNo(long mn) {
		try {
			MobileNoValidation.checkMobileNo(mn);
			Logger.debug("Valid Mobile Number ");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			Logger.debug("Exception :  " + errorMessage);
			e.printStackTrace();
		}
	}

	public static void isInValidMobileNo(long mn) {
		try {
			MobileNoValidation.checkMobileNo(mn);
			Logger.debug("Valid Mobile Number ");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			Logger.debug("Exception :  " + errorMessage);
			e.printStackTrace();
		}
	}

}
