package in.grocery.model;

public class GroupCustomerItems {

	private int goupCusId;

	@Override
	public String toString() {
		return "GroupCustomerItems [goupCusId=" + goupCusId + ", groupPrice=" + groupPrice + ", groupGstPrice="
				+ groupGstPrice + ", groupNetPrice=" + groupNetPrice + "]";
	}

	private double groupPrice;
	private double groupGstPrice;
	private double groupNetPrice;

	public GroupCustomerItems(int goupCusId, double groupPrice, double groupGstPrice, double groupNetPrice) {
		super();
		this.goupCusId = goupCusId;
		this.groupPrice = groupPrice;
		this.groupGstPrice = groupGstPrice;
		this.groupNetPrice = groupNetPrice;
	}

}
