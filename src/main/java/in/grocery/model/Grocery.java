package in.grocery.model;

public class Grocery {
	
	public int itemId;
	public String itemName;
	public String category;
	public double price;
	public int quantity;
	
	public Grocery(int itemId, String itemName, String category, double price, int quantity) {

		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Items [item_id=" + itemId + ", name=" + itemName + ", category=" + category + ", price=" + price + ", quantity="+ quantity + "]";
	}
}
