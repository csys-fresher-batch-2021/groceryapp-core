package in.grocery.model;

public class GroupCustomerItems {

	private int goupCusId;
	private double groupPrice;
	private double groupGstPrice;
	private double groupNetPrice;

	@Override
	public String toString() {
		return "GroupCustomerItems [goupCusId=" + goupCusId + ", groupPrice=" + groupPrice + ", groupGstPrice="
				+ groupGstPrice + ", groupNetPrice=" + groupNetPrice + "]";
	}

	public GroupCustomerItems(int goupCusId, double groupPrice, double groupGstPrice, double groupNetPrice) {
		super();
		this.goupCusId = goupCusId;
		this.groupPrice = groupPrice;
		this.groupGstPrice = groupGstPrice;
		this.groupNetPrice = groupNetPrice;
	}

	public GroupCustomerItems() {

	}

	public int getGoupCusId() {
		return goupCusId;
	}

	public void setGoupCusId(int goupCusId) {
		this.goupCusId = goupCusId;
	}

	public double getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(double groupPrice) {
		this.groupPrice = groupPrice;
	}

	public double getGroupGstPrice() {
		return groupGstPrice;
	}

	public void setGroupGstPrice(double groupGstPrice) {
		this.groupGstPrice = groupGstPrice;
	}

	public double getGroupNetPrice() {
		return groupNetPrice;
	}

	public void setGroupNetPrice(double groupNetPrice) {
		this.groupNetPrice = groupNetPrice;
	}

}
