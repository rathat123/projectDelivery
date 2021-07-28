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
		sql.orderAll();
		
		do {
			System.out.println("==================================");
			System.out.println("1.회원가입          2.로그인          3.IDㆍPW찾기");
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
			case 2:		//로그인
				System.out.print("아이디 >> ");
                u_id = sc.next();

                System.out.print("비밀번호(4자리) >> ");
                u_pw = sc.nextInt();

                boolean check = sql.idCheck(u_id,u_pw);	

                if(check) {
                    System.out.println("로그인 했습니다.");  
                    sql.shopname();
                    System.out.println("");
                    run = false;
                }else {
                    System.out.println("로그인 실패 ");
                }
				break;
			case 3:
				System.out.print("1.아이디 찾기  2.비밀번호 찾기 >> ");
				int num = sc.nextInt();
				
				if(num == 1) {
					System.out.print("이름 >> ");
					u_name = sc.next();
					
					System.out.print("생년월일 >> ");
					u_birth = sc.next();
					
					boolean check1 = sql.nbCheck(u_name,u_birth);
		
					
				} else if(num == 2) {
					System.out.print("아이디 >> ");
					u_id = sc.next();
					
					System.out.print("이름 >> ");
					u_name = sc.next();
					
					System.out.print("생년월일 >> ");
					u_birth = sc.next();
					
					boolean check2 = sql.inbCheck(u_id,u_name,u_birth);
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
				
				break;
				
			default :
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			
			
		} while(run);
		
		
		menu = 0;
		run = true;
		
		do {
			System.out.println("================================================");
			System.out.println("1.음식 이름으로 찾기          2.가격대로 찾기          3.가게별 찾기");
			System.out.println("4.장바구니                       5.결제하기                6.종료");
			System.out.println("================================================");
			System.out.print("메뉴 선택 >> ");
			
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:			// 음식 이름으로 찾기
				sql.searchN();
				break;
			case 2:			// 가격대로 찾기
				System.out.println("원하시는 가격대 두개를 입력해주세요!");
				System.out.println("얼마의 가격부터 찾으시나요?");
				int f = sc.nextInt();
				System.out.println("최대 얼마까지 찾아보고 싶으세요?");
				int s = sc.nextInt();
				sql.searchP(f,s);
				break;
			case 3:			// 가게별 찾기
				System.out.println("찾으실 가게 이름을 입력해 주세요!");
				String shopname = sc.next();
				sql.searchS(shopname);
				break;
			case 4:			// 장바구니  -> 음식 취소 포함
				sql.showOrder();
				sql.dropOrder();
				break;
			case 5:			// 결제하기	
				sql.checkout();
				run = false;
				break;
			case 6:			// 종료
				sql.quit();
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요");
				break;
			}
			
		} while(run);
		
		
		
		
	}

}


