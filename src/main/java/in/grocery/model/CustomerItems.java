package in.grocery.model;

import java.time.LocalDateTime;

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

}
