package in.grocery.dao;

import in.grocery.model.AdminLogin;

public class AdminListDAOTest {
	
	public static void main(String[] args) {
		
		//isValidAdmin();
		//isInValidAdmin();
	}

	public static void isValidAdmin() {
		try {
			AdminLogin.admin(9874563210l, "rajesh1234");
			System.out.println("Valid Admin Details");
		} catch (Exception e) {
			String errorMessage=e.getMessage();
			System.out.println("Exception : " +errorMessage);
			e.printStackTrace();
		}
	}
	
	public static void isInValidAdmin() {
		try {
			AdminLogin.admin(98745630l, "rajesh1234");
			System.out.println("Valid Admin Details");
		} catch (Exception e) {
			String errorMessage=e.getMessage();
			System.out.println("Exception : " +errorMessage);
			e.printStackTrace();
		}
	}

}