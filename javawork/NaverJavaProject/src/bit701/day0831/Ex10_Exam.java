package bit701.day0831;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex10_Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*
	 * 1.상품명 과 수량, 단가를 각각 입력받은후 총 금액을 출력하시오
	 * 2. 그리고 수량이 5개 이상일경우 10프로 할인된 최종 금액도 출력해주세요
	 *  
	 * 
	 * (예)
	 * 상품명 : 딸기
	 * 수량: 6
	 * 단가 :1000
	 * 
	 * 총금액 : 6000원
	 * 5개 이상 10프로 할인된 금액 : 5400원 
	 * 
	 */
		
		System.out.println("상품명을 입력해주세요");
		Scanner sc=new Scanner(System.in); // 키보드 입력을 위해 System.in
		String product =sc.nextLine();
		
		if(!product.equals("딸기"))
		{
			System.out.println("딸기만 판매가 가능합니다. 다시 주문해주세요.");
			return;
		}
			
		
		System.out.println("수량을 입력해주세요");
		int num =sc.nextInt();
		
		
	    int price = 1000;//상품 가격
		int total = num*price; //총 금액
		int dc = 0; // 할인된 금액 초기값 선언
		dc=num>=5?dc=total-(total/10):total; // 할인된 최종 금액 계산
		
		
		NumberFormat numberFormat1 = NumberFormat.getInstance(); //넘버포맷을 사용하기 위한 변수 생성
		String price1=numberFormat1.format(price);
		String num1=numberFormat1.format(num);
		String total1=numberFormat1.format(total);
		String dc1=numberFormat1.format(dc);
		
		//if문 사용
		//수문 수량이 5 이상일때
		if(num>=5)
		System.out.printf("\n상품명 :%s\n수량:%s개\n단가:%s원\n총금액:%s원\n5개 이상 10프로 할인된 금액: %s원\n\n",product,num1,price1,total1,dc1);
		
		else
		System.out.printf("\n상품명 :%s\n 수량:%s개\n 단가:%s원\n 총금액:%s원\n\n ",product,num1,price1,total1);
			
//		스위치문 사용 
//		dc=num>=5?dc=total-(total/10):total; //5개 이상 or 그렇지 않을경우 
		switch(num)
		{
		case  0:
		
		System.out.printf("상품명 :%s\n 수량:%s개\n 단가:%s원\n 총금액:%s원\n ",product,num1,price1,total1);
		break;
		
		case  1:
			System.out.printf("상품명 :%s\n 수량:%s개\n 단가:%s원\n 총금액:%s원\n ",product,num1,price1,total1);
			break;
			
		case  2:
			System.out.printf("상품명 :%s\n 수량:%s개\n 단가:%s원\n 총금액:%s원\n ",product,num1,price1,total1);
			break;
			
		case  3:
			System.out.printf("상품명 :%s\n 수량:%s개\n 단가:%s원\n 총금액:%s원\n ",product,num1,price1,total1);
			break;
			
		case  4:
			System.out.printf("상품명 :%s\n 수량:%s개\n 단가:%s원\n 총금액:%s원\n ",product,num1,price1,total1);
			break;
			
		default :
	
			System.out.printf("상품명 :%s\n수량:%s개\n단가:%s원\n총금액:%s원\n5개 이상 10프로 할인된 금액: %s원",product,num1,price1,total1,dc1);
			
		}//스위치문 끝
		
	 
		
		
	}//메인 메서드 끝
}
