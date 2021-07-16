package in.grocery.model;

public class Grocery {

	int proId;
	String proName;
	String category;
	double price;
	double quantity;

	public Grocery(int proId, String proName, String category, double price, double quantity) {

		this.proId = proId;
		this.proName = proName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Items [item_id=" + proId + ", name=" + proName + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

}
