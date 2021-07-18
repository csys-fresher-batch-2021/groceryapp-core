package in.grocery.service;

import java.util.List;

import in.grocery.model.CustomerItems;
import in.grocery.model.GroupCustomerItems;
import in.grocery.util.Logger;

public class CustomerItemsServiceTest {

	public static void main(String[] args) {

		// insertCustomerItems();
		// getCustomerItems();
		getGroupCustomerItems();
		// deleteProduct();

	}

	public static void insertCustomerItems() {

		CustomerItemsService.addCustomerItems(303, 210, 30, 2);

	}

	public static void getCustomerItems() {

		List<CustomerItems> customer = CustomerItemsService.getCustomerItems();

		for (CustomerItems customers : customer) {
			Logger.debug(customers);
		}

	}

	public static void getGroupCustomerItems() {

		List<GroupCustomerItems> customer = CustomerItemsService.getGroupCustomer();

		for (GroupCustomerItems customers : customer) {
			Logger.debug(customers);
		}

	}

	public static void deleteProduct() {

		CustomerItemsService.removeProducts(303, 210);

	}

}
