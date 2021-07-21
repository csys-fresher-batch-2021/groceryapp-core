package in.grocery.validator;

public class QuantityValidation {

	private QuantityValidation() {

	}

	public static boolean checkQuantity(int quantity) {

		boolean flag = false;

		if (quantity > 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

}
