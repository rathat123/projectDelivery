package project배달;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQL {
	Scanner sc = new Scanner(System.in);

	// 1. DB접속
	Connection con = null;

	// 2. DB데이터 보내기
	Statement stmt = null;
	PreparedStatement pstmt = null; // ? 가 '문자'로 인식

	// 3. DB데이터 받기
	ResultSet rs = null;
	ResultSet rs2 = null;

	User user = new User();
	
	// [1} DB접속
	public void connect() {
		con = DBC.DBconnect();

	}

	public void insert(User user) {
		String sql = "INSERT INTO P_USER VALUES(?,?,?,?,?,TO_DATE(?),?)";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user.getU_id());
			pstmt.setInt(2, user.getU_pw());
			pstmt.setString(3, user.getU_name());
			pstmt.setString(4, user.getU_addr());
			pstmt.setString(5, user.getU_phone());
			pstmt.setString(6, user.getU_birth());
			pstmt.setInt(7, 1);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean idCheck(String u_id, int u_pw) {
		boolean result = false;

		String sql = "SELECT * FROM P_USER WHERE U_ID = ? AND U_PW = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_id);
			pstmt.setInt(2, u_pw);

			rs = pstmt.executeQuery();

			if (rs.next()) { // SELECT문의 결과가 존재한다면
				result = true;
			} else { // 존재하지 않는다면
				result = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean nbCheck(String u_name, String u_birth) {

		boolean result = false;

		String sql = "SELECT U_ID FROM P_USER WHERE U_NAME = ? AND U_BIRTH = TO_DATE(?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_name);
			pstmt.setString(2, u_birth);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = true;
				System.out.println("아이디는 " + rs.getString(1));
			} else {
				System.out.println("입력한 회원정보에 일치하는 아이디가 없습니다.");
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public boolean inbCheck(String u_id, String u_name, String u_birth) {
		boolean result = false;

		String sql = "SELECT U_PW FROM P_USER WHERE U_ID = ? AND U_NAME = ? AND U_BIRTH = TO_DATE(?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_id);
			pstmt.setString(2, u_name);
			pstmt.setString(3, u_birth);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = true;
				System.out.println("비밀번호는 " + rs.getString(1));
			} else {
				System.out.println("입력한 회원정보에 일치하는 비밀번호가 없습니다.");
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public void shopname() {

		String sql = "SELECT S_NAME, S_PHONE FROM SHOP";
 
		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			
			System.out.println("================================================");

			while (rs.next()) {
				System.out.print("가게이름 : " + rs.getString(1) + "          \t");
				System.out.println("가게번호 : " + rs.getString(2));
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

	public void searchN() {
		String sql = "SELECT * FROM FOOD WHERE F_NAME LIKE '%'||?||'%'";
		System.out.println("찾으실 음식 이름을 입력해 주세요!");
		String name = sc.next();
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.print("가게이름 : " + rs.getString(1) + "\t");
				System.out.print("음식이름 : " + rs.getString(2) + "\t");
				System.out.println("가격 : " + rs.getString(3));
			}

			if(rs.getRow()<=0) {
				System.out.println("검색 결과가 없습니다.");
			}
			else {
				selectF();//음식 주문 메소드 호출
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchP(int sel) {
		// TODO Auto-generated method stub
		boolean run = true;
		int min = 0;
		int max = 0;
		do {
		
		switch(sel)
		{
		case 1:
			min = 0;
			max = 50000;
			run = false;
			break;
		case 2:
			min = 0;
			max = 10000;
			run = false;
			break;
		case 3:
			min = 10000;
			max = 15000;
			run = false;
			break;
		case 4:
			min = 15000;
			max = 20000;
			run = false;
			break;
			default:
				System.out.println("다시선택해주세요");
				break;
			
		}
		}while(run);
		String sql = "SELECT * FROM FOOD WHERE F_PRICE BETWEEN ? and ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.print("가게이름 : " + rs.getString(1) + "\t");
				System.out.print("음식이름 : " + rs.getString(2) + "\t");
				System.out.println("가격 : " + rs.getString(3));
			}

			if(rs.getRow()<=0) {
				System.out.println("검색 결과가 없습니다.");
			}
			else {
				selectF();//음식 주문 메소드 호출
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void searchS(String shopname) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM FOOD WHERE F_SNAME LIKE '%'||?||'%'";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, shopname);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.print("가게이름 : " + rs.getString(1) + "\t");
				System.out.print("음식이름 : " + rs.getString(2) + "\t");
				System.out.println("가격 : " + rs.getString(3));
			}

			if(rs.getRow()<=0) {
				System.out.println("검색 결과가 없습니다.");
			}
			else {
				selectF();//음식 주문 메소드 호출
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void quit() {
		// TODO Auto-generated method stub
		System.out.println("이용해 주셔서 감사합니다.");
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectF() {
		// TODO Auto-generated method stub
		boolean run = true;
		while (run) {
			System.out.println("더 주문 하실 음식이 있다면 '1' 아니면 '2' 를 입력해주세요");

			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("주문하실 음식을 정확하게 입력해 주세요.");
				String name = sc.next();
				String sql = "SELECT F_NAME, F_PRICE FROM FOOD WHERE F_NAME LIKE ?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					rs = pstmt.executeQuery();

					if (rs.next()) {
						String resultName = rs.getString(1);
						int resultPrice = rs.getInt(2);
						insertFood(resultName, resultPrice);
					} else {
						System.out.println("품목이 없습니다. 다시 확인해 주세요.");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("장바구니에 담기를 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("숫자를 다시 입력해주세요");
				break;
			}
		}
	}

	public void insertFood(String rn, int rp) {

		String sql = "INSERT INTO P_ORDER VALUES(?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rn);
			pstmt.setInt(2, rp);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(rn + "을 넣었습니다. 가격은 : " + rp);
			} else {
				System.out.println("장바구니에 담기 실패하였습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showOrder() {
		// TODO Auto-generated method stub
		String sql = "select * from P_ORDER";
		int sum = 0;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("주문하신 음식은");
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.println("가격은 : " + rs.getInt(2));
				sum += rs.getInt(2);
			}
			System.out.println("총 금액은 " + sum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dropOrder() {
		// TODO Auto-generated method stub
		System.out.println("장바구니 품목을 취소 하시겠습니까? 1. Y 2. N");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			System.out.println("1. 전체 취소      2. 부분 취소    3.종료");
			int numInside = sc.nextInt();
			switch (numInside) {
			case 1:
				orderAll();
				break;
			case 2:
				System.out.println("취소할 음식을 정확하게 입력해주세요.");
				String name = sc.next();
				orderPart(name);
				break;
			case 3:
				System.out.println("메뉴로 돌아갑니다.");
				break;
			default:
				System.out.println("다시선택해주세요.");
				break;
			}
			break;
		case 2:

			break;
		default:
			System.out.println("다시선택해주세요.");
			break;
		}
	}

	public void orderAll() {
		String sql1 = "DROP TABLE P_ORDER";
		String sql2 = "CREATE TABLE P_ORDER( O_NAME NVARCHAR2(10) NOT NULL, O_PRICE NUMBER NOT NULL)";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql1);
			rs = stmt.executeQuery(sql2);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void orderPart(String name) {
		String sql = "DELETE P_ORDER WHERE O_NAME=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeQuery();
			System.out.println(name+"가 취소되었습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void checkout(String u_id) {
		// TODO Auto-generated method stub
		System.out.println("결제 방법을 선택해주세요.");
		System.out.println("1. 무통장 입금    2. 현장결제    3.포인트로 결제 (그외는 메뉴로 갑니다.)");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			checkOut();
			quit();
			break;
		case 2:
			quit();
			break;
		case 3:
			checkPoint(u_id);
			break;
		default:
			System.out.println("메뉴로 갑니다.");
			break;
		}
	}
	
	public void checkOut() {
		String sql = "Select distinct(S_Account) from shop";
		showOrder();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println(rs.getString(1) + "계좌에 입금 해주십쇼.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public void checkPoint(String u_id) {
		String sql1 = "SELECT U_POINT FROM P_USER WHERE U_ID = ?";
		String sql2 = "select O_PRICE from P_ORDER";
		int sum = 0;
		int balance = 0;
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			stmt = con.createStatement();
			rs2 = stmt.executeQuery(sql2);
			while(rs2.next())
				 sum += rs2.getInt(1);
			if(rs.next())
			{
				balance = rs.getInt(1);
			}
			if(sum>balance)
			{
				System.out.println((sum-balance)+"포인트가 부족합니다!");
				quit();
			}
			else
			{
				discount(sum, u_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void discount(int sum,String u_id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE P_USER SET U_POINT = U_POINT - ? WHERE U_ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sum);
			pstmt.setString(2, u_id);
			pstmt.executeUpdate();
			System.out.println(sum+"결재 되었습니다.");
			quit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pointS(String u_id) {
		// TODO Auto-generated method stub
		System.out.println("얼마나 적립하시겠습니까?");
		int point = sc.nextInt();
		String sql = "UPDATE P_USER SET U_POINT = U_POINT + ? WHERE U_ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, u_id);
			System.out.println(point+"원 적립되셨습니다." + 
					"");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pointC(String u_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT U_POINT FROM P_USER WHERE U_ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				int num = rs.getInt(1);
				System.out.println(u_id+"   님의 잔액은   "+num);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}