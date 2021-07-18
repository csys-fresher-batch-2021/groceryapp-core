package in.grocery.model;

import java.time.LocalDateTime;

import in.grocery.util.Logger;

public class CustomersItemsTest {

	public static void main(String[] args) {

		LocalDateTime time = LocalDateTime.now();

		CustomerItems customerItems = new CustomerItems(100, 200, 30, 2, 10.3, 70.3, time);
		CustomerItems customerItems1=new CustomerItems();
		
		customerItems1.setCusId(203);
		customerItems1.setGstPirce(20);

		Logger.debug(customerItems1.getCusId()+"    "+customerItems1.getGstPirce());
		Logger.debug(customerItems);

	}

}
