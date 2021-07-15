package in.grocery.model;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import in.grocery.dao.CustomerItemsDAO;

public class CustomerItems {

	private int cusId;
	private int proId;
	private double price;
	private double quantity;
	private double gstPirce;
	private double netPrice;
	private LocalDateTime purhaseTime;

	@Override
	public String toString() {
		return "CustomerItems [cusId=" + cusId + ", proId=" + proId + ", price=" + price + ", quantity=" + quantity
				+ ", gstPirce=" + gstPirce + ", netPrice=" + netPrice + ", purhaseTime=" + purhaseTime + "]";
	}

	public CustomerItems(int cusId, int proId, double price, double quantity, double gstPirce, double netPrice,
			LocalDateTime purhaseTime) {
		super();
		this.cusId = cusId;
		this.proId = proId;
		this.price = price;
		this.quantity = quantity;
		this.gstPirce = gstPirce;
		this.netPrice = netPrice;
		this.purhaseTime = purhaseTime;
	}

	public static void main(String[] args) {

		try {
			ArrayList<CustomerItems> showCustomerItemsDetails = CustomerItemsDAO.showCustomerItemsDetails();
			for (CustomerItems customerItems : showCustomerItemsDetails) {
				System.out.println(customerItems);
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
