package in.grocery.model;

public class Grocery {

	private int proId;
	private String proName;
	private String category;
	private double price;
	private double quantity;

	public Grocery(int proId, String proName, String category, double price, double quantity) {

		this.proId = proId;
		this.proName = proName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	public Grocery() {

	}

	@Override
	public String toString() {
		return "Items [item_id=" + proId + ", name=" + proName + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

}
