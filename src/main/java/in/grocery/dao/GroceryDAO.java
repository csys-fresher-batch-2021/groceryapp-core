package in.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.grocery.model.Employee;
import in.grocery.model.Grocery;
import in.grocery.util.ConnectionUtil;

public class GroceryDAO {

	public static ArrayList<Grocery> showGroceryDetails() throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<Grocery> groceryList = null;
		
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select product_id,product_name,category,price,quantity from grocery";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			groceryList = new ArrayList<Grocery>();
			while (rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String category=rs.getString(3);
				double price=rs.getDouble(4);
				int quantity=rs.getInt(5);
				
				Grocery grocery = new Grocery(id,name,category,price,quantity);
				//System.out.println(grocery);
				groceryList.add(grocery);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, ps, con);
		}
		return groceryList;
	}

	
}
