package bit701.day0905;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex01_bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//while 문 사용 (안에는 switch 문으로) 
		
		//스캐너
		Scanner sc=new Scanner(System.in);
		NumberFormat num = NumberFormat.getInstance();
//		int money=0;
		int money=0;
		int total=0;
		int ch =0;
		
		
		Exit:
		while(true) 
		{
			System.out.println("=".repeat(32));
			System.out.println("1.예금| 2.출금 | 3.잔고 | 4.종료");
			System.out.println("=".repeat(32));
			System.out.println("선택>");
			
			ch=Integer.parseInt(sc.nextLine());
			
			switch(ch)
			{
				case 1 : 
					
					System.out.println("예금액>");
					money=Integer.parseInt(sc.nextLine());
				total+=money;
				break;
				
				case 2 :
					System.out.println("출금액>");
					money=Integer.parseInt(sc.nextLine());
						if(total-money<0) {
							System.out.println("잔고가 부족합니다.");
							System.out.println("잔고>"+num.format(total));
							System.out.println("출금 입력금액>"+num.format(money));
							System.out.println();
							System.out.println();
						}
						
						total-=money;
				break;
				
				case 3 :
					System.out.println("잔고>"+num.format(money));
					break;
					
				case 4 :
					System.out.println();
					System.out.println("프로그램 종료");
					break Exit;
				
				default :
					System.out.println("잘못된 번호를 입력했습니다.");
					System.out.println();
					System.out.println();
					break;
			
			
			} // 스위치 끝
		}// 와일끝
	}

}
