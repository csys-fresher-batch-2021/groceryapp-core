package in.grocery.validator;

public class MobileNoValidationTest {

	public static void main(String[] args) {

		// isValidMobileNo(9876543251L);
		// isInValidMobileNo(98765451L);
	}

	public static void isValidMobileNo(long mn) {
		try {
			MobileNoValidation.checkMobileNo(mn);
			System.out.println("Valid Mobile Number ");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Exception :  " + errorMessage);
			e.printStackTrace();
		}
	}

	public static void isInValidMobileNo(long mn) {
		try {
			MobileNoValidation.checkMobileNo(mn);
			System.out.println("Valid Mobile Number ");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Exception :  " + errorMessage);
			e.printStackTrace();
		}
	}

}
