package in.grocery.model;

import in.grocery.validator.*;
import in.grocery.dao.*;

import java.sql.SQLException;


public class AdminLogin {
	
	public static boolean admin(long mobileNumber, String password) throws Exception {
		boolean isValidMobileNumber = MobileNoValidation.checkMobileNo(mobileNumber);
		
		boolean isValidPassword = PasswordValidation.checkPassword(password);
		boolean isAdmin = false;
		if (isValidMobileNumber && isValidPassword) {
			try {
				isAdmin = AdminListDAO.isAdmin(mobileNumber, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isAdmin;
	}

}
