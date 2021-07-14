package in.grocery.validator;

public class NameValidationTest {

	static void isValidString() {

		String name = "rajesh";

		if (NameValidation.checkName(name)) {
			System.out.println("Valid String Data");
		} else {
			System.out.println("Invalid String Data");
		}
	}

	static void isInValidString() {

		String name = "";

		if (NameValidation.checkName(name)) {
			System.out.println("Valid String Data");
		} else {
			System.out.println("Invalid String Data");
		}
	}

	public static void main(String[] args) {
		// isValidString();
		isInValidString();
	}

}
