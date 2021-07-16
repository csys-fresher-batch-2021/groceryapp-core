package in.grocery.model;

import java.time.LocalDateTime;

import in.grocery.util.Logger;

public class CustomerItemsTest {

	public static void main(String[] args) {

		LocalDateTime time = LocalDateTime.now();

		CustomerItems customerItems = new CustomerItems(100, 200, 30, 2, 10.3, 70.3, time);

		Logger.debug(customerItems);

	}

}
