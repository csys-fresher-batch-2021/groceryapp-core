package in.grocery.dao;

import java.sql.SQLException;
import java.util.List;

import in.grocery.dao.CustomerLogin;
import in.grocery.service.IsValiddata;

public class CustomerLoginTest {
	
	public static void main(String[] args) throws Exception {
		
		//checkCustomerDetails();
		addCustomer();
		
	}

	public static void addCustomer() throws ClassNotFoundException, SQLException {
		long mobileNo = 6987452310l;
		String password = "Elumalai12.#";
		String name = "elumalai";
		if(IsValiddata.isValid(mobileNo, password, name)) {
			CustomerLogin.addCustomer(305,name,mobileNo,password);
		}
	}

	public static void checkCustomerDetails() throws Exception, SQLException, ClassNotFoundException {
		boolean temp = CustomerLogin.isCustomer(9824356128l, "grocer123");
		System.out.println(temp);
		
		List<Long> cusMobileNo = CustomerLogin.getMobileNumber();
		System.out.println(cusMobileNo);
	}

}
