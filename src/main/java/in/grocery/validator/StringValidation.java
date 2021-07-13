package in.grocery.validator;

public class StringValidation {
	
	public static boolean checkString(String name) {
		
		if (name == null || name.trim().equals("")) {
			return false;
		} 
		return true;
	}

}
