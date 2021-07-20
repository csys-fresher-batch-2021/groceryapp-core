package in.grocery.validator;

public class QuantityValidation {
	
	private QuantityValidation() {
		
	}
	
	public static boolean checkQuantity(int quantity) {

		if (quantity > 0) {
			return true;
		} else {
			return false;
		}
	}

}
