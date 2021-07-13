package in.grocery.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	static String driverClass ="oracle.jdbc.driver.OracleDriver" ;
	static String url = "jdbc:oracle:thin:@192.168.0.20:1521:DBEBS12";
	static String username = "apps";
	static String password = "apps";
	
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

}
