package in.grocery.model;

import in.grocery.util.Logger;

public class CustomerTest {

	public static void main(String[] args) {

		Customers customer = new Customers(200, "rajesh", "chennai", 9876543210l, "Helloworld$4", "ACTIVE");
		Customers customer1 = new Customers();

		customer1.setCusId(201);
		customer1.setCusAddress("ambattur");

		Logger.debug(customer1.getCusId() + "  " + customer1.getCusAddress());
		Logger.debug(customer);

	}

}
