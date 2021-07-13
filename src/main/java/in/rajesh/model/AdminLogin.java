package in.rajesh.model;

import in.rajesh.validator.*;

import java.sql.SQLException;

import in.rajesh.DAO.AdminListDAO;

public class AdminLogin {
	
	public static boolean admin(long mobileNumber, String password) throws Exception {
		boolean isValidMobileNumber = MobileNoValidation.checkMobileNo(mobileNumber);// To check the // //
																								// mobilenumber format
		boolean isValidPassword = PasswordValidation.checkPassword(password);// To check the password format
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
