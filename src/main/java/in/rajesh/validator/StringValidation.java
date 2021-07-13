package in.rajesh.validator;

public class StringValidation {
	
	public static boolean checkString(String name) {
		boolean isValid = true;
		if (name == null || name.trim().equals("")) {
			isValid = false;
		} else {
			isValid = true;
		}
		return isValid;
	}

}
