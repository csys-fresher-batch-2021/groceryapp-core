package in.grocery.validator;

public class NameValidation {

	public static boolean checkName(String name) {

		if (name == null || name.trim().equals("")) {
			return false;
		}
		return true;
	}

}
