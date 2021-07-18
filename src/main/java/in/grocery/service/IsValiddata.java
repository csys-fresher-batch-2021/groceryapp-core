package in.grocery.service;

import in.grocery.util.Logger;
import in.grocery.validator.MobileNoValidation;
import in.grocery.validator.PasswordValidation;
import in.grocery.validator.NameValidation;

public class IsValiddata {

	private IsValiddata() {

	}

	public static boolean isValid(long mobileNo, String password, String name) {
		boolean flag = false;
		boolean result1 = false;

		try {
			result1 = MobileNoValidation.checkMobileNo(mobileNo);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			Logger.debug("Exception : " + errorMessage);
			e.printStackTrace();
		}
		boolean result2 = PasswordValidation.checkPassword(password);
		boolean result3 = NameValidation.checkName(name);
		if (result1 && result2 && result3) {
			flag = true;
		}

		return flag;
	}

}
