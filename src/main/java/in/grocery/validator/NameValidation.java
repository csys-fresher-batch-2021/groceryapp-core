package in.grocery.validator;

public class NameValidation {

	private NameValidation() {

	}

	public static boolean checkName(String name) {

		boolean flag = false;

		if (name == null || name.trim().equals("")) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

}
