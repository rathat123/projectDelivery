package project배달;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	public static Connection DBconnect() {
		Connection con = null;

		String user = "rathat";
		String password = "1111";

		String url = "jdbc:oracle:thin:@localhost:1521:XE";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException cne) {
			System.out.println("DB접속 실패 : 드라이버 로딩 실패!");
			cne.printStackTrace();
		} catch (SQLException se) {
			System.out.println("DB접속 실패 : DB계정 주소 확인!");
			se.printStackTrace();
		}

		return con;

	}
}
