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
			System.out.println("1.회원가입 	   2.로그인    3.IDㆍPW찾기");
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
		
		
		menu = 0;
		run = true;
		
		do {
			System.out.println("================================================");
			System.out.println("1.음식 이름으로 찾기		2.가격대로 찾기		3.가게별 찾기");
			System.out.println("4.장바구니 확인 			5.결제하기		 	6.종료");
			System.out.println("================================================");
			System.out.print("메뉴 선택 >> ");
			
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:			// 음식 이름으로 찾기
				System.out.println("찾으실 음식 이름을 입력해 주세요!");
				String FName = sc.next();
				sql.searchN(FName);
				break;
			case 2:			// 가격대로 찾기
				System.out.println("원하시는 가격대 두개를 입력해주세요!");
				System.out.println("첫번째 가격을 입력해주세요");
				int f = sc.nextInt();
				System.out.println("두번째 가격을 입력해주세요");
				int s = sc.nextInt();
				sql.searchP(f,s);
				
				break;
			case 3:			// 가게별 찾기
				break;
			case 4:			// 장바구니 확인  -> 음식 취소 포함
				break;
			case 5:			// 결제하기	
				break;
			case 6:			// 종료
				
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요");
				break;
			}
			
		} while(run);
		
		
		
		
	}

}


