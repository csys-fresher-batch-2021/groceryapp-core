package in.grocery.validator;

public class IdPriceValidation {

	private IdPriceValidation() {

	}

	public static boolean checkId(int id) {

		boolean flag = false;

		if (id >= 100) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public static boolean checkPrice(int price) {

		boolean flag = false;

		if (price >= 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

}
