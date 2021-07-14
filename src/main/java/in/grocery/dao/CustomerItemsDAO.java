package in.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.grocery.util.ConnectionUtil;

public class CustomerItemsDAO {

	public static void addCustomerItems(int cusId, int proId, double price, double quantity) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		double gstPrice = (price*quantity)*(18/100);
		double netPrice = (price*quantity)+gstPrice;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into customer_items(cus_id,product_id,price,quantity,gst_price,net_price) values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cusId);
			ps.setDouble(2, proId);
			ps.setDouble(3, price);
			ps.setDouble(4, quantity);
			ps.setDouble(5, gstPrice);
			ps.setDouble(6, netPrice);
			
			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println(count + " row inserted");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
	}
	
}
