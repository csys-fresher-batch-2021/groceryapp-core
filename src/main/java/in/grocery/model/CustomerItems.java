package in.grocery.model;

import java.time.LocalDateTime;

public class CustomerItems {

	private int cusId;
	private int proId;
	private double price;
	private double quantity;
	private double gstPrice;
	private double netPrice;
	private LocalDateTime purhaseTime;

	@Override
	public String toString() {
		return "CustomerItems [cusId=" + cusId + ", proId=" + proId + ", price=" + price + ", quantity=" + quantity
				+ ", gstPirce=" + gstPrice + ", netPrice=" + netPrice + ", purhaseTime=" + purhaseTime + "]";
	}

	public CustomerItems(int cusId, int proId, double price, double quantity, double gstPirce, double netPrice,
			LocalDateTime purhaseTime) {
		super();
		this.cusId = cusId;
		this.proId = proId;
		this.price = price;
		this.quantity = quantity;
		this.gstPrice = gstPirce;
		this.netPrice = netPrice;
		this.purhaseTime = purhaseTime;
	}

	public CustomerItems() {

	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getGstPirce() {
		return gstPrice;
	}

	public void setGstPirce(double gstPirce) {
		this.gstPrice = gstPirce;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	public LocalDateTime getPurhaseTime() {
		return purhaseTime;
	}

	public void setPurhaseTime(LocalDateTime purhaseTime) {
		this.purhaseTime = purhaseTime;
	}

}
