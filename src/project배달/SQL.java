package project배달;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SQL {

	
	// 1. DB접속
	Connection con = null;
			
	// 2. DB데이터 보내기
	Statement stmt = null;
	PreparedStatement pstmt = null; // ? 가 '문자'로 인식
			
	// 3. DB데이터 받기
	ResultSet rs = null;
	
	// [1} DB접속
	public void connect() {
		con = DBC.DBConnect();	
			
	}

	public void insert(User user) {
		String sql = "INSERT INTO USER VALUES(?,?,?,?,?,TO_DATE(?))";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getU_id());
			pstmt.setInt(2, user.getU_pw());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	

}
