package in.grocery.service;

import in.grocery.validator.MobileNoValidation;
import in.grocery.validator.PasswordValidation;
import in.grocery.validator.NameValidation;

public class IsValiddata {

	public static boolean isValid(long mobileNo, String Password, String name) {
		boolean flag = false;
		boolean result1 = false;

		try {
			result1 = MobileNoValidation.checkMobileNo(mobileNo);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Exception : " + errorMessage);
			e.printStackTrace();
		}
		boolean result2 = PasswordValidation.checkPassword(Password);
		boolean result3 = NameValidation.checkName(name);
		// System.out.println(result1+" "+result2+" "+result3);
		if (result1 && result2 && result3) {
			flag = true;
		}

		return flag;
	}

}
