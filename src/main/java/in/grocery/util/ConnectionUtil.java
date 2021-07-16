package in.grocery.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	/**
	 * Hiding my driverclass name , connection url , username and password 
	 * For security purpose
	 */
	
	static String driverClass = System.getenv("DB_DRIVER_NAME");
	static String url = System.getenv("DB_URL"); 
	static String username = System.getenv("DB_USERNAME");
	static String password = System.getenv("DB_PW");

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driverClass);
		return DriverManager.getConnection(url, username, password);
	}

	public static void close(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pst, Connection connection) {
		try {
			if (pst != null) {
				pst.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// suppress exception
		}
	}

	public static void close(ResultSet rs, PreparedStatement pst, Connection connection) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// suppress exception
		}
	}

}
