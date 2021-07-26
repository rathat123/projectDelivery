package project배달;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		User user = new User();
		Shop shop = new Shop();
		Food food = new Food();
		Order order = new Order();
		SQL sql = new SQL();
		
		boolean run = true;
		int menu = 0;
		
		sql.connect();
		
		do {
			System.out.println("==================================");
			System.out.println("1.회원가입    2.로그인    3.IDㆍPW찾기");
			System.out.println("==================================");
			System.out.print("메뉴 선택 >> ");
			
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:			//회원 가입
				System.out.print("아이디 >> ");
				String u_id = sc.next();
				
				System.out.print("비밀번호(4자리) >> ");
				int u_pw = sc.nextInt();
				
				System.out.print("이름 >> ");
				String u_name = sc.next();
				
				System.out.print("주소 >> ");
				sc.nextLine();
				String u_addr = sc.nextLine();
				
				
				System.out.print("핸드폰번호 >> ");
				String u_phone = sc.next();
				
				System.out.print("생년월일(ex. 20210727) >> ");
				String u_birth = sc.next();
				
				user.setU_id(u_id);
				user.setU_pw(u_pw);
				user.setU_name(u_name);
				user.setU_addr(u_addr);
				user.setU_phone(u_phone);
				user.setU_birth(u_birth);
				
				sql.insert(user);
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			}
			
		} while(run);
		

	}

}
