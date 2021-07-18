package in.grocery.validator;

public class IdPriceValidation {

	private IdPriceValidation() {

	}

	public static boolean checkId(int id) {

		if (id >= 100) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkPrice(int price) {

		if (price >= 0) {
			return true;
		} else {
			return false;
		}
	}

}
