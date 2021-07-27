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
		con = DBC.DBconnect();	
			
	}

	public void insert(User user) {
		String sql = "INSERT INTO P_USER VALUES(?,?,?,?,?,TO_DATE(?))";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getU_id());
			pstmt.setInt(2, user.getU_pw());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void searchN(String fName) {
		// TODO Auto-generated method stub
		String sql = "select * FROM FOOD WHERE F_SNAME LIKE '%?%'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fName);
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("검색에 성공했습니다.");
			}
			else
			{
				System.out.println("검색에 실패했습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
