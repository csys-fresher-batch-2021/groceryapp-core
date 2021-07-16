package in.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import in.grocery.model.CustomerItems;
import in.grocery.model.GroupCustomerItems;
import in.grocery.util.ConnectionUtil;
import in.grocery.util.Logger;

public class CustomerItemsDAO {
	
	private CustomerItemsDAO() {
		
	}

	public static void addCustomerItems(int cusId, int proId, double price, double quantity)
			throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		double gstPrice = (price * quantity) * (18.0 / 100.0);
		double netPrice = (price * quantity) + gstPrice;

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
				Logger.debug(count + " row inserted");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
	}

	public static List<CustomerItems> showCustomerItemsDetails() throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<CustomerItems> customerItemsList = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "select cus_id,product_id,price,quantity,gst_price,net_price,purchase_time from customer_items";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			customerItemsList = new ArrayList<>();
			while (rs.next()) {
				int cusId = rs.getInt(1);
				int proId = rs.getInt(2);
				double price = rs.getDouble(3);
				double quantity = rs.getDouble(4);
				double gstPrice = rs.getDouble(5);
				double netPrice = rs.getDouble(6);
				LocalDateTime purchaseTime = rs.getTimestamp("purchase_time").toLocalDateTime();

				CustomerItems customerItems = new CustomerItems(cusId, proId, price, quantity, gstPrice, netPrice,
						purchaseTime);
				
				customerItemsList.add(customerItems);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, ps, con);
		}
		return customerItemsList;
	}

	public static List<GroupCustomerItems> showCustomerPurchase() throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<GroupCustomerItems> customerItemsList = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "select cus_id,sum(price) price,sum(gst_price) total_gst,sum(net_price) grant_total from customer_items group by cus_id order by sum(net_price) desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			customerItemsList = new ArrayList<>();
			while (rs.next()) {
				int cusId = rs.getInt(1);
				double price = rs.getDouble(2);
				double gstTotal = rs.getDouble(3);
				double total = rs.getDouble(4);

				GroupCustomerItems customerItems = new GroupCustomerItems(cusId, price, gstTotal, total);
				customerItemsList.add(customerItems);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, ps, con);
		}
		return customerItemsList;
	}

}
