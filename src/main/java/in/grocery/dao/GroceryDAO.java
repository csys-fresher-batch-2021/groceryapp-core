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
			String sql = "select product_id,product_name,category,price,available_quantity from grocery";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			groceryList = new ArrayList<Grocery>();
			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				String category = rs.getString("category");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("available_quantity");

				Grocery grocery = new Grocery(id, name, category, price, quantity);
				groceryList.add(grocery);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, ps, con);
		}
		return groceryList;
	}
	
	public static void removeGrocery(int proId)
			throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "delete grocery where product_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, proId);

			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println(count + " row deleted");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
	}
	
	public static void updateGroceryPrice(int proId, double proPrice)
			throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update grocery set price = ? where product_id= ?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, proPrice);
			ps.setInt(2, proId);
			
			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println(count + " row updated");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
	}
	
	public static void updateGroceryQuantity(int proId, double proQuantity)
			throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update grocery set available_quantity = ? where product_id= ?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, proQuantity);
			ps.setInt(2, proId);
			
			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println(count + " row updated");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
	}

}
