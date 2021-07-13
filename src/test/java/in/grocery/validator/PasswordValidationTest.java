package in.grocery.validator;

public class PasswordValidationTest {
	
	public static void main(String[] args) {
		
		//isPassword();
		isNotPassword();
		
	}

	static void isPassword() {
		if(PasswordValidation.checkPassword("HelloWorld#8")) {
			System.out.println("Valid Password");
		}
		else {
			System.out.println("Make More Strong Your Password");
		}
	}
	static void isNotPassword() {
		if(PasswordValidation.checkPassword("Welcome987")) {
			System.out.println("Valid Password");
		}
		else {
			System.out.println("Make More Strong Your Password (Invalid)");
		}
	}
}
