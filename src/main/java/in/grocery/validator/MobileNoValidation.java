package in.grocery.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.grocery.exception.ValidationException;

public class MobileNoValidation {

	private MobileNoValidation() {

	}

	public static boolean checkMobileNo(long mobileNumber) throws ValidationException {
		boolean isValidPattern = false;
		String mobileNumberString = Long.toString(mobileNumber);
		Pattern p = Pattern.compile("[6-9]{1}[0-9]{9}");
		Matcher m = p.matcher(mobileNumberString);
		isValidPattern = (m.find() && m.group().equals(mobileNumberString));
		if (!isValidPattern) {
			throw new ValidationException("Invalid Mobile No ");
		}
		return isValidPattern;
	}

}
