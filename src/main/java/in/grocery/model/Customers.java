package in.grocery.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import in.grocery.dao.CustomerDAO;

public class Customers {

	int cusId;
	String cusName;
	String cusAddress;
	Long cusMobileNo;
	String cusPassword;
	String cusStatus;
	
	public Customers(int cusId, String cusName, String cusAddress, Long cusMobileNo, String cusPassword,
			String cusStatus) {
		
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusAddress = cusAddress;
		this.cusMobileNo = cusMobileNo;
		this.cusPassword = cusPassword;
		this.cusStatus = cusStatus;
	}
	
	@Override
	public String toString() {
		return "Customers [cusId=" + cusId + ", cusName=" + cusName + ", cusAddress=" + cusAddress + ", cusMobileNo="
				+ cusMobileNo + ", cusPassword=" + cusPassword + ", cusStatus=" + cusStatus + "]";
	}

	public static void main(String[] args) {
		
		try {
			ArrayList<Customers> showCustomerDetails = CustomerDAO.showCustomerDetails();
			for (Customers customers : showCustomerDetails) {
				System.out.println(customers);
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception:  " +e.getMessage() );
			e.printStackTrace();
		} 
	}
	
}
