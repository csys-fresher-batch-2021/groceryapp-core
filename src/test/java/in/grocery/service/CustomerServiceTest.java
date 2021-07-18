package in.grocery.service;

import java.util.List;

import in.grocery.exception.ValidationException;
import in.grocery.model.Customers;
import in.grocery.util.Logger;

public class CustomerServiceTest {
	
	public static void main(String[] args) {
		
		//checkCustomer();
		getCustomerList();
		//addCustomer();
		//updateInActiveCustomer();
		//updateCustomerPassword();
		
	}
	
	public static void checkCustomer() {
		
		try {
			boolean checkCustomer = CustomerService.checkCustomer(8465528191l, "Rajesh@07");
			if(checkCustomer) {
				Logger.debug("Login Sucessful...");
			}
			else {
				Logger.debug("Invalid Mobile Or Password");
			}
			
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void getCustomerList() {

		List<Customers> customer = CustomerService.getCustomer();

		for (Customers customers : customer) {
			Logger.debug(customers);
		}

	}
	
	public static void addCustomer() {
		
		try {
			CustomerService.addCustomer();
			
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateInActiveCustomer() {
		
		CustomerService.updateInActiceCustomer(323);
		
	}
	
	public static void updateCustomerPassword() {
		
		try {
			CustomerService.changeCustomerPassword(8465528191l, "Rajesh@04");
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		
	}

}
