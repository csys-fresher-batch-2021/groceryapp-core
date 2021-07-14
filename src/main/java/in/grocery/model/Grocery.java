package in.grocery.model;

import java.sql.SQLException;
import java.util.ArrayList;

import in.grocery.dao.EmployeeDAO;
import in.grocery.dao.GroceryDAO;

public class Grocery {
	
	public int proId;
	public String proName;
	public String category;
	public double price;
	public int quantity;
	
	public Grocery(int proId, String proName, String category, double price, int quantity) {

		this.proId = proId;
		this.proName = proName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Items [item_id=" + proId + ", name=" + proName + ", category=" + category + ", price=" + price + ", quantity="+ quantity + "]";
	}
	
	public static void main(String[] args) {
		
		try {
			ArrayList<Grocery> showGroceryDetails = GroceryDAO.showGroceryDetails();
			for (Grocery grocery : showGroceryDetails) {
				System.out.println(grocery);
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Exception:  " +e.getMessage() );
			e.printStackTrace();
		} 
		
	}
}
