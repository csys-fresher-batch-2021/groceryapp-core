package in.grocery.validator;

public class StringValidationTest {

	static void isValidString() {

		String name = "rajesh";

		if (StringValidation.checkString(name)) {
			System.out.println("Valid String Data");
		} else {
			System.out.println("Invalid String Data");
		}
	}

	static void isInValidString() {

		String name = "";

		if (StringValidation.checkString(name)) {
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
