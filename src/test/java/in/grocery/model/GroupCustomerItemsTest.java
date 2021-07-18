package in.grocery.model;

import in.grocery.util.Logger;

public class GroupCustomerItemsTest {

	public static void main(String[] args) {
		
		GroupCustomerItems groupcustomer = new GroupCustomerItems(301,345,40,385);
		GroupCustomerItems groupcustomer1 = new GroupCustomerItems();
		
		groupcustomer1.setGroupGstPrice(45);
		
		Logger.debug(groupcustomer1.getGroupGstPrice());
		Logger.debug(groupcustomer);

	}

}
